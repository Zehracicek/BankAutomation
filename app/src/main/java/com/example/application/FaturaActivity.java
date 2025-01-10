package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FaturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura1);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        RelativeLayout institutionSelection = findViewById(R.id.institutionSelection);
        institutionSelection.setOnClickListener(v -> {
            Intent intent = new Intent(FaturaActivity.this, FaturaKurumSecimiActivity.class);
            startActivity(intent);
        });

        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(v ->
                Toast.makeText(this, "Devam ediliyor...", Toast.LENGTH_SHORT).show());
    }
}
