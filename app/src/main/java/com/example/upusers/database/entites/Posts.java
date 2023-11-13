package com.example.upusers.database.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Posts")
public class Posts {
    @PrimaryKey (autoGenerate = true)
    public long Post_id;
    @ColumnInfo(name = "Title")
    public String Title;
    @ColumnInfo(name = "Post_text")
    public String Post_text;
    @ColumnInfo(name = "Creation_time")
    public String Creation_time;
    public Posts(){}
}
