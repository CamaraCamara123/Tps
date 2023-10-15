package com.example.pizzaapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class SplashActivity extends Activity {

    private int sleepingTime=2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread loading=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SplashActivity.this.sleepingTime);
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        loading.start();

    }
}