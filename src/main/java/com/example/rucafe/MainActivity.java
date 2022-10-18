/**
 * creates main page and access to ordering pages
 * @author Haoyue Zhou Yiwen Hong
 */
package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton donutImage;
    ImageButton orderImage;
    ImageButton coffeeImage;
    ImageButton storeOrderImage;

    public static Order myOrder = new Order();
    public static StoreOrders storeOrders = new StoreOrders();
    public static Order clear = new Order();

    /**
     * sets main page when app is opened
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutImage = (ImageButton) findViewById (R.id.donutButton);
        donutImage.setOnClickListener(new View.OnClickListener() {
            /**
             * loads donuts page when clicked
             */
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, donutActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        orderImage = (ImageButton) findViewById(R.id.currentOrderButton);
        orderImage.setOnClickListener(new View.OnClickListener() {
            /**
             * loads orders page when clicked
             */
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, orderActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        coffeeImage = (ImageButton) findViewById(R.id.coffeeButton);
        coffeeImage.setOnClickListener(new View.OnClickListener() {
            /**
             * loads coffee page when clicked
             */
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, coffeeActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        storeOrderImage = (ImageButton) findViewById(R.id.storeOrderButton);
        storeOrderImage.setOnClickListener(new View.OnClickListener() {
            /**
             * loads store orders page when clicked
             */
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, storeOrderActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }



}