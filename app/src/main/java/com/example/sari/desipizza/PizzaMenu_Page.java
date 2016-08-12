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
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.ArrayList;

public class PizzaMenu_Page extends AppCompatActivity {

    public static ArrayList<String> pizzalist;
    private static int pizzasize_int;

    private static int tomato_int;
    private static int onion_int;
    private static int bellpeppers_int;
    private static int mushrooms_int;
    private static int cheese_int;
    private static int pepperoni_int;
    private static int sausage_int;
    private static int chicken_int;
    private static int ham_int;

    public static int pizzaprice1_int;
    public static int pizzaprice2_int;

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private CheckBox cb7;
    private CheckBox cb8;
    private CheckBox cb9;
    Button add_to_cart_pizza_btn;
    Button cancel_pizza_btn;
     RadioGroup rg_pizzasize;
     TextView pizzasizetext;
     TextView pizzatoppingstext;
     TextView pizzapricetext;


    public void addListenerOnButton_Add_To_Cart() {

        final Context context = this;

        add_to_cart_pizza_btn = (Button) findViewById(R.id.button_AddToCart_Pizza_id);
        add_to_cart_pizza_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, StartPage.class);
                PizzaMenu_Page.pizzalist = new ArrayList();
                SharedPreferences sp = PizzaMenu_Page.this.getSharedPreferences("spSettings", 0);
                int temp_price = sp.getInt("TotalPrice", 0);
                Editor editor = sp.edit();
                editor.putInt("TotalPrice", (PizzaMenu_Page.pizzaprice2_int + temp_price) + PizzaMenu_Page.pizzaprice1_int);
                editor.commit();
                String pizzaSizeDisp = null;
                String pizzaToppingsDisp = "";
                if (PizzaMenu_Page.pizzasize_int == 1) {
                    pizzaSizeDisp = "Small";
                }
                else if (PizzaMenu_Page.pizzasize_int == 2) {
                    pizzaSizeDisp = "Medium";
                }
                else if (PizzaMenu_Page.pizzasize_int == 3) {
                    pizzaSizeDisp = "Large";
                }

                int count =0;

                if (PizzaMenu_Page.tomato_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Tomato ";
                    count = 0+1;
                }
                if (PizzaMenu_Page.onion_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Onions ";
                    count++;
                }
                if (PizzaMenu_Page.bellpeppers_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Bell Peppers ";
                    count++;
                }
                if (PizzaMenu_Page.mushrooms_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Mushrooms ";
                    count++;
                }
                if (PizzaMenu_Page.cheese_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Cheese ";
                    count++;
                }
                if (PizzaMenu_Page.sausage_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Paneer Tikka "; //Sausage
                    count++;
                }
                if (PizzaMenu_Page.ham_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Butter Chicken "; //Ham
                    count++;
                }
                if (PizzaMenu_Page.chicken_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Tandoori Chicken "; //Chicken
                    count++;
                }
                if (PizzaMenu_Page.pepperoni_int == 1) {
                    pizzaToppingsDisp = pizzaToppingsDisp + "Chilli Paneer "; //Pepperoni
                    count++;
                }
                int pizzaprice_total = PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int;
                String pizzaDisp = pizzaSizeDisp + " " + pizzaToppingsDisp + "Pizza ($" + pizzaprice_total + ")";
                if (count < 5) {
                    pizzaDisp = pizzaDisp + "\n";
                }
                PizzaMenu_Page.tomato_int = 0;
                PizzaMenu_Page.onion_int = 0;
                PizzaMenu_Page.bellpeppers_int = 0;
                PizzaMenu_Page.mushrooms_int = 0;
                PizzaMenu_Page.cheese_int = 0;
                PizzaMenu_Page.pepperoni_int = 0;
                PizzaMenu_Page.sausage_int = 0;
                PizzaMenu_Page.ham_int = 0;
                PizzaMenu_Page.chicken_int = 0;

