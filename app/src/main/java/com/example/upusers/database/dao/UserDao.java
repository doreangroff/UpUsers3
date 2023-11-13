package com.example.upusers.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.upusers.database.entites.User;

import java.util.List;
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);
    @Update
    void update(User user);
    @Delete
    void delete(User user);
    @Query("Select * From Users")
    List<User> getAllUsers();
}
