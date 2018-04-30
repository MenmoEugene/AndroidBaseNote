package com.example.shujuku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/4/29 0029.
 */

public class PersonSQLiteOpenHelper extends SQLiteOpenHelper {

    /**
     * 数据库的构造方法 用来定义数据库的名称 数据库查询的结果即数据库的版本
     *
     * @param context
     */
    public PersonSQLiteOpenHelper(Context context) {
        super(context, "person.db", null, 0);
    }

    /**
     * 数据库第一次被创建的时候调用的方法
     *
     * @param db 被创建的数据库
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //初始化数据库的表结构
        db.execSQL("create table person (id integer primary key autoincrement,name varchar(20),number varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
