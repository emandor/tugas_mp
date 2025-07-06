#!/bin/bash

SRC_DIR="app/src/main"
OUT_DIR="screenshots"

mkdir -p "$OUT_DIR"

echo "📁 copy file source code..."
find "$SRC_DIR" -type f \( -name "*.java" -o -name "*.kt" -o -name "*.xml" \) -exec cp --parents {} "$OUT_DIR" \;

echo "📸 screenshot..."
find "$SRC_DIR" -type f \( -name "*.java" -o -name "*.kt" \) | while read file; do
    echo " - $file"
    carbon-now "$file" --headless --output "$OUT_DIR"
done

echo "✅ screenshots and files ready on folder: $OUT_DIR"
