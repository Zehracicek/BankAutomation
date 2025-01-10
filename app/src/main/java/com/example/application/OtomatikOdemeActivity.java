package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OtomatikOdemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otomatik_odeme);

        TextView btnTalimatVer = findViewById(R.id.btnTalimatVer);

        btnTalimatVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtomatikOdemeActivity.this, TalimatVerActivity.class);
                startActivity(intent);

                Toast.makeText(OtomatikOdemeActivity.this, "Talimat Ver ekranına geçiliyor.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
