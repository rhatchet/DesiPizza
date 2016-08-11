/************************************************************************************
 *   Copyright (C) 2016 Sarishma Jayasree & Swathi Ramakanth Shanbhag               *
 *   This project is licensed under the "MIT License".                              *
 *   Please see the file LICENSE in this distribution for license terms.            *
 *   LICENSE Link: https://github.com/s4sarishma/DesiPizza/blob/master/LICENSE)     *
 *                                                                                  *
 ************************************************************************************/

package com.example.sari.desipizza;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button orderpizza_btn, orderdrink_btn, reviewcart_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        orderpizza_btn = (Button) findViewById(R.id.button_orderPizza_id);
        orderdrink_btn = (Button) findViewById(R.id.button_orderDrink_id);
        reviewcart_btn = (Button) findViewById(R.id.button_reviewCart_id);


        orderpizza_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, PizzaMenu_Page.class);
                startActivity(intent);

            }

        });

        orderdrink_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, DrinkMenu_Page.class);
                startActivity(intent);

            }

        });

        reviewcart_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, ReviewCart_Page.class);
                startActivity(intent);

            }

        });
    }

}
