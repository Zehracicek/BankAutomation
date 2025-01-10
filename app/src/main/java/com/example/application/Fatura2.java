package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Fatura2 extends AppCompatActivity {

    private TextView institutionName;
    private EditText phoneNumberInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura2);

        institutionName = findViewById(R.id.institutionName);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        continueButton = findViewById(R.id.continueButton);

        institutionName.setOnClickListener(v -> {
            Toast.makeText(this, "Kurum seçimi açılıyor...", Toast.LENGTH_SHORT).show();
        });

        continueButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberInput.getText().toString().trim();
            if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "Lütfen telefon numarası girin!", Toast.LENGTH_SHORT).show();
            } else {
                // Telefon numarasını Fatura3Activity'ye gönder
                Intent intent = new Intent(Fatura2.this, Fatura3Activity.class);
                intent.putExtra("PHONE_NUMBER", phoneNumber); // Veriyi Intent'e ekle
                startActivity(intent);
            }
        });
    }
}
