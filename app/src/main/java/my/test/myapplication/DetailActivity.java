package my.test.myapplication;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements
        Dialogo.OnSetTitleListener,
        Dialogo.OnSimpleDialogListener {

    static int peli;
    String link;
    static ArrayList losHorarios;
    String hora_reserva;
    boolean confirmo_reserva;


    public DetailActivity() {
        this.hora_reserva = null;
        confirmo_reserva = false;
    }


    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        confirmo_reserva = false;
        videoView  = (VideoView) findViewById(R.id.videoview);
        mediaController = new MediaController(this);

        //se reciben los datos del main_activity
        Bundle datos = this.getIntent().getExtras();

        //se setea la vista con los datos recibidos
        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(datos.getString("name"));

        TextView formato = (TextView) findViewById(R.id.formato);
        formato.setText(Integer.toString(datos.getInt("format"))+"D");

        TextView duracion = (TextView) findViewById(R.id.duracion);
        duracion.setText(Integer.toString(datos.getInt("duracion"))+" min");

        TextView genero = (TextView) findViewById(R.id.genero);
        genero.setText(datos.getString("tipo"));

        TextView censura = (TextView) findViewById(R.id.edad);
        censura.setText(Integer.toString(datos.getInt("censura"))+" años");

        TextView reparto = (TextView) findViewById(R.id.protagonistas);
        reparto.setText(datos.getString("reparto"));

        TextView sinopsis = (TextView) findViewById(R.id.sinopsis);
        sinopsis.setText(datos.getString("sinopsis"));

        peli=datos.getInt("identificador");
        link = datos.getString("link");
        losHorarios = datos.getCharSequenceArrayList("horarios");
        for(int i=0;i<losHorarios.size();i++){
            Log.i("Horario",losHorarios.get(i).toString());
        }
        confirmo_reserva  = datos.getBoolean("estado");
        videoplay(peli);

        Intent intent = new Intent();
        intent.putExtra("estado", confirmo_reserva);
        setResult(RESULT_OK, intent);


    }

    public void videoplay(int id){

        String videopath = "android.resource://my.test.myapplication/"+ R.raw.furioso;

        //Uri uri = Uri.parse("android.resource://my.test.myapplication/"+video_src[id]);
        //Uri uri = Uri.parse("http://www.youtube.com/watch?v=1FJHYqE0RDg");
        //Uri uri = Uri.parse("rtsp://r7---sn-4g57kue6.googlevideo.com/Ck0LENy73wIaRAmk3cJBg-iaXhMYDSANFC3u0pRWMOCoAUIJbXYtZ29vZ2xlSARSBXdhdGNoYIaluaTkzciOVooBCzVxRjNraG5XcXdnDA==/D693A8E7577C3A29E60C292B42C9C87D7C25A565.762A63DC4CA0A028DA83256C6A79E5F160CBEDA3/yt6/1/video.3gp");

        videoView.setVideoPath(link);
        //videoView.setVideoPath("http://www.youtube.com/watch?v=ragluX5mBzM");
        videoView.setMediaController(mediaController);
        //videoView.setVideoURI(uri);
        videoView.requestFocus();
        mediaController.setAnchorView(findViewById(R.id.videoview));

        videoView.start();

    }

    public void reservar(View view) {
        DialogFragment dialog = new Dialogo();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void setTitle(String title) {
        hora_reserva = title;
    }

    @Override
    public void onPossitiveButtonClick() {
        confirmo_reserva = false;

        if(confirmo_reserva && hora_reserva!=null){
            //reservo en la DB
            reservar(hora_reserva);

        }else {
            confirmo_reserva=false;
        }


    }

    @Override
    public void onNegativeButtonClick() {
        // Acciones
    }

    public boolean getConfirmo_reserva() {
        return confirmo_reserva;
    }



    public void reservar(final String hora_reservar){


        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://webservices-minivelx.c9users.io/reserva.php";
        RequestParams parametros = new RequestParams();
        parametros.put("ID",peli+1);
        parametros.put("Hora",hora_reservar);

        client.post(url,parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.i("status",String.valueOf(statusCode));
                if(statusCode==200){
                    Toast.makeText(getApplicationContext(),"Reserva lista a las "+hora_reservar,Toast.LENGTH_LONG).show();
                    confirmo_reserva=true;

                }else{
                    Toast.makeText(getApplicationContext(),"Problemas con la conexión :(",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent();
                intent.putExtra("estado", confirmo_reserva);
                intent.putExtra("horario",hora_reserva);
                setResult(RESULT_OK, intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
