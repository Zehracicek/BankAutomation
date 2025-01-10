package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class HesapActivity extends AppCompatActivity {

    private TextView balance;
    private TextView cardNumber;
    public static Hesap hesap;
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap);

        TextView tvWelcomeMessage = findViewById(R.id.welcomeText);
        TextView tvIban = findViewById(R.id.tvIban);
        cardNumber = findViewById(R.id.cardNumber);
        balance = findViewById(R.id.tvBalance);
        Button btnSendMoney = findViewById(R.id.btnSendMoney);
        Button btnPayments = findViewById(R.id.btnPayments);

        String username = getIntent().getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            tvWelcomeMessage.setText("Hoşgeldiniz, " + username);
        } else {
            tvWelcomeMessage.setText("Hoşgeldiniz,");
        }

        if (savedInstanceState == null) {
            hesap = new VisaHesap(generateRandomBalance());
        } else {
            double restoredBalance = savedInstanceState.getDouble("BALANCE");
            String restoredCardNumber = savedInstanceState.getString("CARD_NUMBER");
            hesap = new VisaHesap(restoredBalance);
            hesap.setKartNumarasi(restoredCardNumber);
        }

        cardNumber.setText(formatCardNumber(hesap.getKartNumarasi()));
        balance.setText(decimalFormat.format(hesap.getBakiye()) + " TL");
        tvIban.setText("IBAN: " + hesap.getIban());

        btnSendMoney.setOnClickListener(v -> {
            Intent intent = new Intent(HesapActivity.this, TransferActivity.class);
            intent.putExtra("BALANCE", hesap.getBakiye());
            intent.putExtra("IBAN", hesap.getIban());
            startActivityForResult(intent, 1);
        });

        btnPayments.setOnClickListener(v -> {
            Intent intent = new Intent(HesapActivity.this, Odemeler.class);
            intent.putExtra("IBAN", hesap.getIban());
            intent.putExtra("BALANCE", hesap.getBakiye());
            intent.putExtra("COMPANY", "B Telekomünikasyon");
            intent.putExtra("GSM", "5338941328");
            intent.putExtra("DATE", "30/11/2024");
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            double updatedBalance = data.getDoubleExtra("UPDATED_BALANCE", hesap.getBakiye());
            hesap.setBakiye(updatedBalance);
            updateUI();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("CARD_NUMBER", hesap.getKartNumarasi());
        outState.putDouble("BALANCE", hesap.getBakiye());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String restoredCardNumber = savedInstanceState.getString("CARD_NUMBER");
            double restoredBalance = savedInstanceState.getDouble("BALANCE");

            hesap = new VisaHesap(restoredBalance);
            hesap.setKartNumarasi(restoredCardNumber);
            updateUI();
        }
    }

    private void updateUI() {
        balance.setText(decimalFormat.format(hesap.getBakiye()) + " TL");
        cardNumber.setText(formatCardNumber(hesap.getKartNumarasi()));
    }

    private double generateRandomBalance() {
        return 10000.0 + (Math.random() * (90000.0 - 10000.0));
    }

    private String formatCardNumber(String cardNumber) {
        return cardNumber.replaceAll("(.{4})", "$1 ").trim();
    }

    public static class VisaHesap extends Hesap {
        public VisaHesap(double bakiye) {
            super("Visa", bakiye);
        }

        @Override
        public void odemeYap(double miktar) {}

        @Override
        public void paraGonder(double miktar) {}
    }
}