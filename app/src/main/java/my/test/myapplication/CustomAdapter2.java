package my.test.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.image.SmartImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguel on 2/10/16.
 */

public class CustomAdapter2 extends ArrayAdapter<Pelicula> {

    static int id;

    Context context;
    LinearLayout linearLayout;
    TextView estado;
    Pelicula pelicula;
    View view;
    List<Pelicula> peliculas;
    TextView nombre, director;
    RatingBar estrellas;
    SmartImageView photo;

    private static final int REQUEST_CODE = 100;

    public CustomAdapter2(Context context,int textViewResourceId, List<Pelicula> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        peliculas = objects;
        Log.i("MainActivity", "Ejecutado-constructor---------------------------");

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Log.i("MainActivity", "Ejecutado-----getView------------------------------");
        //View view = super.getView(position, convertView, parent);
        view = LayoutInflater.from(getContext()).inflate(R.layout.item_custom, null);

        nombre = (TextView) view.findViewById(R.id.titulo);
        director = (TextView) view.findViewById(R.id.director);
        estrellas = (RatingBar) view.findViewById(R.id.estrellas);
        //ImageView photo = (ImageView) view.findViewById(R.id.poster);
        photo = (SmartImageView) view.findViewById(R.id.poster);
        estado = (TextView) view.findViewById(R.id.estado);
        linearLayout = (LinearLayout) view.findViewById(R.id.detalles);

        pelicula = getItem(position);
        nombre.setText(pelicula.getNombre());

        nombre.setText(String.valueOf(pelicula.getNombre()));
        director.setText(String.valueOf(pelicula.getDirector()));
        estrellas.setProgress(pelicula.getPuntuacion() / 10);
        //estrellas.isIndicator();
        //photo.setImageResource(image_src[position]);
        photo.setImageUrl(peliculas.get(position).getLinkImg());

        chequear_estado(position);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do your stuff here

                //Cambiamos de actividad para ver detalles de la pelicula seleccionada
                //Intent intent = new Intent(context, DetailActivity.class);
                Intent intent = new Intent(context, DetailActivity.class);


                intent.putExtra("identificador", position);
                id = position;
                intent.putExtra("name", peliculas.get(position).getNombre());
                intent.putExtra("format", peliculas.get(position).getFormato());
                intent.putExtra("duracion", peliculas.get(position).getDuracion());
                intent.putExtra("tipo", peliculas.get(position).getGenero());
                intent.putExtra("censura", peliculas.get(position).getCensura());
                intent.putExtra("reparto", peliculas.get(position).getReparto());
                intent.putExtra("sinopsis", peliculas.get(position).getSinopsis());
                intent.putExtra("estado", peliculas.get(position).getEstado());
                intent.putExtra("horarios", peliculas.get(position).getHora());
                intent.putExtra("link", peliculas.get(position).getLinkVideo());
                //peliculas.get(position).setEstado(true);//!!!!!!!!!!!!!BORRAR!!!!!!!!!!!!!!!!!

                ((Activity) context).startActivityForResult(intent, REQUEST_CODE);
                chequear_estado(position);
            }
        });

        return view;
    }

    public void chequear_estado(int position){

        if(pelicula.getEstado()==true){
            //Log.i("MainActivity", "yeahh!!!!!!!!");
            estado.setText("RESERVADO!");
        }else{
            estado.setText("SIN RESERVA");
        }
        //actualizamos la vista
        this.notifyDataSetChanged();
    }

    //Se encarga de llenar las reservas para el list view del fragmen2
    public  void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("CustomAdapter2", "onActivityResult");

        if(requestCode==REQUEST_CODE ){
            boolean resp = data.getBooleanExtra("estado",false);
            String hora = data.getStringExtra("horario");
            //Log.d("MainActivity",toString(resp));


            if(resp && hora!=null){
                Log.i("MainActivity", "reserva remitida satisfactoriamente");
                peliculas.get(id).setEstado(true);
                chequear_estado(id);
                Fragment2.reservas.add(new Reserva(peliculas.get(id).getNombre(), hora));
                Fragment2.actualizar();
            }

        }
    }

}