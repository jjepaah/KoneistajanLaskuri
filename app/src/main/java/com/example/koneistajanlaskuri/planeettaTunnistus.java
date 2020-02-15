package com.example.koneistajanlaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class planeettaTunnistus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String valittu = "";
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planeetta_tunnistus);

        Spinner koko = findViewById(R.id.koko);
        koko.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numOfTeeths, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        koko.setAdapter(adapter);
    }

    public String laskeValitys (String koko, double aurinkoP) {
        double ulkokeha;

        if (koko.equals("100/160")) {
            ulkokeha = 69;
        } else if (koko.equals("250/500")) {
            ulkokeha = 65;
        } else if (koko.equals("700")) {
            ulkokeha = 75;
        } else if (koko.equals("1000/1600")) {
            ulkokeha = 78;
        } else {
            ulkokeha = 0;
        }

        return df2.format(ulkokeha / aurinkoP + 1);
    }

    public void laskuri (View view) {
        TextView tulos = findViewById(R.id.testi);
        EditText aurinkoP = findViewById(R.id.aurinkoP);

        Double hampaat = Double.parseDouble(aurinkoP.getText().toString());

        tulos.setText("i = " + laskeValitys(valittu, hampaat));
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        valittu = (String) arg0.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
