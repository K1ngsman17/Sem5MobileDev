package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class activity_splash extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openHomePage();
            }
        }, SPLASH_DELAY);
    }

    private void openHomePage() {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        finish(); // Close the SplashActivity after navigation
    }
}
