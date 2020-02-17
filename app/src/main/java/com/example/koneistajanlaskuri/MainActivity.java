package com.example.koneistajanlaskuri;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.Duration;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.main_activity);
        TextView version = findViewById(R.id.versionNbr);
        version.setText(getString(R.string.version_display, BuildConfig.VERSION_NAME));

        new AppUpdater(this)
                .setDisplay(Display.SNACKBAR)
                .setDuration(Duration.INDEFINITE)
                .setUpdateFrom(UpdateFrom.GITHUB)
                .setGitHubUserAndRepo("jjepaah", "KoneistajanLaskuri")
                .start();
    }

    public void nopeus(View view) {
        Intent intent = new Intent(this, Pyorimisnopeus.class);
        startActivity(intent);
    }

    public void hMitta(View view) {
        Intent intent = new Intent(this, Hmitta.class);
        startActivity(intent);
    }
    public void som(View view) {
        Intent intent = new Intent(this, Valitys.class);
        startActivity(intent);
    }

    public void github(View view) {
        goToUrl("https://github.com/jjepaah/KoneistajanLaskuri/releases");
    }

    public void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
