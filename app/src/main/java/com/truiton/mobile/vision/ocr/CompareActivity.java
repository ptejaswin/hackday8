package com.truiton.mobile.vision.ocr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

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

        compareRes = (TextView) findViewById(R.id.compareText);


        compareRes.setText("Paste items and comparison here");

        compareRes.setText(compareRes.getText()+"\n\nhnnjnj");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
