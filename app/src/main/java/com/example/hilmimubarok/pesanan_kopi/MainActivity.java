package com.example.hilmimubarok.pesanan_kopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void increment (View view) {
    if (quantity == 100) {
        Toast.makeText(this, "Pesanan Maksimal 100", Toast.LENGTH_SHORT).show();
        return;
    }
    quantity = quantity + 1;
    display(quantity);
}

public void decrement (View view) {
    if (quantity == 1) {
        Toast.makeText(this, "Pesanan Minimal 1", Toast.LENGTH_SHORT).show();
        return;
    }
    quantity = quantity - 1;
    display(quantity);
}

public void Submitorder (View view) {
    EditText nameEditText = (EditText) findViewById(R.id.edt_name);
    String name = nameEditText.getText().toString();
    Log.v("MainActivity", "Nama:"+name);

    EditText no_meja = (EditText) findViewById(R.id.edt_number);
    int meja = Integer.parseInt(no_meja.getText().toString());
    Log.v("MainActivity", "No. Meja:"+meja);

    CheckBox whippedcreamChekbox = (CheckBox) findViewById(R.id.WhippedCream_checkbox);
    boolean haswhippedcream = whippedcreamChekbox.isChecked();
    Log.v("MainActivity", "has whippedcream"+haswhippedcream);

    CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.Chocolate_checkbox);
    boolean haschocolate = chocolateCheckbox.isChecked();
    Log.v("MainActivity", "has chocolate"+haschocolate);

    int price = calculateprice(haswhippedcream,haschocolate);
    String pricemessage = CreateOrderSummary(price,name,meja,haswhippedcream,haschocolate);

    displayMessage(pricemessage);
}

    private int calculateprice(boolean addwhipedcream, boolean addchocolate) {
        int harga = 5000;
        if (addwhipedcream) {
            harga = harga + 1000;
        }
        if (addchocolate) {
            harga = harga + 2000;
        }

        return quantity * harga;
    }

    private String CreateOrderSummary(int price, String name, int meja, boolean addWhippedCream, boolean addChocolate) {
        String pricemessage = " Nama"+name;
        pricemessage += "\n No. Meja = "+meja;
        pricemessage += "\n add Whipped Cream ? = "+addWhippedCream;
        pricemessage += "\n add Chocolate ? = "+addChocolate;
        pricemessage += "\n add quantity "+quantity;
        pricemessage += "\n Total Rp "+price;
        pricemessage += "\n Thank You";
        return pricemessage;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
}