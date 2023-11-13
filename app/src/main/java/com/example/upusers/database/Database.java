package com.example.upusers.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.upusers.database.dao.FollowsDao;
import com.example.upusers.database.dao.GenderDao;
import com.example.upusers.database.dao.PostsDao;
import com.example.upusers.database.dao.UserDao;
import com.example.upusers.database.dao.UsersPostsDao;
import com.example.upusers.database.entites.Follows;
import com.example.upusers.database.entites.Gender;
import com.example.upusers.database.entites.Posts;
import com.example.upusers.database.entites.User;
import com.example.upusers.database.entites.UsersPosts;

@androidx.room.Database(entities = {Gender.class, User.class, Posts.class, UsersPosts.class, Follows.class}, version = 3)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract GenderDao genderDao();
    public abstract PostsDao postsDao();
    public abstract UsersPostsDao usersPostsDao();
    public abstract FollowsDao followsDao();
    public static volatile Database INSTANCE;
    public static Database getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Database.class,
                            "test_database").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
