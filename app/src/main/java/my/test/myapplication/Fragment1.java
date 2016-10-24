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

        String r5 = "David Leslie Johnso, Chad Hayes, James Wan.";
        String s5 = "Lorraine y Ed Warren, quienes, en una de sus más aterradoras investigaciones paranormales, viajan al norte de Londres para ayudar" +
                " a una madre soltera con cuatro hijos que vive en una casa repleta de espíritus malignos.";

        String r6 = "Will Smith, Margot Robbie, Rodrigo Santoro, Stephanie Honore.";
        String s6 = "Un veterano estafador acoge a una atractiva joven bajo su protectorado, pero las cosas se complican cuando ambos comienzan un romance. " +
                "Todo comienza cuando Nicky (Will Smith), un consumado maestro de la estafa, comienza un romance con Jess (Margot Robbie), una novata en el " +
                "oficio. Mientras le enseña los trucos del oficio, ella desea estrechar demasiado los lazos con Nicky, y éste rompe de repente la relación. " +
                "Tres años más tarde, la mujer que había encendido una llama en él, convertida en una mujer fatal, reaparece en Buenos Aires en un circuito " +
                "de carreras en el que hay apuestas muy elevadas.";

        String r7 = "Zach Galifianakis, Owen Wilson, Kristen Wiig.";
        String s7 = "Esta comedia de acción basada en hechos reales, David Ghantt (Zach Galifianakis) descubre el verdadero sentido de la aventura mucho" +
                " más allá de sus sueños más salvajes. Él es un hombre sin complicaciones, atrapado en una vida monótona. Cada día conduce un vehículo" +
                " blindado, transportando millones de dólares de otras personas, sin perspectiva de mejora a la vista. El único atisbo de emoción es su" +
                " amor platónico, Kelly Campbell (Kristen Wiig), su compañera de trabajo, quien pronto le cambiará los esquemas de su vida.";

        String r8 = "Zach Galifianakis, Owen Wilson, Kristen Wiig.";
        String s8 = "Año 2032. La guerra del futuro se está librando y un grupo de rebeldes humanos tiene el sistema de inteligencia artificial Skynet " +
                "contra las cuerdas. John Connor (Jason Clarke) es el líder de la resistencia, y Kyle Reese (Jai Courtney) es su fiel soldado, criado en " +
                "las ruinas de una postapocalíptica California. Para salvaguardar el futuro, Connor envía a Reese a 1984 para salvar a su madre, Sarah " +
                "(Emilia Clarke) de un Terminator programado para matarla con el fin de que no llegue a dar a luz a John. Pero lo que Reese encuentra en " +
                "el otro lado no es como él esperaba…";
        //formato Pelicula(String nombre, int puntuacion,int censura,int duracion, String director, String genero, String reparto, String sinopsis, int formato)
        peliculas.add(new Pelicula("Suicide Squared",95,12,123,"David Ayer","Acción",r1,s1,2));
        peliculas.add(new Pelicula("Transformers 4",100,12,180,"Michael Bay","Acción, Ciencia ficción",r2,s2,3));
        peliculas.add(new Pelicula("Indomable",75,0,90,"Mark Andrews","Aventura",r3,s3,2));
        peliculas.add(new Pelicula("Rapido&Furioso 7",85,15,138,"James Wan","Acción",r4,s4,3));
        peliculas.add(new Pelicula("El Conjuro 2",65,18,134,"Carey Hayes","Terror",r5,s5,2));
        //peliculas.add(new Pelicula("Focus",75,18,104,"Glenn Ficarra","Acción",r6,s6,2));
        //peliculas.add(new Pelicula("Demente Maestra",35,12,94,"Jared Hess","Comedia, Acción",r7,s7,2));
        //peliculas.add(new Pelicula("Terminator 4",95,16,126,"Alan Taylor ","Acción",r8,s8,3));

        return peliculas;
    }

}
