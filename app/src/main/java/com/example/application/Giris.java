package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class Giris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        EditText emailField = findViewById(R.id.emailInput);
        EditText passwordField = findViewById(R.id.passwordInput);
        MaterialButton loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    emailField.setError("E-posta alanı boş bırakılamaz!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    passwordField.setError("Şifre alanı boş bırakılamaz!");
                    return;
                }
                // Kullanıcıyı doğrula
                if (KullaniciGiris.kullaniciDogrula(email, password)) {
                    // Başarılı giriş
                    Intent intent = new Intent(Giris.this, HesapActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Hatalı giriş
                    Toast.makeText(Giris.this, "E-posta veya şifre hatalı!" + email + ":" + password, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
