package com.truiton.mobile.vision.ocr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CompareActivity extends AppCompatActivity {

    private TextView compareRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Compare Prices");
        setSupportActionBar(toolbar);

        String[] items = getIntent().getStringExtra("items").split(",");
        String[] prices = getIntent().getStringExtra("prices").split(",");

        List<String> discountedPrices = Arrays.asList(prices.clone());

        discountedPrices.set(items.length-1, "Flipkart Prices!");
        float discount = 5;
        Random generator = new Random();
        for (int i = 0; i < items.length-1; i++){
            discount = generator.nextFloat()*10;
            discountedPrices.set(i,Float.toString(Float.valueOf(prices[i]) - discount));
        }

        compareRes = (TextView) findViewById(R.id.compareText);

        compareRes.setText("Items and comparison:\n\n");

        for (int i = items.length-1; i >=0; i--){
            compareRes.setText( compareRes.getText() + "\n" +
                    items[i] + "\t\t\t" + prices[i] + "\t\t\t" + discountedPrices.get(i) + "\n");
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "User:priyamtejaswin-Items Added to Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
