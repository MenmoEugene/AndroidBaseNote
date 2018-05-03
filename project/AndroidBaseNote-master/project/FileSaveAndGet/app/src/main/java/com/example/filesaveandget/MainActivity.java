package com.example.filesaveandget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.service.FileService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.save);
        btn.setOnClickListener(new ButtonOnClickListener());
    }

    private final class ButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText filenameText = findViewById(R.id.file_name);
            EditText filecontentText = findViewById(R.id.file_content);
            String filename = filenameText.getText().toString();
            String content = filecontentText.getText().toString();
            FileService service = new FileService(getApplicationContext());
            try {
                service.save(filename, content);
                Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), R.string.failed, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
