package com.example.upusers.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.upusers.database.entites.UsersPosts;

import java.util.List;
@Dao
public interface UsersPostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UsersPosts usersPosts);
    @Update
    void update(UsersPosts usersPosts);
    @Delete
    void delete(UsersPosts usersPosts);
    @Query("Select * From UsersPosts")
    List<UsersPosts> getAllUsersPosts();
}
