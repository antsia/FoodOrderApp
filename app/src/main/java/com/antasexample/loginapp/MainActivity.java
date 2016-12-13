package com.antasexample.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Sveiki!");

        final Button bOrder = (Button) findViewById(R.id.bOrder);
        final Button bEdit = (Button) findViewById(R.id.bEdit);
        final Button bLogout = (Button) findViewById(R.id.bLogout);


        bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserAreaActivity.class);
                MainActivity.this.startActivity(intent);
            }
    });
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActvity.class);
                MainActivity.this.startActivity(intent);
            }
        });
}
}
