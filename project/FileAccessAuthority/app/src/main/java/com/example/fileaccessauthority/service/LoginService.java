package com.example.fileaccessauthority.service;

import android.content.Context;

import java.io.FileOutputStream;

/**
 * @author Administrator
 */
public class LoginService {
    /***
     * 保存用户名密码的业务方法
     * @param username 用户名
     * @param password 密码
     * @return true 保存成功 false 保存失败
     * @param mode 1私有 2追加
     */

    public static boolean saveUserInfo(Context context, String username, String password, int mode) {
        try {
            FileOutputStream fos = null;
            switch (mode) {
                case 1:
                    fos = context.openFileOutput("private.txt", Context.MODE_PRIVATE);
                    break;
                case 2:
                    fos = context.openFileOutput("private.txt", Context.MODE_APPEND);
                    break;
                default:
                    break;
            }
            //username---password
            assert fos != null;
            fos.write((username + "---" + password + "\r\n").getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
