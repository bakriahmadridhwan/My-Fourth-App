package com.example.myfourthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BiodataActivity extends AppCompatActivity {

    // Deklarasi variable
    TextView tvNamaValue, tvNIMValue, tvProdiValue;
    Button btnOther;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        // inisialisasi variable
        tvNamaValue = findViewById(R.id.tvNamaValue);
        tvNIMValue = findViewById(R.id.tvNIMValue);
        tvProdiValue = findViewById(R.id.tvProdiValue);
        btnOther = findViewById(R.id.btnOther);

        // opsi 1 : ambil dari bundle
        Bundle bundle = getIntent().getExtras();
        tvNamaValue.setText(bundle.getString("keyNama"));
        tvNIMValue.setText(bundle.getString("keyNIM"));
        tvProdiValue.setText(bundle.getString("keyProdi"));

        // pindah


        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BiodataActivity.this, FormActivity.class);
                startActivity(i);

                finish();
            }
        });

    }
}