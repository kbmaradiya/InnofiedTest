//package com.example.myapplication.database;
//
///*
// * Created by: Bharat S
// * Created on: 10-04-2019
// * Modified by: Your Name
// * Modified on: Modified Date
// */
//
//import android.app.Application;
//import android.arch.persistence.room.Room;
//
//public class DatabaseClient {
//
//    private static DatabaseClient mInstance;
//    private Application application;
//    //our app database object
//    private AppDatabase appDatabase;
//
//    private DatabaseClient(Application application) {
//        this.application = application;
//
//        //creating the app database with Room database builder
//        //MyToDos is the name of the database
//        appDatabase = Room.databaseBuilder(application, AppDatabase.class, "atzcartdb").build();
//    }
//
//    public static synchronized DatabaseClient getInstance(Application application) {
//        if (mInstance == null) {
//            mInstance = new DatabaseClient(application);
//        }
//        return mInstance;
//    }
//
//    public AppDatabase getAppDatabase() {
//        return appDatabase;
//    }
//}