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
     */

    public static boolean saveUserInfo(Context context, String username, String password) {
        try {
//            File file = new File("/data/data/com.example.savefileinphone/info.txt");
//            context.getFilesDir();//帮助我们返回一个目录 /data/data/包名/files/
            File file = new File(context.getCacheDir(), "info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            //username---password
            fos.write((username + "---" + password).getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取保存的数据
     *
     * @param context
     * @return
     */
    public static Map<String, String> getSaveUserInfo(Context context) {
        File file = new File(context.getCacheDir(), "info.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            //定义一个缓冲区BuffereReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            //按照存储的格式：xxxxx---xxxx
            String[] infos = str.split("---");
            Map<String, String> map = new HashMap<String, String>();
            map.put("username", infos[0]);
            map.put("password", infos[1]);
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
