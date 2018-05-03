package com.example.fileaccessauthority.service;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

public class LoginService {
    /***
     * 保存用户名密码的业务方法
     * @param username 用户名
     * @param password 密码
     * @return true 保存成功 false 保存失败
     * @getCacheDir() 缓存目录
     * @param mode 1私有 2追加
     */

    public static boolean saveUserInfo(Context context, String username, String password, int mode) {
        try {
            FileOutputStream fos = null;
            switch (mode) {
                case 1:
                    fos = context.openFileOutput("private.txt", Context.MODE_PRIVATE);
                case 2:
                    fos = context.openFileOutput("private.txt", Context.MODE_APPEND);
                default:
                    break;
            }
            //username---password
            fos.write((username + "---" + password + "\r\n").getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
