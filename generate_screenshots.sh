#!/bin/bash

SRC_DIR="app/src/main"
OUT_DIR="screenshots"
SRC_OUT="$OUT_DIR/source_code"

mkdir -p "$SRC_OUT"

rm -rf "$OUT_DIR"/*

echo "📁 Copy source files to $SRC_OUT..."
find "$SRC_DIR" -type f \( -name "*.java" -o -name "*.kt" -o -name "*.xml" \) -exec cp --parents {} "$SRC_OUT" \;

echo "📸 Taking screenshots into $OUT_DIR..."

# Enter output folder before running carbon-now
pushd "$OUT_DIR" > /dev/null

find "../$SRC_DIR" -type f \( -name "*.java" -o -name "*.kt" -o -name "*.xml" \) | while read file; do
    echo " - $file"

    filename=$(basename "$file")
    name="${filename%.*}"
    ext="${filename##*.}"

    # Output just the file name with extension
    output_path="${name}.${ext}.png"

    carbon-now "$file" \
        --headless \
        --config "../.carbon-now.json" \
        --preset screenshots \
        --output "$OUT_DIR" \
        --save-as "$output_path"
done
popd > /dev/null

echo "✅ screenshots ready: $OUT_DIR"


