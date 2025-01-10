package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FaturaInternetveTelevizyon extends AppCompatActivity {

    private ListView krmListView;
    private String[] kurumListesi = {"A Net", "B Net", "C Net"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internetvetelevizyon2);

        krmListView = findViewById(R.id.kurumListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                kurumListesi
        );

        krmListView.setAdapter(adapter);

        krmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedKurum = kurumListesi[position];
                Toast.makeText(FaturaInternetveTelevizyon.this, selectedKurum + " seçildi", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FaturaInternetveTelevizyon.this, Fatura2.class);
                intent.putExtra("kurum_turu", selectedKurum);
                startActivity(intent);
            }
        });
    }
}
