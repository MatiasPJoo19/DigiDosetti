package sovellus.digidosetti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.alavalikko);

        //ensimmäinen sivu valittu
        // tämä on home sivu

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    //tässä käynnistetään uusia activity kun iconia painaa
                    case R.id.homeic:            //ensin valitaan ideen perustella iconi jolle halutaan tapahtuma se on tässä tapauksessa märritelty menu_navigation.xml tiedostoon
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));    //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0); //halutessa voi myös lisätä animaation
                        return true;    // tämä on vain lopettamassa toiminnon että ei jää loopin

                    case R.id.bellic:         //tässä ei tarvitse vaihtaa activityä kun olla jo valmiiksi home näkymässä
                        return true;

                    case R.id.menuic:
                        startActivity(new Intent(getApplicationContext()
                                , MenuActivity.class));     //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.medicinesic:
                        startActivity(new Intent(getApplicationContext()
                                , MedicinesicActivity.class));     //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}