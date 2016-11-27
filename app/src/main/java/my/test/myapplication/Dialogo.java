package my.test.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Dialogo extends DialogFragment {

    //int []num_funciones = {2,3,1,4,2,0,0,0};

    //Interfaces
    public interface OnSetTitleListener{
        void setTitle(String title);
    }

    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick();// Eventos Botón ok
        void onNegativeButtonClick();// Eventos Botón cancel
    }
    // Interfaz de comunicación
    OnSetTitleListener listener;
    // Interfaz de comunicación 2
    OnSimpleDialogListener listener2;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int size = DetailActivity.losHorarios.size();
        final CharSequence[] items = new CharSequence[size];

        //se llena el vector con los horarios
        for(int i=0; i<size;i++){
            items[i] = DetailActivity.losHorarios.get(i).toString();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle("Funciones de Hoy")
                .setSingleChoiceItems(items, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {

                                Log.i("Dialogos", "Opción elegida: " + items[item]);
                                listener.setTitle((String) items[item]);
                                final int a = item;
                            }
                        })

                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                listener2.onPossitiveButtonClick();

                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                listener2.onNegativeButtonClick();
                            }
                        });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSetTitleListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSetTitleListener");

        }

        try {
            listener2 = (OnSimpleDialogListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSimpleDialogListener");

        }

    }
}