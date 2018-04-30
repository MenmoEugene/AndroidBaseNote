package com.example.sharedpreference.service;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Administrator on 2018/4/27 0027.
 */

public class LoginService {
    /**
     * 保存用户名 密码的业务方法
     *
     * @param context  上下文
     * @param username 用户名
     * @param password 密码
     */

    public static void saveUserInfo(Context context, String username, String password) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        //得到一个sp的编辑器
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        //类似于数据库的事务，保证数据同时提交成功

        editor.putBoolean("open", true);
        editor.putInt("count", 23);
        editor.putFloat("pi", 3.141592653383679f);
        editor.apply();
    }
}
