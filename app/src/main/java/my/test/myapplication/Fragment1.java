package my.test.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;


public class Fragment1 extends Fragment {

    ListView lista;
    List<Pelicula> peliculas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag1,container, false);
        lista = (ListView) rootView.findViewById(android.R.id.list);

        return  rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        descargarData();
    }

    public void descargarData(){

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Cargando datos...");
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://webservices-minivelx.c9users.io/hello-world.php";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    //progressDialog.dismiss();
                    try {
                        JSONArray jsonArray = new JSONArray(new String(responseBody));
                        peliculas = new ArrayList<>();
                        for (int i=0;i<jsonArray.length();i++){
                            //Pelicula(String nombre, int puntuacion,int censura,int duracion, String director, String genero, String reparto, String sinopsis, int formato)
                            peliculas.add(new Pelicula(
                                    jsonArray.getJSONObject(i).getString("Nombre"),
                                    jsonArray.getJSONObject(i).getInt("Puntaje"),
                                    jsonArray.getJSONObject(i).getInt("Censura"),
                                    jsonArray.getJSONObject(i).getInt("Duracion"),
                                    jsonArray.getJSONObject(i).getString("Director"),
                                    jsonArray.getJSONObject(i).getString("Genero"),
                                    jsonArray.getJSONObject(i).getString("Reparto"),
                                    jsonArray.getJSONObject(i).getString("Sinopsis"),
                                    jsonArray.getJSONObject(i).getInt("Formato"),
                                    jsonArray.getJSONObject(i).getString("LinkImagen")
                            ));
                        }
                        //Log.i("Gragment1","creando adapter2");
                        //MainActivity.adapter2 = new CustomAdapter2(getActivity(), android.R.id.list,peliculas);
                        //lista.setAdapter(MainActivity.adapter2);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        //realizo la consulta de horarios
        url = "https://webservices-minivelx.c9users.io/horario.php";
        RequestParams parametros = new RequestParams();
        //parametros.put("ID",DetailActivity.peli+1);

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    //progressDialog.dismiss();
                    try {
                        JSONArray jsonArray = new JSONArray(new String(responseBody));

                        for (int i=0;i<jsonArray.length();i++){
                            //Pelicula(String nombre, int puntuacion,int censura,int duracion, String director, String genero, String reparto, String sinopsis, int formato)
                            int position = jsonArray.getJSONObject(i).getInt("ID")-1;
                            peliculas.get(position).hora.add(jsonArray.getJSONObject(i).getString("Hora"));
                            //Log.i("la pelicula"+position,"tiene Horario de "+jsonArray.getJSONObject(i).getString("Hora"));
                        }
                        //Log.i("Fragment1","creando adapter2");
                        MainActivity.adapter2 = new CustomAdapter2(getActivity(), android.R.id.list,peliculas);
                        lista.setAdapter(MainActivity.adapter2);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


        //reviso si hay reservas existentes previamente
        url = "https://webservices-minivelx.c9users.io/consultar.php";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    progressDialog.dismiss();
                    try {
                        JSONArray jsonArray = new JSONArray(new String(responseBody));

                        for (int i=0;i<jsonArray.length();i++){
                            //Pelicula(String nombre, int puntuacion,int censura,int duracion, String director, String genero, String reparto, String sinopsis, int formato)
                            int position = jsonArray.getJSONObject(i).getInt("ID")-1;
                            Fragment2.reservas.add(new Reserva(peliculas.get(position).getNombre(), jsonArray.getJSONObject(i).getString("Hora")));
                            peliculas.get(position).setEstado(true);
                            Fragment2.actualizar();
                            //Log.i("tposicion ",peliculas.get(position).getNombre());

                        }
                        //Log.i("Gragment1","creando adapter2");
                        //MainActivity.adapter2 = new CustomAdapter2(getActivity(), android.R.id.list,peliculas);
                        //lista.setAdapter(MainActivity.adapter2);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
}
