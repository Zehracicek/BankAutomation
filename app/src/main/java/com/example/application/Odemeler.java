package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Odemeler extends AppCompatActivity implements ITransactionOperations {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odemeler);

        TextView tvOtomatikOdeme = findViewById(R.id.tvOtomatikOdeme);
        tvOtomatikOdeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otomatikOdeme();
            }
        });

        TextView tvFatura = findViewById(R.id.tvFatura);
        tvFatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faturaOdeme();
            }
        });
    }

    @Override
    public void otomatikOdeme() {
        Intent intent = new Intent(Odemeler.this, OtomatikOdemeActivity.class);
        startActivity(intent);
    }

    @Override
    public void faturaOdeme() {
        Intent intent = new Intent(Odemeler.this, FaturaActivity.class);
        startActivity(intent);
    }

}


/*public class Odemeler extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odemeler);

        TextView tvOtomatikOdeme = findViewById(R.id.tvOtomatikOdeme);
        tvOtomatikOdeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Odemeler.this, OtomatikOdemeActivity.class);
                startActivity(intent);
            }
        });

        TextView tvFatura = findViewById(R.id.tvFatura);
        tvFatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Odemeler.this, FaturaActivity.class);
                startActivity(intent);
            }
        });
    }
}*/
