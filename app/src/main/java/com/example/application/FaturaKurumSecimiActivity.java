package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FaturaKurumSecimiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurum_secimi2);

        ImageView btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView tvTelefon = findViewById(R.id.tvTelefon);
        tvTelefon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FaturaKurumSecimiActivity.this, "Telefon seçildi.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FaturaKurumSecimiActivity.this, FaturaTelefonList.class);
                startActivity(intent);
            }
        });

        TextView tvInternetTelevizyon = findViewById(R.id.tvInternetTelevizyon);
        tvInternetTelevizyon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FaturaKurumSecimiActivity.this, "İnternet ve Televizyon seçildi.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FaturaKurumSecimiActivity.this, FaturaInternetveTelevizyon.class);
                startActivity(intent);
            }
        });
    }
}
