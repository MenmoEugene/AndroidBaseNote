package com.example.shujuku.com.example.db.test;

import android.test.AndroidTestCase;

import com.example.shujuku.PersonSQLiteOpenHelper;

/**
 * Created by Administrator on 2018/4/29 0029.
 */

public class TestPersonDB extends AndroidTestCase {
    public void testCreateDB() throws Exception {
        PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
        helper.getWritableDatabase();
    }
}
