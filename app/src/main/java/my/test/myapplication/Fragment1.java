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

/**
 * Created by filip on 8/21/2015.
 */
public class Fragment1 extends Fragment {

    ListView lista;
    List<Pelicula> peliculas;
    CustomAdapter2 adapter2;
    LinearLayout linear;

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
        adapter2 = new CustomAdapter2(getActivity(), android.R.id.list,peliculas);
        lista.setAdapter(adapter2);
    }

    private List<Pelicula> initPeliculasList() {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Expendables 2",10, "Quentin tarantino"));
        peliculas.add(new Pelicula("Vacaciones",1, "Rosemir"));
        peliculas.add(new Pelicula("Brave",2, "Yoselinda"));
        peliculas.add(new Pelicula("Terminator 4",3, "Jennifer Lopez"));
        return peliculas;
    }
}
