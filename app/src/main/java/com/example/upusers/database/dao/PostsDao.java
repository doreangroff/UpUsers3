package com.example.upusers.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.upusers.database.entites.Posts;

import java.util.List;
@Dao
public interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Posts post);
    @Update
    void update(Posts post);
    @Delete
    void delete(Posts post);
    @Query("Select * From Posts")
    List<Posts> getAllPosts();
}
