package sovellus.digidosetti;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList laake_id, laake_nimi, laake_aika, laake_maara;

    CustomAdapter(Activity activity, Context context, ArrayList laake_id, ArrayList laake_nimi, ArrayList laake_aika,
                  ArrayList laake_maara){
        this.activity = activity;
        this.context = context;
        this.laake_id = laake_id;
        this.laake_nimi = laake_nimi;
        this.laake_aika = laake_aika;
        this.laake_maara = laake_maara;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.medi_row, parent, false);
        return new MyViewHolder(view);
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.laake_nimi_txt.setText(String.valueOf(laake_nimi.get(position)));
        holder.laake_aika_txt.setText(String.valueOf(laake_aika.get(position)));
        holder.laake_maara_txt.setText(String.valueOf(laake_maara.get(position)));
        //Recyclerview onClickListener
       /* holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(book_id.get(position)));
                intent.putExtra("title", String.valueOf(book_title.get(position)));
                intent.putExtra("author", String.valueOf(book_author.get(position)));
                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return laake_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView laake_nimi_txt, laake_aika_txt, laake_maara_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            laake_nimi_txt = itemView.findViewById(R.id.Laake_nimi_txt);
            laake_aika_txt = itemView.findViewById(R.id.Laake_aika_txt);
            laake_maara_txt = itemView.findViewById(R.id.Laake_maara_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
          //  mainLayout.setAnimation(translate_anim);
        }

    }

}
