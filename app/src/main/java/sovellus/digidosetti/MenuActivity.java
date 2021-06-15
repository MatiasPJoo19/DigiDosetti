package sovellus.digidosetti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.alavalikko);

        //ensimmäinen sivu valittu
        // tämä on home sivu

        bottomNavigationView.setSelectedItemId(R.id.menuic);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    //tässä käynnistetään uusia activity kun iconia painaa
                    case R.id.homeic:            //ensin valitaan ideen perustella iconi jolle halutaan tapahtuma se on tässä tapauksessa märritelty menu_navigation.xml tiedostoon
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));    //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0); //halutessa voi myös lisätä animaation
                       // return true;    // tämä on vain lopettamassa toiminnon että ei jää loopin
                        break;
                   case R.id.menuic:         //tässä ei tarvitse vaihtaa activityä kun olla jo valmiiksi home näkymässä
                        //return true;
                       break;

                    case R.id.bellic:
                        startActivity(new Intent(getApplicationContext()
                                , TimeActivity.class));     //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0);
                        //return true;
                        break;
                    case R.id.medicinesic:
                        startActivity(new Intent(getApplicationContext()
                                , MedicinesicActivity.class));     //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0);
                       // return true;
                        break;
                }
                return false;
            }
        });
    }
}