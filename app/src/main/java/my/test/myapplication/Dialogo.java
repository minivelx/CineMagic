package my.test.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class Dialogo extends DialogFragment {

    int []num_funciones = {2,3,1,4,2,2,2,3};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final CharSequence[] items = new CharSequence[num_funciones[DetailActivity.peli]];

        switch (DetailActivity.peli){
            case 0:
                items[0] = "12:30 PM";
                items[1] = "3:00 PM";
                break;

            case 1:
                items[0] = "2:40 PM";
                items[1] = "5:00 PM";
                items[2] = "7:30 PM";
                break;

            case 2:
                items[0] = "3:50 PM";
                break;

            case 3:
                items[0] = "2:30 PM";
                items[1] = "5:00 PM";
                items[2] = "7:30 PM";
                items[3] = "9:30 PM";
                break;


            case 4:
                items[0] = "8:30 PM";
                items[1] = "9:50 PM";
                break;

            case 5:
                items[0] = "5:30 PM";
                items[1] = "9:00 PM";
                break;

            case 6:
                items[0] = "2:30 PM";
                items[1] = "3:40 PM";
                break;

            case 7:
                items[0] = "5:10 PM";
                items[1] = "6:50 PM";
                items[1] = "8:20 PM";
                break;

            default:break;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Funciones de Hoy")
                .setSingleChoiceItems(items, -1,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                Log.i("Dialogos", "Opción elegida: " + items[item]);
                            }
                        })

                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

        return builder.create();
    }
}