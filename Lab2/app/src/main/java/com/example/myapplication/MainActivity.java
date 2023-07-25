package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = findViewById(R.id.messageTextView);
        Button orientationButton = findViewById(R.id.orientationButton);

        orientationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeOrientation();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateMessage(newConfig.orientation);
    }

    @SuppressLint("WrongConstant")
    private void changeOrientation() {
        int currentOrientation = getResources().getConfiguration().orientation;
        int newOrientation = (currentOrientation == Configuration.ORIENTATION_PORTRAIT)
                ? Configuration.ORIENTATION_LANDSCAPE : Configuration.ORIENTATION_PORTRAIT;

        setRequestedOrientation(newOrientation);
        updateMessage(newOrientation);
    }

    @SuppressLint("SetTextI18n")
    private void updateMessage(int orientation) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            messageTextView.setText("Luka Modric is the best in Landscape.");
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            messageTextView.setText("Luka Modric is the best in Portrait");
        }
    }
}
