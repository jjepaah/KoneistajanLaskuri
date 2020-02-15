package com.example.koneistajanlaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Pyorimisnopeus extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat("#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pyorimisnopeus);
    }

    public void laskeNopeus(View view) {
        EditText halkaisija = findViewById(R.id.halkaisija);
        TextView tulos = findViewById(R.id.tulos);

        double h = Double.parseDouble(halkaisija.getText().toString());
        double t = 15000 / (h * Math.PI);
        String output = df2.format(t);

        tulos.setText(output + " rpm");
    }
}
