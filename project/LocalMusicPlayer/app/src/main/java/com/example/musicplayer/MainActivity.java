package com.example.musicplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {

    private EditText nameText;
    private String path;
    private MediaPlayer mediaPlayer;
    private boolean pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        nameText = (EditText) findViewById(R.id.filename);
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        mediaPlayer = null;
        super.onDestroy();
    }

    public void mediaplay(View v) {
        switch (v.getId()) {
            case R.id.paly:
                String filename = nameText.getText().toString();
                File audio = new File(Environment.getExternalStorageDirectory(), filename);
                if (audio.exists()) {
                    path = audio.getPath();
                    play();
                } else {
                    path = null;
                    Toast.makeText(getApplicationContext(), "file no exist", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();//暂停音乐
                    pause = true;
                    ((Button) v).setText("继续播放");
                } else {
                    if (pause) {
                        mediaPlayer.start();//继续播放音乐
                        ((Button) v).setText("暂停");
                    }
                }
                break;
            case R.id.stop:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                break;
            case R.id.repaly:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);//重新播放音乐
                } else {
                    if (path != null) {
                        play();
                    }
                }
                break;
            default:
                break;
        }

    }

    private void play() {
        try {
            mediaPlayer.reset();//把各项参数恢复到初始状态
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();//进行数据缓冲
            mediaPlayer.setOnPreparedListener(new PrepareListener());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final class PrepareListener implements MediaPlayer.OnPreparedListener {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mediaPlayer.start();//开始播放
        }
    }

}
