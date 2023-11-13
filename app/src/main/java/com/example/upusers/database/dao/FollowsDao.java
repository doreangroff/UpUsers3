package com.example.upusers.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.upusers.database.entites.Follows;

import java.util.List;
@Dao
public interface FollowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Follows follow);
    @Update
    void update(Follows follow);
    @Delete
    void delete(Follows follow);
    @Query("Select * From Follows")
    List<Follows> getAllFollows();
}
