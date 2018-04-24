package com.example.musicplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {

    private EditText nameText;
    private String path;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText= (EditText) findViewById(R.id.filename);
    }
    public void mediaplay(View v){
        switch (v.getId()){
            case R.id.paly:
                String filename = nameText.getText().toString();
                File audio = new File(Environment.getExternalStorageDirectory(),filename);
                if (audio.exists()) {
                    path = audio.getAbsolutePath();
                    play();
                }else{
                    path = null;
                    Toast.makeText(getApplicationContext(), "file no exist", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pause:
                break;
            case R.id.stop:
                break;
            case R.id.repaly:
                break;
            default:
                break;
        }

    }

    private void play() {
    }
}
