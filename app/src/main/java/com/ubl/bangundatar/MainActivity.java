package com.ubl.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private void loadContributors() {
        LinearLayout container = findViewById(R.id.contributorsContainer);

        List<Contributor> contributors = Arrays.asList(
                new Contributor("Aris Kurniawan", "2311510438"),
                new Contributor("Ahmad Dzaki", "2311510651")
        );

        for (Contributor contributor : contributors) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            row.setPadding(0, 8, 0, 8);

            ImageView icon = new ImageView(this);
            icon.setImageResource(R.drawable.ic_person);  // pastikan drawable ada
            icon.setColorFilter(getResources().getColor(R.color.primary));
            LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(48, 48);
            iconParams.setMargins(0, 0, 16, 0);
            icon.setLayoutParams(iconParams);

            TextView text = new TextView(this);
            text.setText(contributor.name + " – " + contributor.id);
            text.setTextSize(16);
            text.setTextColor(getResources().getColor(R.color.textPrimary));

            row.addView(icon);
            row.addView(text);
            container.addView(row);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadContributors();

        Button squareButton = findViewById(R.id.btnSquare);
        Button rectangleButton = findViewById(R.id.btnRectangle);

        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SquareActivity.class);
                startActivity(intent);
            }
        });

        rectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RectangleActivity.class);
                startActivity(intent);
            }
        });
    }
}
