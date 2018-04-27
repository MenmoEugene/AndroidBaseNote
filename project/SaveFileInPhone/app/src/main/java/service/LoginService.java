package service;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

public class LoginService{
    /***
     * 保存用户名密码的业务方法
     * @param username 用户名
     * @param password 密码
     * @return true 保存成功 false 保存失败
     */

    public static boolean saveUserInfo(String username, String password) {
        try {
            File file = new File("info.txt");
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
}
