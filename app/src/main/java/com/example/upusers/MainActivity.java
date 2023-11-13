package com.example.upusers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button b = findViewById(R.id.button2);
        b.setOnClickListener((click) ->
        {
            Intent i = new Intent(this, AllTablesActivity.class);
            startActivity(i);
        });*/

    }

}