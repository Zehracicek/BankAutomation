package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class TalimatBilgiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talimatbilgi);

        // UI bileşenlerini tanımlama
        ImageView imgBack = findViewById(R.id.img_back);
        TextView txtIban = findViewById(R.id.txt_iban);
        TextView txtBalance = findViewById(R.id.txt_balance);
        TextView txtCompany = findViewById(R.id.txt_company);
        TextView txtGsm = findViewById(R.id.txt_gsm);
        TextView txtDate = findViewById(R.id.txt_date);
        Button btnContinue = findViewById(R.id.btn_continue);

        // Intent ile Hesap nesnesini alıyoruz
        Intent intent = getIntent();

        String company = intent.getStringExtra("COMPANY");
        String gsm = intent.getStringExtra("GSM");
        String date = intent.getStringExtra("DATE");

        // Hesap bilgilerini kontrol et
        if (HesapActivity.hesap == null) {
            Toast.makeText(this, "Hesap bilgisi eksik!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Formatlama ve verileri ekranda gösterme
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        txtIban.setText("IBAN: " + HesapActivity.hesap.getIban());
        txtBalance.setText("Bakiye: " + decimalFormat.format(HesapActivity.hesap.getBakiye()) + " TL");

        txtCompany.setText("Kurum: " + company);
        txtGsm.setText("GSM: " + gsm);
        txtDate.setText("Başlangıç Tarihi: " + date);

        imgBack.setOnClickListener(v -> onBackPressed());

        // Devam et butonu işlemi
        btnContinue.setOnClickListener(v -> {
            // Kullanıcıya işlem tamamlandı mesajı göster
            Toast.makeText(this, "Talimat başarıyla oluşturuldu!", Toast.LENGTH_SHORT).show();

            // HesapActivity'ye dön
            Intent backToAccountIntent = new Intent(this, HesapActivity.class);
            backToAccountIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(backToAccountIntent);

            // Mevcut aktiviteyi kapat
            finish();
        });
    }
}
