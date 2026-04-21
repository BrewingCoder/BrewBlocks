#!/usr/bin/env python3
"""
Regenerate the 16x base-mod textures from the 64x HD texture set.

Pipeline: for each HD texture, compute its per-channel mean, then apply a
proportional scaling to the corresponding vanilla stone base so that the
output's mean color matches the HD mean. Preserves base-texture detail while
shifting luminance/hue.

Vanilla base textures are extracted from the Minecraft 1.21.1 client jar
downloaded by ModDevGradle (cached under ~/.gradle/caches/neoformruntime/).

Run: `python3 tools/regen_16x.py` from the repo root.
"""
from __future__ import annotations
import sys
import tempfile
import zipfile
from pathlib import Path

try:
    from PIL import Image
except ImportError:
    sys.exit("Pillow is required: brew install pillow")

REPO = Path(__file__).resolve().parent.parent
HD_DIR = REPO / "src/main/resources/resourcepacks/brewblocks_hd/assets/brewblocks/textures/block"
OUT_DIR = REPO / "src/main/resources/assets/brewblocks/textures/block"
MC_JAR = Path.home() / ".gradle/caches/neoformruntime/artifacts/minecraft_1.21.1_client.jar"

# <brewblocks name> -> <vanilla texture>
MAPPING = {
    "abyssal_stone":           "stone",
    "abyssal_bricks":          "stone_bricks",
    "abyssal_bricks_cracked":  "cracked_stone_bricks",
    "abyssal_cobblestone":     "cobblestone",
    "abyssal_smooth_stone":    "smooth_stone",
    "quarried_stone":          "stone",
    "quarried_bricks":         "stone_bricks",
    "quarried_bricks_cracked": "cracked_stone_bricks",
    "quarried_cobblestone":    "cobblestone",
    "quarried_smooth_stone":   "smooth_stone",
    "burnt_stone":             "stone",
    "burnt_bricks":            "stone_bricks",
    "burnt_bricks_cracked":    "cracked_stone_bricks",
    "burnt_cobblestone":       "cobblestone",
    "burnt_smooth_stone":      "smooth_stone",
    "sticky_ore":              "coal_ore",
}


def extract_vanilla(dst: Path) -> dict[str, Path]:
    if not MC_JAR.exists():
        sys.exit(f"MC client jar not found: {MC_JAR}\nRun `./gradlew build` once to populate the cache.")
    out = {}
    with zipfile.ZipFile(MC_JAR) as zf:
        for vanilla in set(MAPPING.values()):
            member = f"assets/minecraft/textures/block/{vanilla}.png"
            target = dst / f"{vanilla}.png"
            with zf.open(member) as src, open(target, "wb") as f:
                f.write(src.read())
            out[vanilla] = target
    return out


def mean_rgb(img: Image.Image) -> tuple[float, float, float]:
    img = img.convert("RGBA")
    r_s = g_s = b_s = 0.0
    n = 0
    for r, g, b, a in img.getdata():
        if a == 0:
            continue
        r_s += r; g_s += g; b_s += b; n += 1
    if n == 0:
        return (128.0, 128.0, 128.0)
    return (r_s / n, g_s / n, b_s / n)


def retint(base: Image.Image, base_mean, target_mean) -> Image.Image:
    base = base.convert("RGBA")
    factors = tuple(target_mean[i] / max(base_mean[i], 1.0) for i in range(3))
    pixels = []
    for r, g, b, a in base.getdata():
        if a == 0:
            pixels.append((0, 0, 0, 0))
            continue
        pixels.append((
            max(0, min(255, int(round(r * factors[0])))),
            max(0, min(255, int(round(g * factors[1])))),
            max(0, min(255, int(round(b * factors[2])))),
            a,
        ))
    out = Image.new("RGBA", base.size)
    out.putdata(pixels)
    return out


def fmt(rgb) -> str:
    return "#{:02x}{:02x}{:02x}".format(int(rgb[0]), int(rgb[1]), int(rgb[2]))


def main() -> int:
    OUT_DIR.mkdir(parents=True, exist_ok=True)
    with tempfile.TemporaryDirectory() as td:
        vanilla_paths = extract_vanilla(Path(td))
        base_means: dict[str, tuple[float, float, float]] = {}

        for name, vanilla in MAPPING.items():
            hd_path = HD_DIR / f"{name}.png"
            if not hd_path.exists():
                print(f"  SKIP {name}: HD source missing")
                continue
            base = Image.open(vanilla_paths[vanilla])
            base_mean = base_means.setdefault(vanilla, mean_rgb(base))
            target_mean = mean_rgb(Image.open(hd_path))
            out = retint(base, base_mean, target_mean)
            out.save(OUT_DIR / f"{name}.png")
            print(f"  {name:<26} <- {vanilla:<22} base={fmt(base_mean)} target={fmt(target_mean)}")

    print(f"\nWrote {len(MAPPING)} textures to {OUT_DIR.relative_to(REPO)}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
