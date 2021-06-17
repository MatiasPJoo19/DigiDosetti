package sovellus.digidosetti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sovellus.digidosetti.MedicinesicActivity;
import sovellus.digidosetti.MenuActivity;
import sovellus.digidosetti.R;
import sovellus.digidosetti.TimeActivity;

public class MedicinesicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinesic);

        BottomNavigationView  bottomNavigationView = findViewById(R.id.alavalikko);
        Button Lisaalaake = findViewById(R.id.buttonLisaaLaake);
        //ensimmäinen sivu valittu
        // tämä on home sivu

        bottomNavigationView.setSelectedItemId(R.id.medicinesic);


        Lisaalaake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LisaaLaakeVoid();
            }
        });




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.medicinesic:         //tässä ei tarvitse vaihtaa activityä kun olla jo valmiiksi home näkymässä
                        //return true;
                        break;
                    //tässä käynnistetään uusia activity kun iconia painaa
                    case R.id.homeic:            //ensin valitaan ideen perustella iconi jolle halutaan tapahtuma se on tässä tapauksessa märritelty menu_navigation.xml tiedostoon
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));    //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0); //halutessa voi myös lisätä animaation
                        //return true;    // tämä on vain lopettamassa toiminnon että ei jää loopin
                        break;
                    case R.id.bellic:
                        startActivity(new Intent(getApplicationContext()
                                , TimeActivity.class));     //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0);
                        //return true;
                        break;
                   case R.id.menuic:
                        startActivity(new Intent(getApplicationContext()
                                , MenuActivity.class));     //tässä valitaan mikä activity avataan
                        overridePendingTransition(0,0);
                        //return true;
                       break;
                }
                return false;
            }
        });
    }
    public void LisaaLaakeVoid(){
        startActivity(new Intent(getApplicationContext()
                                , LaakenLisaysActivity.class));     //tässä valitaan mikä activity avataan
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}