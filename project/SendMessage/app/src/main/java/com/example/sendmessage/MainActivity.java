package com.example.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //声明控件
    private EditText numberText;
    private EditText contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //导入布局视图
        setContentView(R.layout.activity_main);
        //找到控件对应的ID并命名
        numberText = (EditText) findViewById(R.id.number);
        contentText = (EditText) findViewById(R.id.content);
        Button btn = (Button) findViewById(R.id.send);
        //給控件设置监听事件
        btn.setOnClickListener(new ButtonClickListener());
    }

    private final class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //通过控件名称获得对应的文本转成字符串，并命一个新的名称
            String number = numberText.getText().toString().trim();
            String content = contentText.getText().toString();
            if (TextUtils.isEmpty(number) || (TextUtils.isEmpty(content))) {
                Toast.makeText(MainActivity.this, "号码或内容不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            //获得一个短信管理器，调用它的getDefault方法 取得它的默认管理器对象
            SmsManager manager = SmsManager.getDefault();
            //按照短信限制字数拆分成多条短信
            ArrayList<String> texts = manager.divideMessage(content);
            for (String text : texts) {
                //调用发送短信方法
                //第一个参数用于得到短信号码，第二个参数用于设置发送设置，第三个用于获取短信内容
                // 第四个参数用于得到发送的状态，第五个参数可以得到对方是否收到这条短信
                manager.sendTextMessage(number, null, text, null, null);
            }
            Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
        }
    }
}
