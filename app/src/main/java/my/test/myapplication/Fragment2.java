package my.test.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    ListView lista2;
    static ArrayAdapter arrayAdapter;
    static List<Reserva> reservas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag2,container,false);

        lista2 = (ListView) rootView.findViewById(R.id.lista2);
        lista2.setAdapter(arrayAdapter);



        arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, reservas) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                //View view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2,parent);
                TextView tittle = (TextView) view.findViewById(android.R.id.text1);
                TextView subtittle = (TextView) view.findViewById(android.R.id.text2);

                Reserva p = (Reserva) getItem(position);

                tittle.setText(p.getTitulo());
                subtittle.setText(p.getHora());


                return view;
            }
        };


        lista2.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        return  rootView;
    }

    public static void actualizar(){
        arrayAdapter.notifyDataSetChanged();
    }

}
