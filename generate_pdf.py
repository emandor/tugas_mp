import os
from weasyprint import HTML

TEMPLATE_FILE = 'report_template.html'
SCREENSHOT_DIR = 'screenshots'
OUTPUT_PDF = 'TUGAS 3 - 2311510438 - Aris Kurniawan.pdf'

# Ambil daftar file PNG dari folder screenshots
images = [f for f in os.listdir(SCREENSHOT_DIR) if f.endswith('.png')]
images.sort()

# Generate HTML potongan untuk tiap screenshot
screenshot_html = ""
for img in images:
    filename_without_ext = os.path.splitext(img)[0]
    screenshot_html += f'''
    <div class="screenshot">
      <img class="sshot" src="{SCREENSHOT_DIR}/{img}" alt="{img}">
      <div class="caption"><em>File: {filename_without_ext}</em></div>
    </div>
    '''

# Sisipkan ke template HTML
with open(TEMPLATE_FILE, 'r') as f:
    template = f.read()

html_final = template.replace('__SCREENSHOTS__', screenshot_html)

# Tulis ke file HTML hasil (opsional)
with open('report_generated.html', 'w') as f:
    f.write(html_final)

# Render jadi PDF
HTML(string=html_final, base_url='.').write_pdf(OUTPUT_PDF)

print(f"✅ PDF selesai: {OUTPUT_PDF}")

