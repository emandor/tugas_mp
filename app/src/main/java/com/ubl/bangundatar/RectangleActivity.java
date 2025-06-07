package com.ubl.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
public class RectangleActivity extends AppCompatActivity {
    EditText inputLength, inputWidth;
    TextView textResult;
    Button btnArea, btnPerimeter, btnShare;

    MaterialToolbar topAppBar;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        inputLength = findViewById(R.id.inputLength);
        inputWidth = findViewById(R.id.inputWidth);
        textResult = findViewById(R.id.textResult);
        btnArea = findViewById(R.id.btnArea);
        btnPerimeter = findViewById(R.id.btnPerimeter);
        btnShare = findViewById(R.id.btnShare);

        topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Kalkulator Persegi Panjang");

        topAppBar.setNavigationOnClickListener(v -> finish());

        btnArea.setOnClickListener(v -> {
            double length = Double.parseDouble(inputLength.getText().toString());
            double width = Double.parseDouble(inputWidth.getText().toString());
            result = length * width;
            textResult.setText("Area: " + result);
        });

        btnPerimeter.setOnClickListener(v -> {
            double length = Double.parseDouble(inputLength.getText().toString());
            double width = Double.parseDouble(inputWidth.getText().toString());
            result = 2 * (length + width);
            textResult.setText("Perimeter: " + result);
        });

        btnShare.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, textResult.getText().toString());
            startActivity(Intent.createChooser(intent, "Share result via..."));
        });
    }
}
