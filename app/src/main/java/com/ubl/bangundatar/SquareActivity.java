package com.ubl.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class SquareActivity extends AppCompatActivity {
    EditText sideInput;
    TextView resultText;
    Button areaButton, perimeterButton, shareButton;

    MaterialToolbar topAppBar;

    double result = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        sideInput = findViewById(R.id.inputSide);
        resultText = findViewById(R.id.textResult);
        areaButton = findViewById(R.id.btnArea);
        perimeterButton = findViewById(R.id.btnPerimeter);
        shareButton = findViewById(R.id.btnShare);
        topAppBar = findViewById(R.id.topAppBar);

        topAppBar.setNavigationOnClickListener(v -> finish());
        setSupportActionBar(topAppBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Kalkulator Persegi");



        areaButton.setOnClickListener(v -> {
            double side = Double.parseDouble(sideInput.getText().toString());
            result = side * side;
            resultText.setText("Luas: " + result);
        });

        perimeterButton.setOnClickListener(v -> {
            double side = Double.parseDouble(sideInput.getText().toString());
            result = 4 * side;
            resultText.setText("Keliling: " + result);
        });

        shareButton.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Bagikan hasil: " + resultText.getText().toString());
            startActivity(Intent.createChooser(shareIntent, "Bagikan hasil via..."));
        });
    }
}
