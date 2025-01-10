package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Fatura3Activity extends AppCompatActivity {

    private TextView tvBalance, tvGsmNo, tvBillAmount;
    private Button btnContinue;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura3);

        tvBalance = findViewById(R.id.tvBalance);
        tvGsmNo = findViewById(R.id.tvGsmNo);
        tvBillAmount = findViewById(R.id.tvBillAmount);
        btnContinue = findViewById(R.id.continueButton);
        backButton = findViewById(R.id.backButton);

        // Telefon numarasını Fatura2 ekranından al
        Intent intent = getIntent();
        String gsmNo = intent.getStringExtra("PHONE_NUMBER"); // Telefon numarasını al
        if (gsmNo != null) {
            tvGsmNo.setText("GSM No: " + gsmNo); // Alınan telefon numarasını TextView'e yaz
        } else {
            tvGsmNo.setText("GSM No: Bilinmiyor"); // Eğer null gelirse bir uyarı mesajı
        }

        // Fatura tutarını ayarla (statik bir değer, dinamik hale getirilebilir)
        String billAmount = "896,78 TL";
        tvBillAmount.setText("Fatura Tutarı: " + billAmount);

        btnContinue.setOnClickListener(v -> {
            Intent hesapIntent = new Intent(Fatura3Activity.this, HesapActivity.class);
            startActivity(hesapIntent);
            finish();
        });

        backButton.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        // Fatura2 ekranına geri dön
        super.onBackPressed();
        Intent intent = new Intent(Fatura3Activity.this, Fatura2.class);
        startActivity(intent);
        finish();
    }
}
