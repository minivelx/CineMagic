package my.test.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


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
        peliculas = initPeliculasList();
        MainActivity.adapter2 = new CustomAdapter2(getActivity(), android.R.id.list,peliculas);
        lista.setAdapter(MainActivity.adapter2);

    }

    private List<Pelicula> initPeliculasList() {

        //se crea y carga la lista de las peliculas en cartelera
        List<Pelicula> peliculas = new ArrayList<>();

        //actores y sipnosis de cada pelicula
        String r1 = "Will Smith,Ben Affleck,Jared Leto ,Margot Robbie,Cara Delevingne";
        String s1 = "Se siente bien ser el malo… Formar un equipo integrado por los supervillanos encarcelados más peligrosos del mundo;" +
                " armarlos con el arsenal más poderoso que el gobierno tiene disponible y enviarlos a una misión para vencer a una entidad " +
                "insuperable y enigmática. Amanda Waller –oficial de inteligencia estadunidense– decidió que únicamente un grupo secreto " +
                "formado por individuos disparatados, despreciables y con nada que perder son la única opción. Sin embargo, cuando ellos " +
                "se dan cuenta de que no fueron convocados con la idea de triunfar, sino por su obvia culpabilidad si fracasan… " +
                "¿Será que el Escuadrón Suicida decidirá morir en el intento o salvar cada quien su vida?";

        String r2 = "Mark Wahlberg, Stanley Tucci, Nicola Peltz más ";
        String s2 = "Transformers: la era de la extinción' nos sitúa cuatro años después del incidente de Chicago ocurrido durante la anterior" +
                " película. Tanto los Autobots como los Decepticons han desaparecido de la Tierra, y la civilización sigue inmersa en reparar " +
                "los destrozos de aquel incidente. Sin embargo, un nuevo proyecto llevado a cabo por el gobierno de los Estados Unidos está " +
                "recabando información y rescatando la tecnología que se sigue encontrando por el suceso de Chicago para crear unos Transformers " +
                "propios. El proyecto está liderado por Joshua Joyce (Stanley Tucci), cuyo máximo objetivo es desarrollar unos robots" +
                " aún más avanzados que los Transformers.";

        String r3 = "Mark Andrews, Steve Purcell, Brenda Chapman, Irene Mecchi";
        String s3 = "Merida, la indómita hija del Rey Fergus y de la Reina Elinor, es una hábil arquera que decide romper con una antigua costumbre," +
                " que es sagrada para los señores de la tierra: el gigantesco Lord MacGuffin, el malhumorado Lord Macintosh y el cascarrabias Lord Dingwall." +
                " Las acciones de Merida desencadenan el caos y la furia en el reino. Además, pide ayuda a una sabia anciana que le concede un deseo muy " +
                "desafortunado. La muchacha tendrá que afrontar grandes peligros antes de aprender qué es la auténtica valentía.";

        String r4 = "Vin Diesel, Paul Walker,Dwayne Johnson, Michelle Rodriguez, Jordana Brewster.";
        String s4 = "Después de haber vencido a Owen Shaw; Dominic Toretto, Brian O’Conner y el resto del equipo vuelven a Estados Unidos para llevar" +
                " una vida normal, como siempre habían deseado. Pero Ian Shaw, hermano mayor de Owen, está en búsqueda de Dominic Toretto para cobrar" +
                " venganza por la muerte de su hermano, lo que pone en peligro a todo el equipo. Al enterarse de la muerte de Han, la familia Rápidos y " +
                "Furiosos se propone encontrar al hombre que mató a uno de los suyos, antes de que él los encuentre primero";

        //formato Pelicula(String nombre, int puntuacion,int censura,int duracion, String director, String genero, String reparto, String sinopsis, int formato)
        peliculas.add(new Pelicula("Suicide Squared",95,12,123,"David Ayer","Acción",r1,s1,2));
        peliculas.add(new Pelicula("Transformers 4",100,12,180,"Michael Bay","Acción, Ciencia ficción",r2,s2,3));
        peliculas.add(new Pelicula("Indomable",75,0,90,"Mark Andrews","Aventura",r3,s3,2));
        peliculas.add(new Pelicula("Rapido&Furioso 7",85,15,138,"James Wan","Acción",r4,s4,3));

        return peliculas;
    }
}
