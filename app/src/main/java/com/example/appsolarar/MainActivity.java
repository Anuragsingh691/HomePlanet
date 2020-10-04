package com.example.appsolarar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.hanks.htextview.base.HTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private HTextView textView;
    int delay=1000;
    Handler handler;
    int pos=0;
    private static  int SPLASH_SCREEN=4100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.typer);
        handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,delay);
                if (pos==0)
                {
                    textView.animateText("Let us take you to the journey of the COSMOS...");
                    pos++;
                }

            }
        },delay);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent splash = new Intent(MainActivity.this, Sp2.class);
                    startActivity(splash);
                    finish();

            }
        },SPLASH_SCREEN);
    }
}