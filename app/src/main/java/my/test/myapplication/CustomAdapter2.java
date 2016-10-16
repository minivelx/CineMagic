package my.test.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by miguel on 2/10/16.
 */

public class CustomAdapter2 extends ArrayAdapter<Pelicula> {

    private int[] image_src = {R.drawable.peli1,R.drawable.peli2,R.drawable.peli3,R.drawable.peli4, R.drawable.peli5};
    Context context;
    LinearLayout linearLayout;

    public CustomAdapter2(Context context,int textViewResourceId, List<Pelicula> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //View view = super.getView(position, convertView, parent);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_custom, null);

        TextView nombre = (TextView) view.findViewById(R.id.titulo);
        TextView director = (TextView) view.findViewById(R.id.director);
        RatingBar estrellas = (RatingBar) view.findViewById(R.id.estrellas);
        ImageView photo = (ImageView) view.findViewById(R.id.poster);
        linearLayout = (LinearLayout) view.findViewById(R.id.detalles);

        Pelicula pelicula = getItem(position);
        nombre.setText(pelicula.getNombre());

        nombre.setText(String.valueOf(pelicula.getNombre()));
        director.setText(String.valueOf(pelicula.getDirector()));
        estrellas.setRating(pelicula.getPuntuacion());
        photo.setImageResource(image_src[position]);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do your stuff here

                    Toast toast = Toast.makeText(context, "Peli "+position, Toast.LENGTH_LONG);
                    toast.show();

            }
        });



        return view;
    }


}