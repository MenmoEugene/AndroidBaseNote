package com.example.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreference.service.LoginService;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private EditText et_username;
    private EditText et_password;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = (EditText) findViewById(R.id.user_name);
        et_password = (EditText) findViewById(R.id.password);
        cb = (CheckBox) findViewById(R.id.chenckbox);

        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        String username = sp.getString("username", "");
        et_username.setText(username);
        String password = sp.getString("password", "");
        et_password.setText(password);
    }

    public void Btnlogin(View v) {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            //判断是否保存密码
            if (cb.isChecked()) {
                //保存用户名密码
                Log.i(TAG, "需要保存用户名和密码.");
                LoginService.saveUserInfo(this, username, password);
                Toast.makeText(MainActivity.this, "保存用户信息成功", Toast.LENGTH_SHORT).show();

            }
            //登陆发送消息到服务器，服务器验证是否正确
            if ("xumanli".equals(username) && "1026".equals(password)) {
                Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        }

    }
}