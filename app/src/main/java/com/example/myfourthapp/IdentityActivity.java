package com.example.myfourthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class IdentityActivity extends AppCompatActivity {

    TextView tvAlamatValue, tvHPValue, tvEmailValue, JKValue, KelasValue, UKMValue;
    String getAlamat, getHP, getEmail, getJK, getKelas, getUKM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity);

        tvAlamatValue = findViewById(R.id.tvAlamatValue);
        tvHPValue = findViewById(R.id.tvHPValue);
        tvEmailValue = findViewById(R.id.tvEmailValue);
        JKValue = findViewById(R.id.JKValue);
        KelasValue = findViewById(R.id.KelasValue);
        UKMValue = findViewById(R.id.UKMValue);

        Bundle bundle = getIntent().getExtras();
        getAlamat = bundle.getString("Address");
        getHP = bundle.getString("HP");
        getEmail = bundle.getString("Email");
        getJK = bundle.getString("Jenis Kelamin");
        getKelas = bundle.getString("Kelas");
        getUKM = bundle.getString("UKM");

        tvAlamatValue.setText(getAlamat);
        tvHPValue.setText(getHP);
        tvEmailValue.setText(getEmail);
        JKValue.setText(getJK);
        KelasValue.setText(bundle.getString("Kelas"));
        UKMValue.setText(getUKM);

    }
}