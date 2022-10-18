/**
 * creates store order page to view and delete orders from the store order roster
 * @author Haoyue ZHou Yiwen Hong
 */

package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;


public class storeOrderActivity extends AppCompatActivity {
    ListView listView;

    /**
     * loads information for subtotal, total, tax of store orders
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);
        listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,MainActivity.storeOrders.getOrders());
        listView.setAdapter(arrayAdapter);
        TextView text = (TextView) findViewById(R.id.textView2);
        String pretext = getResources().getString((R.string.pretext));
        String are = getResources().getString(R.string.deleteitem);
        String subtotal1 = getResources().getString(R.string.subtotal);
        String tax1 = getResources().getString(R.string.tax);
        String total1 = getResources().getString(R.string.total);


        text.setText(pretext);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /**
             * provides option for deletion when long hold
             * @param adapterView
             * @param view
             * @param Item
             * @param l
             * @return
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int Item, long l) {
                new AlertDialog.Builder(storeOrderActivity.this).setTitle(are)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.storeOrders.remove(MainActivity.storeOrders.getOrders().get(Item));
                                arrayAdapter.notifyDataSetChanged();;

                            }
                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();

                return false;
            }
        });
        /**
         * displays total,subtotal, and tax of selected order
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double subtotal = MainActivity.storeOrders.getOrders().get(position).calculateSubtotal();
                double tax = MainActivity.storeOrders.getOrders().get(position).calculateTax();
                double total = MainActivity.storeOrders.getOrders().get(position).calculateTotal();
                String subtotalstring = String.format("%.2f", subtotal);
                String salestaxstring = String.format("%.2f", tax);
                String itemtotalstring = String.format("%.2f",total);
                text.setText(subtotal1 + subtotalstring + "\n" +
                        tax1 + salestaxstring + "\n" +
                        total1 + itemtotalstring);


            }
        });
    }
}