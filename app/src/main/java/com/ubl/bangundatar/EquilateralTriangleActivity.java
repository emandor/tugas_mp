package com.ubl.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class EquilateralTriangleActivity extends AppCompatActivity {
    EditText inputSide;
    TextView textResult;
    Button btnArea, btnPerimeter, btnShare;

    MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilateral_triangle);

        inputSide = findViewById(R.id.inputSide);
        textResult = findViewById(R.id.textResult);
        btnArea = findViewById(R.id.btnArea);
        btnPerimeter = findViewById(R.id.btnPerimeter);
        btnShare = findViewById(R.id.btnShare);
        topAppBar = findViewById(R.id.topAppBar);


        setSupportActionBar(topAppBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Kalkulator Segitiga Sama Kaki");
        topAppBar.setNavigationOnClickListener(v -> finish());

        btnArea.setOnClickListener(v -> {
            double side = Double.parseDouble(inputSide.getText().toString());
            double result = (Math.sqrt(3) / 4) * side * side;
            textResult.setText("Luas: " + result);
        });

        btnPerimeter.setOnClickListener(v -> {
            double side = Double.parseDouble(inputSide.getText().toString());
            double result = 3 * side;
            textResult.setText("Keliling: " + result);
        });

        btnShare.setOnClickListener(v -> {
            double side = Double.parseDouble(inputSide.getText().toString());
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sharedTemplate = side + " = " +textResult.getText().toString();
            intent.putExtra(Intent.EXTRA_TEXT, sharedTemplate);
            startActivity(Intent.createChooser(intent, "Bagikan Hasil via..."));
        });
    }
}
