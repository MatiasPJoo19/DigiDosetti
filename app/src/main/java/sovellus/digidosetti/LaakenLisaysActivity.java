package sovellus.digidosetti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class LaakenLisaysActivity extends AppCompatActivity {
EditText nimi_input,aika_input,maara_input;
Button lisaa_laake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laaken_lisays);
        nimi_input = findViewById(R.id.editText_laakeennimi);
        aika_input = findViewById(R.id.editText_aika);
        maara_input = findViewById(R.id.editText_maara);
        lisaa_laake = findViewById(R.id.buttonPaivitaLaake);
        lisaa_laake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(LaakenLisaysActivity.this);
                myDB.addBook(nimi_input.getText().toString().trim(),
                        aika_input.getText().toString().trim(),
                        Integer.valueOf(maara_input.getText().toString().trim()));
            }
        });
    }
    public void openActivity3(View view) {
        Intent intent = new Intent(this, MedicinesicActivity.class);
        startActivity(intent);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}