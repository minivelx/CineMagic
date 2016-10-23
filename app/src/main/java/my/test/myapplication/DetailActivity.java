package my.test.myapplication;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity implements
        Dialogo.OnSetTitleListener,
        Dialogo.OnSimpleDialogListener {

    static int peli;
    String hora_reserva;
    boolean confirmo_reserva;

    public DetailActivity() {
        this.hora_reserva = null;
        confirmo_reserva = false;
    }

    private int[] video_src = {R.raw.suicida, R.raw.transformers, R.raw.valiente, R.raw.furioso, R.raw.conjuro, R.raw.focus, R.raw.mentes, R.raw.terminator};


    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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
        confirmo_reserva  = datos.getBoolean("estado");
        videoplay(peli);

        Intent intent = new Intent();
        intent.putExtra("estado", confirmo_reserva);
        setResult(RESULT_OK, intent);


    }

    public void videoplay(int id){

        String videopath = "android.resource://my.test.myapplication/"+ R.raw.furioso;

        Uri uri = Uri.parse("android.resource://my.test.myapplication/"+video_src[id]);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
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
        confirmo_reserva = true;

        if(confirmo_reserva && hora_reserva!=null){
            Toast.makeText(
                    this,
                    "Reservaste a las "+hora_reserva,
                    Toast.LENGTH_LONG)
                    .show();
        }else {
            confirmo_reserva=false;
        }
        Intent intent = new Intent();
        intent.putExtra("estado", confirmo_reserva);
        setResult(RESULT_OK, intent);

    }

    @Override
    public void onNegativeButtonClick() {
        // Acciones
    }

    public boolean getConfirmo_reserva() {


        return confirmo_reserva;
    }


}
