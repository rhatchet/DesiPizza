/************************************************************************************
 *   Copyright (C) 2016 Sarishma Jayasree & Swathi Ramakanth Shanbhag               *
 *   This project is licensed under the "MIT License".                              *
 *   Please see the file LICENSE in this distribution for license terms.            *
 *   LICENSE Link: https://github.com/s4sarishma/DesiPizza/blob/master/LICENSE)     *
 *                                                                                  *
 ************************************************************************************/

package com.example.sari.desipizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        //setContentView(R.layout.activity_start_page);
  finish();
    }
}
