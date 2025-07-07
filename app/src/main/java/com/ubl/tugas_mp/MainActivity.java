package com.ubl.tugas_mp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtWeight, edtHeight;
    TextView txtResult;
    Button btnCalculate, btnSearch, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnSearch = findViewById(R.id.btnSearch);
        btnShare = findViewById(R.id.btnShare);

        btnCalculate.setOnClickListener(view -> {
            String name = edtName.getText().toString();
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double height = Double.parseDouble(edtHeight.getText().toString()) / 100; // cm to m

            double bmi = weight / (height * height);
            String status;

            if (bmi < 18.5) status = "Kurus";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Gemuk";
            else status = "Obesitas";

            txtResult.setText("Hi " + name + ", BMI kamu: " + String.format("%.2f", bmi) + " (" + status + ")");
        });

        btnSearch.setOnClickListener(view -> {
            // IMPLICIT INTENT: Open Google and search "What is BMI"
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=apa+itu+bmi"));
            startActivity(intent);
        });

        btnShare.setOnClickListener(view -> {
            // EXPLICIT + putExtra via ACTION_SEND
            String name = edtName.getText().toString();
            String result = txtResult.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hasil BMI " + name);
            intent.putExtra(Intent.EXTRA_TEXT, result);
            startActivity(Intent.createChooser(intent, "Bagikan hasil via..."));
        });
    }
}
