package com.example.sari.desipizza;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DrinkMenu_Page extends AppCompatActivity {

    Button add_to_cart_drinks_btn;
    Button cancel_drink_btn;

    TextView drinksizetext;
    TextView drinktypetext;
    TextView drinkpricetext;

    RadioGroup rg_drinksize;
    RadioGroup rg_drinktype;

    private static int drinksize_int;
    private static int drinktype_int;
    private static int drinkprice_int;

    public void addListenerOnButton_Add_To_Cart() {

        //final Context context = this;

        add_to_cart_drinks_btn = (Button) findViewById(R.id.button_AddToCart_Drink_id);
        add_to_cart_drinks_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(DrinkMenu_Page.this, StartPage.class);
                SharedPreferences sp = DrinkMenu_Page.this.getSharedPreferences("spSettings", 0);
                int temp_price = sp.getInt("TotalPrice", 0);
                Editor editor = sp.edit();
                editor.putInt("TotalPrice", DrinkMenu_Page.drinkprice_int + temp_price);
                editor.commit();
                String drinkSizeDisp = null;
                String drinkTypeDisp = ""; //BuildConfig.FLAVOR;
                if(DrinkMenu_Page.drinksize_int == 1) {
                    drinkSizeDisp = "Small";
                }
                else if(DrinkMenu_Page.drinksize_int == 2) {
                    drinkSizeDisp = "Medium";
                }
                else if(DrinkMenu_Page.drinksize_int == 3) {
                    drinkSizeDisp = "Large";
                }

                if(DrinkMenu_Page.drinktype_int == 1) {
                    drinkTypeDisp = "Coke";
                }
                else if(DrinkMenu_Page.drinktype_int == 2) {
                    drinkTypeDisp = "Fanta";
                }
                else if(DrinkMenu_Page.drinktype_int == 3) {
                    drinkTypeDisp = "Diet Coke";
                }
                else if(DrinkMenu_Page.drinktype_int == 4) {
                    drinkTypeDisp = "Peppers";
                }

                String drinkDisp = drinkSizeDisp + " " + drinkTypeDisp + " ($" + DrinkMenu_Page.drinkprice_int + ")\n";

                if(ReviewCart_Page.list1 == null) {
                    ReviewCart_Page.tp1 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list1 = drinkDisp;
                }
                else if(ReviewCart_Page.list2 == null) {
                    ReviewCart_Page.tp2 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list2 = drinkDisp;
                }
                else if(ReviewCart_Page.list3 == null) {
                    ReviewCart_Page.tp3 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list3 = drinkDisp;
                }
                else if(ReviewCart_Page.list4 == null) {
                    ReviewCart_Page.tp4 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list4 = drinkDisp;
                }
                else if(ReviewCart_Page.list5 == null) {
                    ReviewCart_Page.tp5 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list5 = drinkDisp;
                }
                else if(ReviewCart_Page.list6 == null) {
                    ReviewCart_Page.tp6 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list6 = drinkDisp;
                }
                else if(ReviewCart_Page.list7 == null) {
                    ReviewCart_Page.tp7 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list7 = drinkDisp;
                }
                else if(ReviewCart_Page.list8 == null) {
                    ReviewCart_Page.tp8 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list8 = drinkDisp;
                }
                else if(ReviewCart_Page.list9 == null) {
                    ReviewCart_Page.tp9 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list9 = drinkDisp;
                }
                else if(ReviewCart_Page.list10 == null) {
                    ReviewCart_Page.tp10 = DrinkMenu_Page.drinkprice_int;
                    ReviewCart_Page.list10 = drinkDisp;
                }
                DrinkMenu_Page.drinkprice_int = 2;
                DrinkMenu_Page.drinksize_int = 1;
                DrinkMenu_Page.drinktype_int = 1;
                DrinkMenu_Page.this.startActivity(intent);

            }

        });
    }

    public void addListenerOnButton_Cancel() {

        final Context context = this;

        cancel_drink_btn = (Button) findViewById(R.id.button_Cancel_Drink_id);
        cancel_drink_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, StartPage.class);
                DrinkMenu_Page.drinkprice_int = 2;
                DrinkMenu_Page.drinksize_int = 1;
                DrinkMenu_Page.drinktype_int = 1;
                DrinkMenu_Page.this.startActivity(intent);

            }

        });
    }


   class drinksize_class implements RadioGroup.OnCheckedChangeListener {
       drinksize_class() {

       }
 //1823
       public void onCheckedChanged(RadioGroup groupSize, int sizeCheckedId) {
           RadioButton rb_drinksize = (RadioButton) DrinkMenu_Page.this.findViewById(sizeCheckedId);
           if (rb_drinksize.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkSmall_id))) {
               DrinkMenu_Page.drinkprice_int = 2;
               DrinkMenu_Page.this.drinksizetext.setText("Size Selected: \n Small ($2)");
               DrinkMenu_Page.drinksize_int = 1;
           }
           if (rb_drinksize.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkMedium_id))) {
               DrinkMenu_Page.drinkprice_int = 3;
               DrinkMenu_Page.this.drinksizetext.setText("Size Selected: \n Medium ($3)");
               DrinkMenu_Page.drinksize_int = 2;
           }
           if (rb_drinksize.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkLarge_id))) {
               DrinkMenu_Page.drinkprice_int = 4;
               DrinkMenu_Page.this.drinksizetext.setText("Size Selected: \n Large ($4)");
               DrinkMenu_Page.drinksize_int = 3;
           }
           DrinkMenu_Page.this.drinkpricetext.setText("Price: $" + DrinkMenu_Page.drinkprice_int);
       }

   }

    class drinktype_class implements RadioGroup.OnCheckedChangeListener {
        drinktype_class() {

        }

        public void onCheckedChanged(RadioGroup groupType, int typeCheckedId) {
            RadioButton rb_drinktype = (RadioButton) DrinkMenu_Page.this.findViewById(typeCheckedId);
            if (rb_drinktype.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkCoke_id))) {
                DrinkMenu_Page.this.drinktypetext.setText("Drink Selected: \n Coke");
                DrinkMenu_Page.drinktype_int = 1;
            }
            if (rb_drinktype.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkFanta_id))) {
                DrinkMenu_Page.this.drinktypetext.setText("Drink Selected: \n Fanta");
                DrinkMenu_Page.drinktype_int = 2;
            }
            if (rb_drinktype.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkDietCoke_id))) {
                DrinkMenu_Page.this.drinktypetext.setText("Drink Selected: \n Diet Coke");
                DrinkMenu_Page.drinktype_int = 3;
            }
            if (rb_drinktype.equals((RadioButton) DrinkMenu_Page.this.findViewById(R.id.radioButton_drinkPeppers_id))) {
                DrinkMenu_Page.this.drinktypetext.setText("Drink Selected: \n Peppers");
                DrinkMenu_Page.drinktype_int = 4;
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu__page);

        drinksize_int = 1;
        drinktype_int = 1;
        drinkpricetext = (TextView) findViewById(R.id.textView_drinkPrice_id);
        drinkpricetext.setText("Price: $0");
        drinksizetext = (TextView) findViewById(R.id.textView_drinkSizeSelected_id);
        drinksizetext.setText("\n Size Selected: \nSmall ($2)");
        drinktypetext = (TextView) findViewById(R.id.textView_drinkTypeSelected_id);
        drinktypetext.setText("\n Drink Selected: \nCoke");
        addListenerOnButton_Add_To_Cart();
        addListenerOnButton_Cancel();
        rg_drinksize = (RadioGroup) findViewById(R.id.radioGroup_drinkSize_id);
        rg_drinksize.setOnCheckedChangeListener( new drinksize_class());
        rg_drinktype = (RadioGroup) findViewById(R.id.radiogroup_drinkType_id);
        rg_drinktype.setOnCheckedChangeListener( new drinktype_class());


        //add_to_cart_drinks_btn  already added in addListenerOnButton().
        //cancel_drink_btn = (Button) findViewById(R.id.button_Cancel_Drink_id);
        //cancel_drink_btn.setOnClickListener();


    }


}
