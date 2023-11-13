package com.example.upusers.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.upusers.R;
import com.example.upusers.database.entites.Gender;
import com.example.upusers.viewmodels.GenderViewModel;

public class GenderFragment extends Fragment {
    boolean redact;
    private long id;
    Button addButton;
    Button cancelButton;
    GenderViewModel genderViewModel;
    Gender editGender;
    EditText genderText;

    public GenderFragment(){redact = false;}
    public void CloseFragment(){
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.remove(this);
        transaction.commit();
    }
    public GenderFragment(long id)
    {
        redact = true;
        this.id = id;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_gender, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editGender = new Gender();
        genderText = view.findViewById(R.id.genderFragmentEditText);
        genderViewModel = new ViewModelProvider(requireActivity()).get(GenderViewModel.class);
        addButton = view.findViewById(R.id.addGenderFragmentButton);
        cancelButton = view.findViewById(R.id.cancelGenderFragmentButton);
        cancelButton.setOnClickListener((click) ->CloseFragment());
        if (redact)
        {
            addButton.setText("Изменить");
            genderViewModel.getGenderAt(id).observe(getViewLifecycleOwner(), new Observer<Gender>() {
                @Override
                public void onChanged(Gender gender) {
                    editGender = gender;
                    genderText.setText(gender.Gender_name);
                }
            });
            addButton.setOnClickListener((click) -> {
                editGender.Gender_name = genderText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        genderViewModel.update(editGender);
                        CloseFragment();
                    }
                }).start();
            });
        }
        else {
            addButton.setOnClickListener((click) -> {
                editGender.Gender_name = genderText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        genderViewModel.insert(editGender);
                        CloseFragment();
                    }
                }).start();
            });
        }
    }
}
