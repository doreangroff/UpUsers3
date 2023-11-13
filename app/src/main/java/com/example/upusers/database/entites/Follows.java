package com.example.upusers.database.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Follows",
        foreignKeys = {@ForeignKey(entity =
                User.class,
                parentColumns = "User_id",
                childColumns = "Following_user"),
                @ForeignKey(entity =
                        User.class,
                        parentColumns = "User_id",
                        childColumns = "Followed_user")},
        indices = {@Index(value = {"Following_user"}), @Index(value = {"Followed_user"})})
public class Follows {
    @PrimaryKey (autoGenerate = true)
    public long Follow_id;
    @ColumnInfo(name = "Following_user")
    public int Following_user;
    @ColumnInfo(name = "Followed_user")
    public int Followed_user;
    public Follows(){}
}
