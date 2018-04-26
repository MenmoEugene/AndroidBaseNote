package com.menmo.demo.telephone;

import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //给这个Activity设置布局
        setContentView(R.layout.activity_main);
        //查找button控件并赋名
        Button btn = (Button) findViewById(R.id.btn_call);
        //给名为btn的Button控件设置点击事件监听器
        final EditText number = (EditText) findViewById(R.id.et_phone);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            //重写View.OnClickListener接口实现的方法是onClick
            public void onClick(View v) {
                //获得名为number的编辑文本控件的文本并转成字符串，同时赋给名为str 的字符串对象
                String str = number.getText().toString().trim();
                //创建一个意图同时赋给名为intent的Intent对象
                if (TextUtils.isEmpty(str)) {
                    Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                //给名为intent的意图设置一个动作，这个动作为Intent.ACTION_CALL
                intent.setAction(Intent.ACTION_CALL);
                //给名为intent的意图设置一个数据，数据必须是一个URI类型，通过这个String字符串转成Uri获得
                intent.setData(Uri.parse("tel:" + str));
                //开启名为intent的活动
                startActivity(intent);
            }
        });
    }

}
