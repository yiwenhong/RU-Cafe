/**
 * creates the adapter for recyclerview for donuts
 * @author Haoyue Zhou Yiwen Hong
 */
package com.example.rucafe;

import static com.example.rucafe.MainActivity.myOrder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    String data1 [];
    String data2 [];
    int images[];
    Context context;

    /**
     * constructor for adapter
     * @param ct
     * @param s1
     * @param s2
     * @param img
     */

    public MyAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    /**
     * instantiate layout XML file into its corresponding view objects
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    /**
     * this method tells the recycler view which image, price, and name of donuts to laod
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    /**
     * this method returns the total length of the array for donuts
     * @return
     */
    @Override
    public int getItemCount() {
        return data1.length;
    }

    /**
     * This method holds the views in each row
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1, myText2;
        ImageView myImage;
        Button add_button;
        EditText quantity;
        String noQuantity;
        String message;
        String zeroQuantity;
        String message2;
        String add;
        String added;
        String notAdded;
        String add1;
        String add2;

        /**
         * This method connects the xml buttons to myAdapter java page
         * @param itemView
         */
        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.donutName);
            myText2 = itemView.findViewById((R.id.donutPrice));
            myImage = itemView.findViewById(R.id.donutImg);
            add_button = itemView.findViewById(R.id.addButton);
            quantity = itemView.findViewById(R.id.editTextNumber);
            setAddButtonOnClick(itemView);

            noQuantity = itemView.getContext().getString(R.string.no_quantity);
            message = itemView.getContext().getString(R.string.message);
            zeroQuantity = itemView.getContext().getString(R.string.zeor_quantity);
            message2 = itemView.getContext().getString(R.string.message2);
            add = itemView.getContext().getString(R.string.addToOrder);
            added = itemView.getContext().getString(R.string.added);
            notAdded = itemView.getContext().getString(R.string.notAdded);
            add1 = itemView.getContext().getString(R.string.add1);
            add2 = itemView.getContext().getString(R.string.add2);

        }

        /**
         * add function to add buttons
         * it will also trigger alerts if nothing or zero is entered in quantity
         * it will ask if user wants to add item to order and user can pick Yes or No
         * @param itemView
         */
        private void setAddButtonOnClick(@NonNull View itemView) {
            add_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String quant = quantity.getText().toString();
                    if (quant.isEmpty()) {
                        new AlertDialog.Builder(itemView.getContext())
                                .setTitle(noQuantity)
                                .setMessage(message)
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .setNegativeButton(android.R.string.no, null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                    else if (Integer.parseInt(quant) == 0){
                        new AlertDialog.Builder(itemView.getContext())
                                .setTitle(zeroQuantity)
                                .setMessage(message2)
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .setNegativeButton(android.R.string.no, null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                    else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                    alert.setTitle(add);
                    alert.setMessage(add1 + data1[getAdapterPosition()] + add2);
                    int quantity = Integer.parseInt(quant);
                    //handle the "YES" click
                    alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                     added, Toast.LENGTH_LONG).show();
                            //add this donut to order
                            String donutstring = data1[getAdapterPosition()];
                            String[] donut = donutstring.split(" ");
                            String flavor = donut[0];
                            String type = donut[1] + " " + donut[2];
                            Donut test = new Donut (type, flavor, quantity);
                            myOrder.add(test);
                        }
                        //handle the "NO" click
                    }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    notAdded, Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
                }
            });
        }


    }

}
