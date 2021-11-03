package com.example.myfourthapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button btnSave, btnDelete;
    EditText etAddress, etHp, etEmail, etPassword;
    RadioButton rbMan, rbFemale;
    CheckBox cbAMCC,cbAVBC, cbKOMA;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // inisialisasi
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        etAddress = (EditText) findViewById(R.id.etAddress);
        etHp = (EditText) findViewById(R.id.etHp);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        rbMan = (RadioButton) findViewById(R.id.rbMan);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);

        cbAMCC = (CheckBox) findViewById(R.id.cbAMCC);
        cbAVBC = (CheckBox) findViewById(R.id.cbAVBC);
        cbKOMA = (CheckBox) findViewById(R.id.cbKOMA);

        spinner1 = (Spinner) findViewById(R.id.spinner);

        btnSave.setOnClickListener((View.OnClickListener) v -> {
            String inputaddress = String.valueOf(etAddress.getText().toString());
            String inputnohp = String.valueOf(etHp.getText().toString());
            String inputemail = String.valueOf(etEmail.getText().toString());
            String inputpass = String.valueOf(etPassword.getText().toString());

            String inputSpin = String.valueOf(spinner1.getSelectedItem());
            String a = "";
            String b = "";


            String jk;
            if(rbMan.isChecked()){
                jk = "Male";
            }else{
                jk = "Female";
            }

            String UKM = "";
            if(cbAMCC.isChecked()){
                UKM += "AMCC \n";
            }
            if(cbAVBC.isChecked()){
                UKM += "AVBC \n";
            }
            if(cbKOMA.isChecked()){
                UKM += "KOMA \n";
            }

            //Pengiriman
            Intent myIntent = new Intent(FormActivity.this, IdentityActivity.class);
            Bundle paket = new Bundle();
            paket.putString("Address", inputaddress);
            paket.putString("HP", inputnohp);
            paket.putString("Email", inputemail);
            paket.putString("Jenis Kelamin", jk);
            paket.putString("UKM", UKM);
            paket.putString("Password", inputpass);
            paket.putString("Kelas", inputSpin);

            myIntent.putExtras(paket);
            startActivity(myIntent);
        });

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FormActivity.this);
                // Create an alert dialog title
                alertDialogBuilder.setTitle("Warning!");
                // Create a dialog alert message
                alertDialogBuilder.setMessage("Are you sure to delete this data?")
                        .setIcon(R.drawable.ic_avatar)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                                etAddress.requestFocus();

                                Toast.makeText(getApplicationContext(), "Data Deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                // Membuat Dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // Menampilkan Dialog
                alertDialog.show();
            }
        });

    }
}