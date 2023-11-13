package com.example.upusers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import com.example.upusers.R;
import com.example.upusers.database.entites.Gender;

import java.util.List;

public class GenderAdapter extends ArrayAdapter<Gender> {
    private LayoutInflater inflater;
    private int layout;
    private List<Gender> genders;
    public GenderAdapter(Context context, @LayoutRes int resource, List<Gender> genders){
        super(context, resource, genders);
        this.layout = resource;
        this.genders = genders;

        inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);
        TextView idtext = view.findViewById(R.id.genderIdAdapter);
        TextView gendertext = view.findViewById(R.id.genderTextAdapter);
        Gender gender = genders.get(position);
        idtext.setText(Long.toString(gender.Gender_id));
        gendertext.setText(gender.Gender_name);
        return view;
    }
    public Gender getGenderAt(int i){return genders.get(i);}
}
