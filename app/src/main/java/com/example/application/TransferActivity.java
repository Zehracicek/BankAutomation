package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class TransferActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        EditText edtIban = findViewById(R.id.edt_iban);
        EditText edtAmount = findViewById(R.id.edt_amount);
        EditText edtDescription = findViewById(R.id.edt_description);
        Button btnContinue = findViewById(R.id.btn_continue);
        TextView tvCurrentBalance = findViewById(R.id.tv_current_balance);

        double initialBalance = getIntent().getDoubleExtra("BALANCE", 0.0);
        final double[] currentBalance = {initialBalance};


        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedBalance = decimalFormat.format(currentBalance[0]);


        tvCurrentBalance.setText("Bakiye: " + formattedBalance + " TL");

        btnContinue.setOnClickListener(v -> {
            String iban = edtIban.getText().toString();
            String amountStr = edtAmount.getText().toString();
            String description = edtDescription.getText().toString();


            if (iban.isEmpty() || amountStr.isEmpty()) {
                Toast.makeText(TransferActivity.this, "Lütfen tüm alanları doldurun!", Toast.LENGTH_SHORT).show();
            } else {
                double amount;
                try {
                    amount = Double.parseDouble(amountStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(TransferActivity.this, "Geçerli bir miktar girin!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (amount > currentBalance[0]) {
                    Toast.makeText(TransferActivity.this, "Yetersiz bakiye!", Toast.LENGTH_SHORT).show();
                } else {
                    currentBalance[0] -= amount;

                    String updatedFormattedBalance = decimalFormat.format(currentBalance[0]);
                    tvCurrentBalance.setText("Mevcut Bakiye: " + updatedFormattedBalance + " TL");


                    Toast.makeText(TransferActivity.this, "İşlem başarılı!", Toast.LENGTH_SHORT).show();


                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("UPDATED_BALANCE", currentBalance[0]);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
