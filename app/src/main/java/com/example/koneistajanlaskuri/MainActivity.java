package com.example.koneistajanlaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat("#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void laskeNopeus(View view) {
        EditText halkaisija = findViewById(R.id.halkaisija);
        TextView tulos = findViewById(R.id.tulos);

        double h = Double.parseDouble(halkaisija.getText().toString());
        double t = 15000 / (h * Math.PI);
        String output = df2.format(t);

        tulos.setText(output + " rpm");
    }

    public void hMitta(View view) {
        Intent intent = new Intent(this, HmittaLaskuri.class);
        startActivity(intent);
    }
    public void som(View view) {
        Intent intent = new Intent(this, planeettaTunnistus.class);
        startActivity(intent);
    }
}
