/**
 * creates order page to view and delete items in current order
 * @author Haoyue Zhou Yiwen Hong
 */
package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class orderActivity extends AppCompatActivity {

    ListView listView;
    Button placeOrderButton;

    /**
     * loads information for subtotal, total, tax and current order
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        TextView text = (TextView) findViewById(R.id.textView1);
        String subtotal1 = getResources().getString(R.string.subtotal);
        String tax1 = getResources().getString(R.string.tax);
        String total1 = getResources().getString(R.string.total);
        String subtotalstring = String.format("%.2f", MainActivity.myOrder.calculateSubtotal());
        String salestaxstring = String.format("%.2f", MainActivity.myOrder.calculateTax());
        String itemtotalstring = String.format("%.2f",MainActivity.myOrder.calculateTotal());
        text.setText(subtotal1 + subtotalstring + "\n" +
                tax1 + salestaxstring + "\n" +
                total1 + itemtotalstring);

        String defaultInputText = getResources().getString(R.string.button_show_selection);
        String alertTitle = getResources().getString(R.string.No_items);
        String are = getResources().getString(R.string.deleteitem);

        listView = (ListView)findViewById(R.id.orderListview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,MainActivity.myOrder.getCurrentOrder());
        listView.setAdapter(arrayAdapter);

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
                new AlertDialog.Builder(orderActivity.this).setTitle(are)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.myOrder.remove(MainActivity.myOrder.getCurrentOrder().get(Item));
                                arrayAdapter.notifyDataSetChanged();
                                //update subtotals
                                String subtotalstring = String.format("%.2f", MainActivity.myOrder.calculateSubtotal());
                                String salestaxstring = String.format("%.2f", MainActivity.myOrder.calculateTax());
                                String itemtotalstring = String.format("%.2f",MainActivity.myOrder.calculateTotal());
                                text.setText(subtotal1 + subtotalstring + "\n" +
                                        tax1 + salestaxstring + "\n" +
                                        total1 + itemtotalstring);

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
        placeOrderButton = (Button)findViewById(R.id.placeOrderButton);

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            /**
             * adds current order to arraylist of store orders
             * @param v
             */
            @Override
            public void onClick(View v) {
                if (MainActivity.myOrder.getCurrentOrder().isEmpty()){
                    new AlertDialog.Builder(orderActivity.this)
                            .setTitle(alertTitle)
                            .setMessage(defaultInputText)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                else {
                    Order copyOrder = new Order();
                    for (int j = 0; j < MainActivity.myOrder.getSize(); j++) {
                        copyOrder.getCurrentOrder().add(MainActivity.myOrder.getCurrentOrder().get(j));
                    }
                    MainActivity.storeOrders.add(copyOrder);
                    MainActivity.myOrder.getCurrentOrder().clear();
                    arrayAdapter.notifyDataSetChanged();
                    String subtotalstring = String.format("%.2f", MainActivity.myOrder.calculateSubtotal());
                    String salestaxstring = String.format("%.2f", MainActivity.myOrder.calculateTax());
                    String itemtotalstring = String.format("%.2f", MainActivity.myOrder.calculateTotal());
                    text.setText(subtotal1 + subtotalstring + "\n" +
                            tax1 + salestaxstring + "\n" +
                            total1 + itemtotalstring);
                }
            }
        });
    }



}