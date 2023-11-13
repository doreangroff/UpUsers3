package com.example.upusers.database.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Genders")

public class Gender {
    @PrimaryKey (autoGenerate = true)
    public long Gender_id;
    @ColumnInfo(name = "Gender_name")
    public String Gender_name;
    public Gender() {}
}
