package com.example.upusers.database.dao;

import static java.nio.charset.CodingErrorAction.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.upusers.database.entites.Gender;

import java.util.List;

@Dao
public interface GenderDao {
    @Insert(onConflict = 2)
    public void insert(Gender gender);
    @Update
    public void update(Gender gender);
    @Delete
    public void delete(Gender gender);
    @Query("Select * From Genders")
    List<Gender> getAllGenders();
    @Query("SELECT * FROM Genders WHERE Gender_id = :id")
    Gender getGenderAt(long id);
}
