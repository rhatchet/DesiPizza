package com.example.sari.desipizza;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ReviewCart_Page extends AppCompatActivity {

    public static String list1;
    public static String list2;
    public static String list3;
    public static String list4;
    public static String list5;
    public static String list6;
    public static String list7;
    public static String list8;
    public static String list9;
    public static String list10;
    public static int tp1;
    public static int tp2;
    public static int tp3;
    public static int tp4;
    public static int tp5;
    public static int tp6;
    public static int tp7;
    public static int tp8;
    public static int tp9;
    public static int tp10;
    public static TextView orderDisp1;
    public static TextView orderDisp2;
    public static TextView orderDisp3;
    public static TextView orderDisp4;
    public static TextView orderDisp5;
    public static TextView orderDisp6;
    public static TextView orderDisp7;
    public static TextView orderDisp8;
    public static TextView orderDisp9;
    public static TextView orderDisp10;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private CheckBox cb7;
    private CheckBox cb8;
    private CheckBox cb9;
    private CheckBox cb10;

    public Button confirmOrder_btn;
    public Button back_btn;
    public Button cancelOrder_btn;
    public Button removeOrder_btn;

    private TextView totalPriceDisp;
    private static int grandTotal; //thetot


    public void addListenerOnButton_ConfirmOrder() {

        final Context context = this;

        confirmOrder_btn = (Button) findViewById(R.id.button_ConfirmOrder_id);
        confirmOrder_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(ReviewCart_Page.grandTotal > 0) {
                    Intent intent = new Intent(context, FinalPage.class);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    editor.putInt("TotalPrice", 0);
                    editor.commit();
                    ReviewCart_Page.list1 = null;
                    ReviewCart_Page.list2 = null;
                    ReviewCart_Page.list3 = null;
                    ReviewCart_Page.list4 = null;
                    ReviewCart_Page.list5 = null;
                    ReviewCart_Page.list6 = null;
                    ReviewCart_Page.list7 = null;
                    ReviewCart_Page.list8 = null;
                    ReviewCart_Page.list9 = null;
                    ReviewCart_Page.list10 = null;
                    ReviewCart_Page.this.startActivity(intent);
                    return;
                }
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //alertDialogBuilder.setMessage("NO ITEMS IN CART!!! ");
                ReviewCart_Page.this.totalPriceDisp.setText("NO ITEMS IN CART!!! ");
            }
        });
    }

    public void addListenerOnButton_CancelOrder() {

        final Context context = this;

        cancelOrder_btn = (Button) findViewById(R.id.button_CancelOrder_id);
        cancelOrder_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(ReviewCart_Page.grandTotal > 0) {
                    Intent intent = new Intent(context, StartPage.class);
                    ReviewCart_Page.list1 = null;
                    ReviewCart_Page.list2 = null;
                    ReviewCart_Page.list3 = null;
                    ReviewCart_Page.list4 = null;
                    ReviewCart_Page.list5 = null;
                    ReviewCart_Page.list6 = null;
                    ReviewCart_Page.list7 = null;
                    ReviewCart_Page.list8 = null;
                    ReviewCart_Page.list9 = null;
                    ReviewCart_Page.list10 = null;

                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    editor.putInt("TotalPrice", 0);
                    editor.commit();

                    ReviewCart_Page.this.startActivity(intent);
                }
            }
        });
    }

    public void addListenerOnButton_Back() {

        final Context context = this;

        back_btn = (Button) findViewById(R.id.button_Back_id);
        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }

        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_cart__page);
        SharedPreferences sp = getSharedPreferences("spSettings", 0);
        this.cb1 = (CheckBox) findViewById(R.id.checkBox1);
        this.cb2 = (CheckBox) findViewById(R.id.checkBox2);
        this.cb3 = (CheckBox) findViewById(R.id.checkBox3);
        this.cb4 = (CheckBox) findViewById(R.id.checkBox4);
        this.cb5 = (CheckBox) findViewById(R.id.checkBox5);
        this.cb6 = (CheckBox) findViewById(R.id.checkBox6);
        this.cb7 = (CheckBox) findViewById(R.id.checkBox7);
        this.cb8 = (CheckBox) findViewById(R.id.checkBox8);
        this.cb9 = (CheckBox) findViewById(R.id.checkBox9);
        this.cb10 = (CheckBox) findViewById(R.id.checkBox10);
        this.cb1.setVisibility(View.INVISIBLE);
        this.cb2.setVisibility(View.INVISIBLE);
        this.cb3.setVisibility(View.INVISIBLE);
        this.cb4.setVisibility(View.INVISIBLE);
        this.cb5.setVisibility(View.INVISIBLE);
        this.cb6.setVisibility(View.INVISIBLE);
        this.cb7.setVisibility(View.INVISIBLE);
        this.cb8.setVisibility(View.INVISIBLE);
        this.cb9.setVisibility(View.INVISIBLE);
        this.cb10.setVisibility(View.INVISIBLE);
        orderDisp1 = (TextView) findViewById(R.id.tv1_id);
        orderDisp2 = (TextView) findViewById(R.id.tv2_id);
        orderDisp3 = (TextView) findViewById(R.id.tv3_id);
        orderDisp4 = (TextView) findViewById(R.id.tv4_id);
        orderDisp5 = (TextView) findViewById(R.id.tv5_id);
        orderDisp6 = (TextView) findViewById(R.id.tv6_id);
        orderDisp7 = (TextView) findViewById(R.id.tv7_id);
        orderDisp8 = (TextView) findViewById(R.id.tv8_id);
        orderDisp9 = (TextView) findViewById(R.id.tv9_id);
        orderDisp10 = (TextView) findViewById(R.id.tv10_id);
        orderDisp1.setText(list1);
        orderDisp2.setText(list2);
        orderDisp3.setText(list3);
        orderDisp4.setText(list4);
        orderDisp5.setText(list5);
        orderDisp6.setText(list6);
        orderDisp7.setText(list7);
        orderDisp8.setText(list8);
        orderDisp9.setText(list9);
        orderDisp10.setText(list10);
        this.totalPriceDisp = (TextView) findViewById(R.id.textView_TotalPriceCart);
        if (list1 != null) {
            this.cb1.setVisibility(View.VISIBLE);
        }
        if (list2 != null) {
            this.cb2.setVisibility(View.VISIBLE);
        }
        if (list3 != null) {
            this.cb3.setVisibility(View.VISIBLE);
        }
        if (list4 != null) {
            this.cb4.setVisibility(View.VISIBLE);
        }
        if (list5 != null) {
            this.cb5.setVisibility(View.VISIBLE);
        }
        if (list6 != null) {
            this.cb6.setVisibility(View.VISIBLE);
        }
        if (list7 != null) {
            this.cb7.setVisibility(View.VISIBLE);
        }
        if (list8 != null) {
            this.cb8.setVisibility(View.VISIBLE);
        }
        if (list9 != null) {
            this.cb9.setVisibility(View.VISIBLE);
        }
        if (list10 != null) {
            this.cb10.setVisibility(View.VISIBLE);
        }

        if (list1 == null && list2 == null && list3 == null && list4 == null && list5 == null && list6 == null && list7 == null && list8 == null && list9 == null && list10 == null) {
            Editor editor = sp.edit();
            editor.putInt("TotalPrice", 0);
            editor.commit();
        }
        grandTotal = (((((((((tp1 + tp2) + tp3) + tp4) + tp5) + tp6) + tp7) + tp8) + tp9) + tp10);
        this.totalPriceDisp.setText("Price: $" + grandTotal);
       //Button calls
        addListenerOnButton_ConfirmOrder();
        addListenerOnButton_Back();
        addListenerOnButton_CancelOrder();


        this.cb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb1.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb2.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb3.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb4.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb5.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb6.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb7.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb8.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb9.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.cb10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.VISIBLE);
                }
                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb2.isChecked()
                        && !ReviewCart_Page.this.cb3.isChecked() && !ReviewCart_Page.this.cb4.isChecked()
                        && !ReviewCart_Page.this.cb5.isChecked() && !ReviewCart_Page.this.cb6.isChecked()
                        && !ReviewCart_Page.this.cb7.isChecked() && !ReviewCart_Page.this.cb8.isChecked()
                        && !ReviewCart_Page.this.cb9.isChecked() && !ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        this.removeOrder_btn = (Button) findViewById(R.id.button_remove_id);
        this.removeOrder_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ReviewCart_Page.this.cb1.isChecked()) {
                    ReviewCart_Page.list1 = null;
                    ReviewCart_Page.this.cb1.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp1.setText(ReviewCart_Page.list1);
                    ReviewCart_Page.this.cb1.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp1;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp1 = 0;
                }

                if (ReviewCart_Page.this.cb2.isChecked()) {
                    ReviewCart_Page.list2 = null;
                    ReviewCart_Page.this.cb2.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp2.setText(ReviewCart_Page.list2);
                    ReviewCart_Page.this.cb2.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp2;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp2 = 0;
                }

                if (ReviewCart_Page.this.cb3.isChecked()) {
                    ReviewCart_Page.list3 = null;
                    ReviewCart_Page.this.cb3.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp3.setText(ReviewCart_Page.list3);
                    ReviewCart_Page.this.cb3.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp3;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp3 = 0;
                }

                if (ReviewCart_Page.this.cb4.isChecked()) {
                    ReviewCart_Page.list4 = null;
                    ReviewCart_Page.this.cb4.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp4.setText(ReviewCart_Page.list4);
                    ReviewCart_Page.this.cb4.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp4;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp4 = 0;
                }

                if (ReviewCart_Page.this.cb5.isChecked()) {
                    ReviewCart_Page.list5 = null;
                    ReviewCart_Page.this.cb5.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp5.setText(ReviewCart_Page.list5);
                    ReviewCart_Page.this.cb5.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp5;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp5 = 0;
                }

                if (ReviewCart_Page.this.cb6.isChecked()) {
                    ReviewCart_Page.list6 = null;
                    ReviewCart_Page.this.cb6.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp6.setText(ReviewCart_Page.list6);
                    ReviewCart_Page.this.cb6.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp6;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp6 = 0;
                }

                if (ReviewCart_Page.this.cb7.isChecked()) {
                    ReviewCart_Page.list7 = null;
                    ReviewCart_Page.this.cb7.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp7.setText(ReviewCart_Page.list7);
                    ReviewCart_Page.this.cb7.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp7;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp7 = 0;
                }

                if (ReviewCart_Page.this.cb8.isChecked()) {
                    ReviewCart_Page.list8 = null;
                    ReviewCart_Page.this.cb8.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp8.setText(ReviewCart_Page.list8);
                    ReviewCart_Page.this.cb8.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp8;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp8 = 0;
                }

                if (ReviewCart_Page.this.cb9.isChecked()) {
                    ReviewCart_Page.list9 = null;
                    ReviewCart_Page.this.cb9.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp9.setText(ReviewCart_Page.list9);
                    ReviewCart_Page.this.cb9.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp9;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp9 = 0;
                }

                if (ReviewCart_Page.this.cb10.isChecked()) {
                    ReviewCart_Page.list10 = null;
                    ReviewCart_Page.this.cb10.setVisibility(View.INVISIBLE);
                    ReviewCart_Page.orderDisp10.setText(ReviewCart_Page.list10);
                    ReviewCart_Page.this.cb10.setChecked(false);
                    Editor editor = ReviewCart_Page.this.getSharedPreferences("spSettings", 0).edit();
                    int newprice = ReviewCart_Page.grandTotal - ReviewCart_Page.tp10;
                    editor.putInt("TotalPrice", newprice);
                    editor.commit();
                    ReviewCart_Page.this.totalPriceDisp.setText("Price: $" + newprice);
                    ReviewCart_Page.grandTotal = newprice;
                    ReviewCart_Page.tp10 = 0;
                }

                if (!ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb1.isChecked()
                        && !ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb1.isChecked()
                        && !ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb1.isChecked()
                        && !ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb1.isChecked()
                        && !ReviewCart_Page.this.cb1.isChecked() && !ReviewCart_Page.this.cb1.isChecked())  {
                    ReviewCart_Page.this.removeOrder_btn.setVisibility(View.INVISIBLE);
                }
            }
        });




    }
}
