package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FaturaTelefonList extends AppCompatActivity {

    private ListView kurumListView;
    private String[] kurumListesi = {"A Telekomünikasyon", "B Telekomünikasyon", "C Telekomünikasyon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefon_liste2);

        kurumListView = findViewById(R.id.kurumListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                kurumListesi
        );

        kurumListView.setAdapter(adapter);

        kurumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedKurum = kurumListesi[position];
                Toast.makeText(FaturaTelefonList.this, selectedKurum + " seçildi", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FaturaTelefonList.this, Fatura2.class);
                intent.putExtra("kurum_turu", selectedKurum);
                startActivity(intent);
            }
        });
    }
}
