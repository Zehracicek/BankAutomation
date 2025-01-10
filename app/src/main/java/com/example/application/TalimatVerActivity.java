package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TalimatVerActivity extends AppCompatActivity {

    private LinearLayout llTalimatTuru;
    private LinearLayout llKurum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talimat_ver);

        llTalimatTuru = findViewById(R.id.llTalimatTuru);
        llKurum = findViewById(R.id.llKurum);

        llTalimatTuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TalimatVerActivity.this, "Talimat Türü seçildi!", Toast.LENGTH_SHORT).show();
                // İlgili sayfaya yönlendirebilirsiniz
            }
        });

        llKurum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TalimatVerActivity.this, KurumSecimiActivity.class);
                startActivity(intent);
            }
        });


        // Devam butonu
        findViewById(R.id.continueButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TalimatVerActivity.this, "Devam ediliyor!", Toast.LENGTH_SHORT).show();
                // Sonraki sayfaya geçiş kodu buraya gelecek
            }
        });
    }
}

