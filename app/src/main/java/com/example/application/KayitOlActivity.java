package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class KayitOlActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, passwordInput;
    private MaterialButton registerButton;
    private TextView ztnbrhesap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerButton = findViewById(R.id.registerButton);
        ztnbrhesap = findViewById(R.id.ztnbrhesap);

        // Kayıt Ol butonuna tıklanınca alanların kontrolü
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Alanların boş olup olmadığını kontrol et
                if (TextUtils.isEmpty(name)) {
                    nameInput.setError("İsim alanı boş bırakılamaz!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    emailInput.setError("E-posta alanı boş bırakılamaz!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    passwordInput.setError("Şifre alanı boş bırakılamaz!");
                    return;
                }

                // Eğer tüm alanlar doluysa Giriş ekranına geç
                Toast.makeText(KayitOlActivity.this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(KayitOlActivity.this, Giris.class);
                startActivity(intent);
            }
        });

        // "Zaten bir hesabım var" metnine tıklanınca Giriş ekranına yönlendirme
        ztnbrhesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KayitOlActivity.this, Giris.class);
                startActivity(intent);
            }
        });
    }
}
