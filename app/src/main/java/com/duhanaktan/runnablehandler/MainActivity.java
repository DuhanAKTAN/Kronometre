package com.duhanaktan.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Runnable runnable;
    Handler handler;
    int number;
    Button startButton;
    Button stopBut;
    Button resetBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        startButton=findViewById(R.id.startBut);
        stopBut=findViewById(R.id.stopBut);
        resetBut=findViewById(R.id.resetBut);
        resetBut.setEnabled(false);
        stopBut.setEnabled(false);
        number=0;
    }

    public void start(View viev){
        startButton.setEnabled(false);
        resetBut.setEnabled(false);
        stopBut.setEnabled(true);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                number++;
                textView.setText("Time: "+number);
                handler.postDelayed(runnable,1000);
            }
        };

        handler.post(runnable);

    }

    public void stop(View view){
        startButton.setEnabled(true);
        resetBut.setEnabled(true);
        stopBut.setEnabled(false);
        handler.removeCallbacks(runnable);

        textView.setText("Time: "+number);

    }
    public void reset(View view) {
        number = 0;
        startButton.setEnabled(true);
        resetBut.setEnabled(false);
        stopBut.setEnabled(false);
        handler.removeCallbacks(runnable);
        textView.setText("Time: "+number);
    }

}