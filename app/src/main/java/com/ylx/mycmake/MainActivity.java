package com.ylx.mycmake;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private SurfaceView mSurfaceView;
    private Button mOpenBtn;
    private YlxPlayer mYlxPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Example of a call to a native method
        mOpenBtn = findViewById(R.id.m_opeb_btn);
        mSurfaceView = findViewById(R.id.surfaceView);
        mYlxPlayer = new YlxPlayer();
        mYlxPlayer.setSurfaceView(mSurfaceView);

        mOpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open();
            }
        });
    }

    public void open() {
        File file = new File(Environment.getExternalStorageDirectory(), "avdemo.mp4");

        if(file.exists() && file.isFile()) {
            Log.i("========>>", "====>>>" + file.length());
        }

        mYlxPlayer.start(file.getAbsolutePath());
    }
}
