package sovellus.digidosetti;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MedicinesicActivity extends AppCompatActivity {
    FloatingActionButton menu_btn, add_button,del_btn;
    RecyclerView recyclerView;

    MyDatabaseHelper myDB;
    ArrayList<String> laake_id, laake_nimi, laake_aika, laake_maara;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinesic);
        recyclerView = findViewById(R.id.recyclerView);
        menu_btn = (FloatingActionButton) findViewById(R.id.floatingButtonValikko);
        add_button = (FloatingActionButton) findViewById(R.id.floatingActionButtonAdd);
        del_btn = (FloatingActionButton) findViewById(R.id.floatingActionButtonDelete);

        BottomNavigationView  bottomNavigationView = findViewById(R.id.alavalikko);
        bottomNavigationView.setSelectedItemId(R.id.medicinesic);


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LisaaLaakeVoid();
            }
        });
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
        myDB = new MyDatabaseHelper(MedicinesicActivity.this);
        laake_id = new ArrayList<>();
        laake_nimi = new ArrayList<>();
        laake_aika = new ArrayList<>();
        laake_maara = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(MedicinesicActivity.this,this, laake_id, laake_nimi, laake_aika,
                laake_maara);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MedicinesicActivity.this));







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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    public void LisaaLaakeVoid(){
        startActivity(new Intent(getApplicationContext()
                                , LaakenLisaysActivity.class));     //tässä valitaan mikä activity avataan
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MedicinesicActivity.this);
                myDB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(MedicinesicActivity.this, MedicinesicActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "no data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                laake_id.add(cursor.getString(0));
                laake_nimi.add(cursor.getString(1));
                laake_aika.add(cursor.getString(2));
                laake_maara.add(cursor.getString(3));
            }
        }
    }
}