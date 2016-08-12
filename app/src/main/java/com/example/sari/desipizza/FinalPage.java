/************************************************************************************
 *   Copyright (C) 2016 Sarishma Jayasree & Swathi Ramakanth Shanbhag               *
 *   This project is licensed under the "MIT License".                              *
 *   Please see the file LICENSE in this distribution for license terms.            *
 *   LICENSE Link: https://github.com/s4sarishma/DesiPizza/blob/master/LICENSE)     *
 *                                                                                  *
 ************************************************************************************/
 
package com.example.sari.desipizza;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalPage extends AppCompatActivity {
    Button exit_button;

    public void addListenerOnButton_Exit() {

        final Context context = this;
        exit_button = (Button) findViewById(R.id.button_exit_id);
        exit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                FinalPage.this.exit_application();
            }
        });
    }


    private void exit_application() {

        ActivityCompat.finishAffinity(this);
        System.exit(0);
    }

    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        addListenerOnButton_Exit();
    }
}
