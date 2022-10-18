/**
 * creates donut page to add different types of donuts to the order
 * @author Haoyue Zhou Yiwen Hong
 */

package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;

public class donutActivity extends AppCompatActivity {
    RecyclerView donutRecyclerView;

    String s1[];
    String s2 [];

    int [] images = {R.drawable.chocolate_cake_donut,R.drawable.chocolate_donut_hole,R.drawable.chocolate_yeast_donut,
    R.drawable.lemon_cake_donut, R.drawable.lemon_donut_hole, R.drawable.lemon_yeast_donut,
    R.drawable.strawberry_cake_donut, R.drawable.strawberry_donut_hole, R.drawable.strawberry_yeast_donut,
    R.drawable.vanilla_cake_donut, R.drawable.vanilla_donut_hole, R.drawable.vanilla_yeast_dnout};

    /**
     * This function create the recyclerview list to order donuts
     * each row contains the name of the donut, the price of the donut, and picture of the donut
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        donutRecyclerView = findViewById(R.id.donutRecyclerView);

        s1 = getResources().getStringArray(R.array.donuts);
        s2 = getResources().getStringArray(R.array.donutPrice);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        donutRecyclerView.setAdapter(myAdapter);
        donutRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}