                PizzaMenu_Page.pizzasize_int = 1;
                if(ReviewCart_Page.list1 == null) {
                    ReviewCart_Page.tp1 = pizzaprice_total;
                    ReviewCart_Page.list1 = pizzaDisp;
                }
                else if(ReviewCart_Page.list2 == null) {
                    ReviewCart_Page.tp2 = pizzaprice_total;
                    ReviewCart_Page.list2 = pizzaDisp;
                }
                else if(ReviewCart_Page.list3 == null) {
                    ReviewCart_Page.tp3 = pizzaprice_total;
                    ReviewCart_Page.list3 = pizzaDisp;
                }
                else if(ReviewCart_Page.list4 == null) {
                    ReviewCart_Page.tp4 = pizzaprice_total;
                    ReviewCart_Page.list4 = pizzaDisp;
                }
                else if(ReviewCart_Page.list5 == null) {
                    ReviewCart_Page.tp5 = pizzaprice_total;
                    ReviewCart_Page.list5 = pizzaDisp;
                }
                else if(ReviewCart_Page.list6 == null) {
                    ReviewCart_Page.tp6 = pizzaprice_total;
                    ReviewCart_Page.list6 = pizzaDisp;
                }
                else if(ReviewCart_Page.list7 == null) {
                    ReviewCart_Page.tp7 = pizzaprice_total;
                    ReviewCart_Page.list7 = pizzaDisp;
                }
                else if(ReviewCart_Page.list8 == null) {
                    ReviewCart_Page.tp8 = pizzaprice_total;
                    ReviewCart_Page.list8 = pizzaDisp;
                }
                else if(ReviewCart_Page.list9 == null) {
                    ReviewCart_Page.tp9 = pizzaprice_total;
                    ReviewCart_Page.list9 = pizzaDisp;
                }
                else if(ReviewCart_Page.list10 == null) {
                    ReviewCart_Page.tp10 = pizzaprice_total;
                    ReviewCart_Page.list10 = pizzaDisp;
                }
                PizzaMenu_Page.pizzaprice1_int = 5;
                PizzaMenu_Page.pizzaprice2_int = 0;
                PizzaMenu_Page.this.startActivity(intent);
            }

        });
    }


    public void addListenerOnButton_Cancel() {

        final Context context = this;

        cancel_pizza_btn = (Button) findViewById(R.id.button_Cancel_Pizza_id);
        cancel_pizza_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, StartPage.class);
                PizzaMenu_Page.pizzalist = new ArrayList();
                PizzaMenu_Page.pizzaprice1_int = 5;
                PizzaMenu_Page.pizzaprice2_int = 0;
                PizzaMenu_Page.tomato_int = 0;
                PizzaMenu_Page.onion_int = 0;
                PizzaMenu_Page.bellpeppers_int = 0;
                PizzaMenu_Page.mushrooms_int = 0;
                PizzaMenu_Page.cheese_int = 0;
                PizzaMenu_Page.pepperoni_int = 0;
                PizzaMenu_Page.sausage_int = 0;
                PizzaMenu_Page.ham_int = 0;
                PizzaMenu_Page.chicken_int = 0;
                PizzaMenu_Page.pizzasize_int = 1;
                PizzaMenu_Page.this.startActivity(intent);

            }

        });
    }


    public class pizzasize_class implements RadioGroup.OnCheckedChangeListener {
        pizzasize_class() {

        }
        public void onCheckedChanged(RadioGroup group, int sizeCheckedId) {
            RadioButton rb_pizzasize = (RadioButton) PizzaMenu_Page.this.findViewById(sizeCheckedId);
            if(rb_pizzasize.equals((RadioButton) PizzaMenu_Page.this.findViewById(R.id.radioButton_pizzaSmall_id))) {
                PizzaMenu_Page.pizzaprice1_int = 5;
                PizzaMenu_Page.this.pizzasizetext.setText("\n Size Selected: \n Small");
                PizzaMenu_Page.pizzasize_int = 1;
            }
            if(rb_pizzasize.equals((RadioButton) PizzaMenu_Page.this.findViewById(R.id.radioButton_pizzaMedium_id))) {
                PizzaMenu_Page.pizzaprice1_int = 10;
                PizzaMenu_Page.this.pizzasizetext.setText("\n Size Selected: \n Medium");
                PizzaMenu_Page.pizzasize_int = 2;
            }
            if(rb_pizzasize.equals((RadioButton) PizzaMenu_Page.this.findViewById(R.id.radioButton_pizzaLarge_id))) {
                PizzaMenu_Page.pizzaprice1_int = 15;
                PizzaMenu_Page.this.pizzasizetext.setText("\n Size Selected: \n Large");
                PizzaMenu_Page.pizzasize_int = 3;
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Tomato_class implements CompoundButton.OnCheckedChangeListener {
        Tomato_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Tomato");
                PizzaMenu_Page.tomato_int = 1;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Tomato");
                PizzaMenu_Page.tomato_int = 0;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + "  ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Onion_class implements CompoundButton.OnCheckedChangeListener {
        Onion_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Onions");
                PizzaMenu_Page.onion_int = 1;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Onions");
                PizzaMenu_Page.onion_int = 0;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class BellPeppers_class implements CompoundButton.OnCheckedChangeListener {
        BellPeppers_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Bell Peppers");
                PizzaMenu_Page.bellpeppers_int = 1;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Bell Peppers");
                PizzaMenu_Page.bellpeppers_int = 0;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Mushrooms_class implements CompoundButton.OnCheckedChangeListener {
        Mushrooms_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Mushrooms");
                PizzaMenu_Page.mushrooms_int = 1;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Mushrooms");
                PizzaMenu_Page.mushrooms_int = 0;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Cheese_class implements CompoundButton.OnCheckedChangeListener {
        Cheese_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Cheese");
                PizzaMenu_Page.cheese_int = 1;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Cheese");
                PizzaMenu_Page.cheese_int = 0;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Pepperoni_class implements CompoundButton.OnCheckedChangeListener {
        Pepperoni_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Chilli Paneer");
                PizzaMenu_Page.pepperoni_int = 1;
                PizzaMenu_Page.pizzaprice2_int++;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Chilli Paneer");
                PizzaMenu_Page.pepperoni_int = 0;
                PizzaMenu_Page.pizzaprice2_int--;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Sausage_class implements CompoundButton.OnCheckedChangeListener {
        Sausage_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Paneer Tikka ");
                PizzaMenu_Page.sausage_int = 1;
                PizzaMenu_Page.pizzaprice2_int++;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Paneer Tikka");
                PizzaMenu_Page.sausage_int = 0;
                PizzaMenu_Page.pizzaprice2_int--;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Ham_class implements CompoundButton.OnCheckedChangeListener {
        Ham_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Butter Chicken");
                PizzaMenu_Page.ham_int = 1;
                PizzaMenu_Page.pizzaprice2_int++;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Butter Chicken");
                PizzaMenu_Page.ham_int = 0;
                PizzaMenu_Page.pizzaprice2_int--;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    class Chicken_class implements CompoundButton.OnCheckedChangeListener {
        Chicken_class() {

        }
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                PizzaMenu_Page.pizzalist.add("Tandoori Chicken");
                PizzaMenu_Page.chicken_int = 1;
                PizzaMenu_Page.pizzaprice2_int++;
            }
            if (!isChecked) {
                PizzaMenu_Page.pizzalist.remove("Tandoori Chicken");
                PizzaMenu_Page.chicken_int = 0;
                PizzaMenu_Page.pizzaprice2_int--;
            }
            PizzaMenu_Page.this.pizzatoppingstext.setText("\nToppings Selected: \n");
            for(int i = 0; i < PizzaMenu_Page.pizzalist.size(); i++) {
                PizzaMenu_Page.this.pizzatoppingstext.setText(PizzaMenu_Page.this.pizzatoppingstext.getText() + ((String) PizzaMenu_Page.pizzalist.get(i)).toString() + " ");
            }
            PizzaMenu_Page.this.pizzapricetext.setText("Price: $" + (PizzaMenu_Page.pizzaprice1_int + PizzaMenu_Page.pizzaprice2_int));
        }

    }

    static {
        pizzasize_int =1;
        tomato_int = 0;
        onion_int =0;
        bellpeppers_int =0;
        mushrooms_int =0;
        cheese_int =0;
        pepperoni_int =0;
        sausage_int =0;
        ham_int = 0;
        chicken_int = 0;
        pizzaprice1_int = 5;
        pizzaprice2_int = 0;
        pizzalist = new ArrayList();
    }

    public void onBackPressed() {

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu__page);
        this.pizzatoppingstext = (TextView) findViewById(R.id.textView_pizzaToppingsSelected_id);
        this.pizzapricetext = (TextView) findViewById(R.id.textView_pizzaPrice_id);
        pizzaprice1_int = 5;
        pizzaprice2_int = 0;
        this.pizzapricetext.setText("Price: $0");
      //this.pizzapricetext.setText("Price: $5");
        this.cb1 = (CheckBox) findViewById(R.id.checkBox_Tomato_id);
        this.cb2 = (CheckBox) findViewById(R.id.checkBox_Onion_id);
        this.cb3 = (CheckBox) findViewById(R.id.checkBox_Bellpeppers_id);
        this.cb4 = (CheckBox) findViewById(R.id.checkBox_Mushrooms_id);
        this.cb5 = (CheckBox) findViewById(R.id.checkBox_Cheese_id);
        this.cb6 = (CheckBox) findViewById(R.id.checkBox_Pepperoni_id);
        this.cb7 = (CheckBox) findViewById(R.id.checkBox_Sausage_id);
        this.cb8 = (CheckBox) findViewById(R.id.checkBox_Ham_id);
        this.cb9 = (CheckBox) findViewById(R.id.checkBox_Chicken_id);
        tomato_int = 0;
        onion_int =0;
        bellpeppers_int =0;
        mushrooms_int =0;
        cheese_int =0;
        pepperoni_int =0;
        sausage_int =0;
        ham_int = 0;
        chicken_int = 0;
        pizzasize_int =1;
        addListenerOnButton_Add_To_Cart();
        addListenerOnButton_Cancel();
        this.rg_pizzasize = (RadioGroup) findViewById(R.id.radioGroup_pizzaSize_id);
        this.pizzasizetext = (TextView) findViewById(R.id.textView_pizzaSizeSelected_id);
        this.pizzasizetext.setText("Size Selected: ");
      //this.pizzasizetext.setText("\n Size Selected: \nSmall");
        this.rg_pizzasize.setOnCheckedChangeListener(new pizzasize_class());
        this.cb1.setOnCheckedChangeListener(new Tomato_class());
        this.cb2.setOnCheckedChangeListener(new Onion_class());
        this.cb3.setOnCheckedChangeListener(new BellPeppers_class());
        this.cb4.setOnCheckedChangeListener(new Mushrooms_class());
        this.cb5.setOnCheckedChangeListener(new Cheese_class());
        this.cb6.setOnCheckedChangeListener(new Pepperoni_class());
        this.cb7.setOnCheckedChangeListener(new Sausage_class());
        this.cb8.setOnCheckedChangeListener(new Ham_class());
        this.cb9.setOnCheckedChangeListener(new Chicken_class());

    }

}
