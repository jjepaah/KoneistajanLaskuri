package com.example.koneistajanlaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class Hmitta extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hmitta);
    }

    public void hmitta(View view) {
        TextView tulos = findViewById(R.id.tulos);
        EditText halkaisija = findViewById(R.id.halkaisija);
        EditText kiilaura = findViewById(R.id.kiilaura);
        double r;   //Radius
        double l;   //Half chord length

        if (!(halkaisija.getText().toString().isEmpty() || kiilaura.getText().toString().isEmpty())) {
            r = Double.parseDouble(halkaisija.getText().toString()) / 2;
            l = Double.parseDouble(kiilaura.getText().toString()) / 2;

            if (r < l) {
                tulos.setText(getString(R.string.error));
            } else {
                Double hMitta = r - Math.sqrt(pow(r,2) - pow(l,2));
                tulos.setText(getString(R.string.hdim_total, df2.format(hMitta)));
            }
        } else {
            tulos.setText(getString(R.string.error));
        }
    }
}
