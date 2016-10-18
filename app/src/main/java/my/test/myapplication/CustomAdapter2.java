package my.test.myapplication;

import android.content.Context;
import android.content.Intent;
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

    static int id;

    private int[] image_src = {R.drawable.peli1,R.drawable.peli2,R.drawable.peli3,R.drawable.peli4, R.drawable.peli5};
    Context context;
    LinearLayout linearLayout;
    TextView estado; //resarvado o no

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
        estado = (TextView) view.findViewById(R.id.estado);
        linearLayout = (LinearLayout) view.findViewById(R.id.detalles);

        Pelicula pelicula = getItem(position);
        nombre.setText(pelicula.getNombre());

        nombre.setText(String.valueOf(pelicula.getNombre()));
        director.setText(String.valueOf(pelicula.getDirector()));
        estrellas.setProgress(pelicula.getPuntuacion()/10);
        photo.setImageResource(image_src[position]);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do your stuff here

                Toast toast = Toast.makeText(context, "Peli "+position, Toast.LENGTH_LONG);
                toast.show();
                //Cambiamos de actividad para ver detalles de la pelicula seleccionada
                String msg = "prueba";
                Pelicula pelicula = getItem(position);
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("identificador", position);
                id = position;
                intent.putExtra("name", pelicula.getNombre());
                intent.putExtra("format", pelicula.getFormato());
                intent.putExtra("duracion", pelicula.getDuracion());
                intent.putExtra("tipo", pelicula.getGenero());
                intent.putExtra("censura", pelicula.getCensura());
                intent.putExtra("reparto", pelicula.getReparto());
                intent.putExtra("sinopsis", pelicula.getSinopsis());
                context.startActivity(intent);

            }
        });


        return view;
    }


}