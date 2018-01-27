package eak.rmutr.ac.th.eakchat.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import eak.rmutr.ac.th.eakchat.R;

/**
 * Created by Slump on 01/27/2018.
 */

public class MyAlert {

    private Context contex;

    public MyAlert(Context contex) {
        this.contex = contex;
    }

    public void normalDialog(String titleString, String messageString) {

        AlertDialog.Builder builder = new AlertDialog.Builder(contex);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

}   // Main Class
