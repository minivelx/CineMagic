package my.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    private String nombre;
    String  duracion;
    private int puntuacion;
    private String sinopsis;
    private String genero;
    private int censura;
    private String director;
    private String reparto;

    VideoView videoView;
    MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        videoView  = (VideoView) findViewById(R.id.videoview);
        mediaController = new MediaController(this);
        videoplay();

        nombre = getIntent().getStringExtra("name");
        duracion = getIntent().getStringExtra("duracion");
        //TextView vista = (TextView) findViewById(R.id.vista);
        //vista.setText(mensaje);
    }

    public void videoplay(){
        String videopath = "android.resource://my.test.myapplication/"+ R.raw.furioso;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(findViewById(R.id.videoview));

        videoView.start();

    }
}
