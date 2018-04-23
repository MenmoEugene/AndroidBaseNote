package com.menmo.demo.telephone;

import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

//    int i=0; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //给这个Activity设置一个指定的view，这个view就是activity_main。
        setContentView(R.layout.activity_main);
        //通过findViewById的方法找到id名为bin_call的控件，因为findViewById 返回的是一个View对象，
        // 而需要用到的是一个Button控件，由于Button继承的文本控件TextView，TextView又继承View，
        //所以可以强转
        Button btn =(Button)findViewById(R.id.btn_call);
        //给名为btn的Button控件设置点击事件监听器
        btn.setOnClickListener(new MyButtonOnClickListener());
    }
    //创建一个实现了View.OnClickListener的类对象
    class MyButtonOnClickListener implements View.OnClickListener{
        //重写View.OnClickListener接口实现的方法是onClick
        @Override
        public void onClick(View v) {
            //通过findViewById的方法找到id名为et_phone的编辑文本控件，因为findViewById 返回的是一个
            //View对象，而需要用到的是一个编辑文本控件，由于继承的文本控件TextView，而它又继承View，
            //所以可以强转
            EditText number = (EditText) findViewById(R.id.et_phone);
            //获得名为number的编辑文本控件的文本并转成字符串，同时赋给名为str 的字符串对象
            String str = number.getText().toString();
            //创建一个意图同时赋给名为intent的Intent对象
            Intent intent = new Intent();
            //给名为intent的意图设置一个动作，这个动作为Intent.ACTION_CALL
            intent.setAction(Intent.ACTION_CALL);
            //给名为intent的意图设置一个数据，数据必须是一个URI类型，通过这个String字符串转成Uri获得
            intent.setData(Uri.parse("tel:"+str));
            //开启名为intent的活动
            startActivity(intent);
        }
    }
}
