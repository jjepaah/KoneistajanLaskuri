package com.example.koneistajanlaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Valitys extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String valittu = "";
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valitys);

        Spinner koko = findViewById(R.id.koko);
        koko.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numOfTeeths, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        koko.setAdapter(adapter);
    }

    public String laskeValitys (String koko, double aurinkoP) {
        double ulkokeha;

        //Todo: Lisää loput koot ja muuta hammasluvut oikeiksi

        switch (koko) {
            case "100/160":
                ulkokeha = 69;
                break;
            case "250/500":
                ulkokeha = 65;
                break;
            case "700":
                ulkokeha = 75;
                break;
            case "1000/1600":
                ulkokeha = 78;
                break;
            default:
                ulkokeha = 0;
        }
        if (ulkokeha != 0) {
            return df2.format(ulkokeha / aurinkoP + 1);
        } else {
            return "Virhe";
        }
    }

    public void laskuri (View view) {
        TextView tulos = findViewById(R.id.testi);
        EditText aurinkoP = findViewById(R.id.aurinkoP);

        double hampaat = Double.parseDouble(aurinkoP.getText().toString());

        tulos.setText(getString(R.string.ratio_total, laskeValitys(valittu, hampaat)));
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        valittu = (String) arg0.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
