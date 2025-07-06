#!/bin/bash

# === CONFIG ===
DURATION=15
BASENAME="demo_$(date +%Y%m%d_%H%M%S)"
REMOTE_PATH="/sdcard/${BASENAME}.mp4"
LOCAL_MP4="$HOME/Downloads/${BASENAME}.mp4"
LOCAL_GIF="$HOME/Downloads/${BASENAME}.gif"

# === STEP 1: record emulator ===
echo "🎥 recording emulator $DURATION seconds..."
adb shell screenrecord --time-limit $DURATION "$REMOTE_PATH"

# === STEP 2: pull record ===
echo "⬇️ pull $LOCAL_MP4..."
adb pull "$REMOTE_PATH" "$LOCAL_MP4"

# === STEP 3: cleanup app emulator ===
adb shell rm "$REMOTE_PATH"

# === STEP 4: converting to GIF ===
echo "✨ converting GIF..."
ffmpeg -i "$LOCAL_MP4" -vf "fps=10,scale=480:-1:flags=lanczos" -c:v pam -f image2pipe - | \
    convert -delay 5 -loop 0 - "$LOCAL_GIF"

echo "✅ GIF ready: $LOCAL_GIF"
