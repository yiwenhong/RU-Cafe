/**
 * creates coffee page to add different types of coffees to the order
 * @author Haoyue Zhou Yiwen Hong
 */

package com.example.rucafe;

import static com.example.rucafe.MainActivity.myOrder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class coffeeActivity extends AppCompatActivity {


    Spinner coffeeSpinner;
    Spinner coffeeSpinnerSize;
    Button addCoffeeButton;

    /**
     * sets the page icons when opened
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        coffeeSpinner = findViewById(R.id.coffeeSpinner);
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        coffeeSpinner.setAdapter(adapter);
        coffeeSpinnerSize = findViewById(R.id.coffeeSpinnerSize);
        String[] size = new String[]{"Short", "Tall", "Grande", "Venti"};
        ArrayAdapter<String> sizing = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, size);
        coffeeSpinnerSize.setAdapter(sizing);
        addCoffeeButton = findViewById(R.id.addCoffeeButton);
        TextView coffeeSubtotal = (TextView)findViewById(R.id.coffeeSubtotal);
        String sub = getResources().getString(R.string.subtotal169);
        String subtotal = getResources().getString(R.string.subtotal);
        coffeeSubtotal.setText(sub);

        /**
         * creates a coffee to add to order
         */
        addCoffeeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                myOrder.add(test);
            }
        });
        /**
         * sets subtotal when clicking syrup
         */
            CheckBox syrup = (CheckBox)findViewById(R.id.Syrup);
            syrup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ArrayList<String> addins = new ArrayList<String>();
                        if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                            addins.add("Syrup");
                        }
                        if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                            addins.add("Milk");
                        }
                        if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                            addins.add("Whipped Cream");
                        }
                        if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                            addins.add("Cream");
                        }
                        if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                            addins.add("Caramel");
                        }
                        String size = coffeeSpinnerSize.getSelectedItem().toString();
                        int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                        Coffee test = new Coffee(size, addins, quantity);
                        double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                        coffeeSubtotal.setText( subtotal + String.valueOf(itemprice));
            }
        });
        /**
         * sets subtotal when clicking milk
         */
        CheckBox milk = (CheckBox)findViewById(R.id.Milk);
        milk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                coffeeSubtotal.setText(subtotal + String.valueOf(itemprice));
            }
        });
        /**
         * sets subtotal when clicking whipped cream
         */
        CheckBox whippedcream = (CheckBox)findViewById(R.id.WhippedCream);
        whippedcream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                coffeeSubtotal.setText(subtotal + String.valueOf(itemprice));
            }
        });
        /**
         * sets subtotal when clicking cream
         */
        CheckBox cream = (CheckBox)findViewById(R.id.Cream);
        cream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                coffeeSubtotal.setText(subtotal + String.valueOf(itemprice));
            }
        });
        /**
         * sets subtotal when clicking caramel
         */
        CheckBox caramel = (CheckBox)findViewById(R.id.Caramel);
        caramel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                coffeeSubtotal.setText(subtotal + String.valueOf(itemprice));
            }
        });
        /**
         * sets subtotal when clicking quantity
         */
        coffeeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                coffeeSubtotal.setText(subtotal + String.valueOf(itemprice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        /**
         * sets subtotal when clicking size
         */
        coffeeSpinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ArrayList<String> addins = new ArrayList<String>();
                if (((CheckBox) findViewById(R.id.Syrup)).isChecked()) {
                    addins.add("Syrup");
                }
                if (((CheckBox) findViewById(R.id.Milk)).isChecked()) {
                    addins.add("Milk");
                }
                if (((CheckBox) findViewById(R.id.WhippedCream)).isChecked()) {
                    addins.add("Whipped Cream");
                }
                if (((CheckBox) findViewById(R.id.Cream)).isChecked()) {
                    addins.add("Cream");
                }
                if (((CheckBox) findViewById(R.id.Caramel)).isChecked()) {
                    addins.add("Caramel");
                }
                String size = coffeeSpinnerSize.getSelectedItem().toString();
                int quantity = Integer.parseInt((coffeeSpinner.getSelectedItem().toString()));
                Coffee test = new Coffee(size, addins, quantity);
                double itemprice = Math.round(test.itemPrice() * 100.0) / 100.0;
                coffeeSubtotal.setText(subtotal + String.valueOf(itemprice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

    }
}