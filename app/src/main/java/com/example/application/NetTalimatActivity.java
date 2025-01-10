package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NetTalimatActivity extends AppCompatActivity {

    private Hesap hesap;
    private TextView talimatTuru, kurumTuru;
    private EditText aboneNumarasi;
    private Button devamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nettalimat);

        hesap = new HesapActivity.VisaHesap(1000);
        talimatTuru = findViewById(R.id.talimatTuru);
        kurumTuru = findViewById(R.id.kurumTuru);
        aboneNumarasi = findViewById(R.id.aboneNumarasi);
        devamButton = findViewById(R.id.devamButton);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());


        Intent intent = getIntent();
        String gelenKurumTuru = intent.getStringExtra("kurum_turu");
        if (gelenKurumTuru != null) {
            kurumTuru.setText(gelenKurumTuru);
        }

        devamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aboneNumarasiText = aboneNumarasi.getText().toString().trim();

                if (aboneNumarasiText.isEmpty() ) {
                    Toast.makeText(NetTalimatActivity.this, "Lütfen tüm alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                } else {
                    // Verileri TalimatBilgiActivity'ye gönder
                    Intent talimatBilgiIntent = new Intent(NetTalimatActivity.this, TalimatBilgiActivity.class);
                    talimatBilgiIntent.putExtra("COMPANY", gelenKurumTuru);
                    talimatBilgiIntent.putExtra("GSM", "5338941328");
                    talimatBilgiIntent.putExtra("DATE", "30/11/2024");
                    talimatBilgiIntent.putExtra("IBAN", HesapActivity.hesap.getIban());
                    talimatBilgiIntent.putExtra("BALANCE", HesapActivity.hesap.getBakiye());
                    startActivity(talimatBilgiIntent);
                }
            }
        });
    }
}