
package sovellus.digidosetti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView  bottomNavigationView = findViewById(R.id.alavalikko);

        //ensimmäinen sivu valittu
        // tämä on home sivu

        bottomNavigationView.setSelectedItemId(R.id.homeic);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.medicinesic:
                        startActivity(new Intent(getApplicationContext()
                                , MedicinesicActivity.class));
                        overridePendingTransition(0,0);
                      //  return true;
                        break;
                    case R.id.home:
                       // return true;
                        break;
                    case R.id.bellic:
                        startActivity(new Intent(getApplicationContext()
                                , TimeActivity.class));
                        overridePendingTransition(0,0);
                      //  return true;
                        break;
                   case R.id.menuic:
                        startActivity(new Intent(getApplicationContext()
                                , MenuActivity.class));
                        overridePendingTransition(0,0);
                     //   return true;
                       break;
                }
                return false;
            }
        });
    }
}