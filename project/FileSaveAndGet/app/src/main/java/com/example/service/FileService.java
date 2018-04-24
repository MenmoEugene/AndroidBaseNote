package com.example.service;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2018/4/24 0024.
 */

public class FileService {
    private Context context;

    public FileService(Context context) {
        this.context = context;
    }

    /**
     * 保存文件
     *
     * @param filename 文件名称
     * @param content  文件内容
     */

    public void save(String filename, String content) throws Exception {
        //私有操作模式：创建出来的文件只能被本应用访问，其它应用无法访问该文件，另外曹勇Sioux操作模式创建的文件，写入的内容会覆盖原文件的内容
        FileOutputStream outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
        //保存文件应该调用输出流的 write()方法
        outputStream.write(content.getBytes());
        outputStream.close();
    }
    /**
     * 读取文件内容
     *
     * @param filename 文件名称
     * @return 文件内容
     * @throws Exception
     */
    public String read(String filename) throws Exception {
        FileInputStream inputStream = context.openFileInput(filename);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //定义一个宿主
        byte[] buffer = new byte[1024];
        //定义一个变量存储已经读取的信息
        int len = 0;
        //调用inputStream 方法从输入流中把数据读到宿主中
        while ((inputStream.read(buffer)) != -1) {
            //把宿主中的数据写到内存中
            outputStream.write(buffer, 0, len);
        }
        byte[] data = outputStream.toByteArray();
        return new String(data);
    }
}
