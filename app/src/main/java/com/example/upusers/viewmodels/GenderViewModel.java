package com.example.upusers.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.upusers.database.Database;
import com.example.upusers.database.dao.GenderDao;
import com.example.upusers.database.entites.Gender;

import java.util.List;

public class GenderViewModel extends AndroidViewModel {
    private GenderDao genderDao;
    private MutableLiveData<List<Gender>> allData = new MutableLiveData<>();
    private MutableLiveData<Gender> genderAt;
    public GenderViewModel(Application application){
        super(application);
        Database database = Database.getDatabase(application);
        genderDao = database.genderDao();
        
    }
    public MutableLiveData<List<Gender>> getAllData(){return  allData;}
    public MutableLiveData<Gender> getGenderAt(long id)
    {
        genderAt = new MutableLiveData<Gender>();
        new Thread(() -> {
            genderAt.postValue( genderDao.getGenderAt(id));
        }).start();
        return genderAt;
    }
    public void loadGenderData(){
        Runnable loadGenderRnb = () -> {
            allData.postValue(genderDao.getAllGenders());
        };
        Thread thread = new Thread(loadGenderRnb);
        thread.start();
    }
    public void insert(Gender gender)
    {
        genderDao.insert(gender);
    }
    public void update(Gender gender)
    {
        new Thread(
                () ->{
                    genderDao.update(gender);
                }).start();
    }
    public void delete(Gender gender)
    {
        new Thread(
                () -> {
                    genderDao.delete(gender);
                }).start();
    }
}
