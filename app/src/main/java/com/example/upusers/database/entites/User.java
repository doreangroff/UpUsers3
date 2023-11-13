package com.example.upusers.database.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users",
        foreignKeys = {@ForeignKey(entity =
        Gender.class,
        parentColumns = "Gender_id",
        childColumns = "Gender")},
        indices = {@Index(value = "Gender")})
public class User {
    @PrimaryKey(autoGenerate = true)
    public long User_id;
    @ColumnInfo (name = "Username")
    public String Username;
    @ColumnInfo (name = "Age")
    public int Age;
    @ColumnInfo (name = "Gender")
    public int Gender;
    @ColumnInfo (name = "Birthday")
    public String Birthday;
    @ColumnInfo (name = "Phone_number")
    public String Phone_number;
    public User(){}
}
