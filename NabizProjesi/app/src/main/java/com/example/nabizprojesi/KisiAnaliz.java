package com.example.nabizprojesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class KisiAnaliz extends AppCompatActivity {

    private EditText editTextAd, editTextSoyad, editTextYas, editTextNabiz;
    private Toolbar toolbarAna;
    private Button buttonAnaliz;
    private CheckBox cbErkek, cbKiz;
    private String cinsiyet = null;
    private TextView textViewAnaliz;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_analiz);

        editTextAd = findViewById(R.id.editTextIsim);
        editTextSoyad = findViewById(R.id.editTextSoyad);
        editTextNabiz = findViewById(R.id.editTextNabiz);
        editTextYas = findViewById(R.id.editTextYas);
        textViewAnaliz = findViewById(R.id.textViewAnaliz);
        cbErkek = findViewById(R.id.cbErkek);
        cbKiz = findViewById(R.id.cbKiz);
        toolbarAna = findViewById(R.id.toolbarAna);
        toolbarAna.setTitle("Kişi Analiz Sayfası");
        toolbarAna.setTitleTextColor(Color.WHITE);
        buttonAnaliz = findViewById(R.id.buttonAnaliz);


        buttonAnaliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = editTextAd.getText().toString();
                if (cbErkek.isChecked()) {
                    cinsiyet = "Erkek";
                } else if (cbKiz.isChecked()) {
                    cinsiyet = "Kadın";
                }

                if (1 < Integer.parseInt(editTextYas.getText().toString()) && Integer.parseInt(editTextYas.getText().toString()) < 10) {

                    if (70 < Integer.parseInt(editTextNabiz.getText().toString()) && Integer.parseInt(editTextNabiz.getText().toString()) < 100) {

                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşında birey için ideal nabız.");
                    } else {
                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşı için nabız uygun değil.\n Lütfen doktorunuza görünün.");
                    }

                } else if (10 < Integer.parseInt(editTextYas.getText().toString()) && Integer.parseInt(editTextYas.getText().toString()) < 18) {

                    if (73 < Integer.parseInt(editTextNabiz.getText().toString()) && Integer.parseInt(editTextNabiz.getText().toString()) < 110) {

                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşında birey için ideal nabız.");
                    } else {
                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşı için nabız uygun değil.\n Lütfen doktorunuza görünün.");
                    }

                } else if (18 < Integer.parseInt(editTextYas.getText().toString()) && Integer.parseInt(editTextYas.getText().toString()) < 35) {

                    if (75 < Integer.parseInt(editTextNabiz.getText().toString()) && Integer.parseInt(editTextNabiz.getText().toString()) < 120) {

                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşında birey için ideal nabız.");
                    } else {
                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşı için nabız uygun değil.\n Lütfen doktorunuza görünün.");
                    }

                } else if (35 < Integer.parseInt(editTextYas.getText().toString()) && Integer.parseInt(editTextYas.getText().toString()) < 50) {

                    if (80 < Integer.parseInt(editTextNabiz.getText().toString()) && Integer.parseInt(editTextNabiz.getText().toString()) < 130) {

                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşında birey için ideal nabız.");
                    } else {
                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşı için nabız uygun değil.\n Lütfen doktorunuza görünün.");
                    }

                } else if (50 < Integer.parseInt(editTextYas.getText().toString()) && Integer.parseInt(editTextYas.getText().toString()) < 70) {

                    if (85 < Integer.parseInt(editTextNabiz.getText().toString()) && Integer.parseInt(editTextNabiz.getText().toString()) < 140) {

                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşında birey için ideal nabız.");
                    } else {
                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşı için nabız uygun değil.\n Lütfen doktorunuza görünün.");
                    }

                } else if (70 < Integer.parseInt(editTextYas.getText().toString()) && Integer.parseInt(editTextYas.getText().toString()) < 90) {

                    if (87 < Integer.parseInt(editTextNabiz.getText().toString()) && Integer.parseInt(editTextNabiz.getText().toString()) < 150) {

                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşında birey için ideal nabız.");
                    } else {
                        textViewAnaliz.setText(editTextYas.getText().toString() + " yaşı için nabız uygun değil.\n Lütfen doktorunuza görünün.");
                    }

                }

            }
        });


    }
}