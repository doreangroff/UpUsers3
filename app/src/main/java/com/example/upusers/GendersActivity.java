package com.example.upusers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;

import com.example.upusers.adapters.GenderAdapter;
import com.example.upusers.database.Database;
import com.example.upusers.database.entites.Gender;
import com.example.upusers.fragments.GenderFragment;
import com.example.upusers.viewmodels.GenderViewModel;

import java.util.ArrayList;
import java.util.List;

public class GendersActivity extends AppCompatActivity {
    GenderViewModel genderViewModel;
    public Button addButton;
    public Button editButton;
    public Button deleteButton;
    public Button backButton;
    public Gender selectedGender;
    public GridView grid;
    public ArrayList<Gender> gender = new ArrayList<Gender>();
    public Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genders);
        db = Database.getDatabase(this);
        addButton = findViewById(R.id.addGenderButton);
        editButton = findViewById(R.id.changeGenderButton);
        deleteButton = findViewById(R.id.deleteGenderButton);
        backButton = findViewById(R.id.backGenderButton);
        grid = findViewById(R.id.gendersgrid);
        genderViewModel = new ViewModelProvider(this).get(GenderViewModel.class);
        genderViewModel.loadGenderData();

        backButton.setOnClickListener((click) ->
        {
            Intent intent = new Intent(this, AllTablesActivity.class);
            startActivity(intent);
        });
        addButton.setOnClickListener((click) ->
        {
            getSupportFragmentManager().beginTransaction().add(R.id.genderConsL, new GenderFragment(),
                    "fr").addToBackStack("frg").commit();
        });
        editButton.setOnClickListener((click) ->
        {
            if (selectedGender != null){
                getSupportFragmentManager().beginTransaction().add(R.id.genderConsL, new GenderFragment(selectedGender.Gender_id),
                        "fr").addToBackStack("frg").commit();
            }
        });
        deleteButton.setOnClickListener((click) ->
        {
            if(selectedGender != null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Удаление");
                builder.setMessage("Удалить?");
                builder.setCancelable(true);
                builder.setPositiveButton("Да", (dialogInterface, i1) -> {
                                genderViewModel.delete(selectedGender);
                   selectedGender = null;
                });
                builder.setNegativeButton("Нет", (dialogInterface, i2) -> dialogInterface.dismiss());
                builder.show();
            }
        });


        genderViewModel.getAllData().observe(this, new Observer<List<Gender>>() {
            @Override
            public void onChanged(List<Gender> genders) {
                grid.setAdapter(new GenderAdapter(getApplicationContext(), R.layout.genderlayout, genders));
            }
        });


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                grid.setItemChecked(position, true);
                selectedGender = ((GenderAdapter)parent.getAdapter()).getGenderAt(position);
            }
        });


    }


}
