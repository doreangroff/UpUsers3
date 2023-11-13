package com.example.upusers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AllTablesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tables);
        Button genderButton = findViewById(R.id.GenderButton);
        genderButton.setOnClickListener((click) ->
        {
            Intent intent = new Intent(this, GendersActivity.class);
            startActivity(intent);
        });
    }
}
