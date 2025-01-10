package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TelefonTalimatActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefontalimat);

        TextView tvKurumTuru = findViewById(R.id.tvKurumTuru);
        Button btnDevam = findViewById(R.id.btnDevam);

        Intent intent = getIntent();
        String kurumTuru = intent.getStringExtra("kurum_turu");

        if (kurumTuru != null) {
            tvKurumTuru.setText(kurumTuru);
        }

        btnDevam.setOnClickListener(v -> {
            Intent talimatBilgiIntent = new Intent(TelefonTalimatActivity.this, TalimatBilgiActivity.class);
            talimatBilgiIntent.putExtra("COMPANY", kurumTuru); // Seçilen kurum türünü gönder
            talimatBilgiIntent.putExtra("GSM", "5338941328"); // Örnek GSM
            talimatBilgiIntent.putExtra("DATE", "30/11/2024"); // Örnek tarih
            talimatBilgiIntent.putExtra("IBAN", HesapActivity.hesap.getIban()); // Örnek IBAN
            talimatBilgiIntent.putExtra("BALANCE", HesapActivity.hesap.getBakiye()); // Örnek bakiye
            startActivity(talimatBilgiIntent);
        });
    }
}
