/************************************************************************************
 *   Copyright (C) 2016 Sarishma Jayasree & Swathi Ramakanth Shanbhag               *
 *   This project is licensed under the "MIT License".                              *
 *   Please see the file LICENSE in this distribution for license terms.            *
 *   LICENSE Link: https://github.com/s4sarishma/DesiPizza/blob/master/LICENSE)     *
 *                                                                                  *
 ************************************************************************************/
 
package com.example.sari.desipizza;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;

public class FinalPage extends AppCompatActivity {


//    @Override
//    public void onBackPressed() {
//    }

    public void addListenerOnButton_Exit() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        addListenerOnButton_Exit();


    }
}
