package com.example.upusers.database.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "UsersPosts",
        foreignKeys = {@ForeignKey(entity =
        Posts.class,
        parentColumns = "Post_id",
        childColumns = "Post"),
        @ForeignKey(entity =
        User.class,
        parentColumns = "User_id",
        childColumns = "User")},
        indices = {@Index(value = {"Post"}), @Index(value = {"User"})})
public class UsersPosts {
    @PrimaryKey (autoGenerate = true)
    public long id;
    @ColumnInfo(name = "User")
    public int User;
    @ColumnInfo(name = "Post")
    public int Post;
    public UsersPosts(){}
}
