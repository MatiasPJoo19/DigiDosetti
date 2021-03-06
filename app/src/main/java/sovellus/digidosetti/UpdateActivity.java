package sovellus.digidosetti;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText nimi_input,aika_input,maara_input;
    Button btn_paivita,btn_poista;
    String id, nimi, aika, maara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        nimi_input = findViewById(R.id.editText_laakeennimi2);
        aika_input = findViewById(R.id.editText_aika2);
        maara_input = findViewById(R.id.editText_maara2);
        btn_paivita = findViewById(R.id.buttonPaivitaLaake);
        btn_poista = findViewById(R.id.buttonPoistaLaake);

        getAndSetIntentData();

       /* ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(nimi);
        }*/

        btn_paivita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                nimi = nimi_input.getText().toString().trim();
                aika = aika_input.getText().toString().trim();
                maara = maara_input.getText().toString().trim();
                myDB.updateData(id, nimi, aika, maara);
            }
        });
       btn_poista.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               confirmDialog();
           }
       });
        /*MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
        myDB.updateDate(id,nimi,aika,maara);*/
    }


    void getAndSetIntentData(){
       if(getIntent().hasExtra("id") && getIntent().hasExtra("nimi") &&
                getIntent().hasExtra("aika") && getIntent().hasExtra("maara")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            nimi = getIntent().getStringExtra("nimi");
            aika = getIntent().getStringExtra("aika");
            maara = getIntent().getStringExtra("maara");
           Toast.makeText(this, maara, Toast.LENGTH_SHORT).show();
            //Setting Intent Data virhe on t??ss?? jossain koska data l??ytyy ja tallentuu muutujaan nyt vain pit???? saada se laatikoihin
           nimi_input.setText(nimi);
           aika_input.setText(aika);
           maara_input.setText(maara);
            Log.d("stev", nimi+" "+aika+" "+maara);
           //Toast.makeText(this, "data l??yty.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nimi + " ?");
        builder.setMessage("Are you sure you want to delete " + nimi + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
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
}