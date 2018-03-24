package com.example.abhishek.youtubeapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "AIzaSyAQRN9qalqw86alca3D24iXmFJFFE8YCxw";
    // YouTube Listener
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;

    //Declare View
    private YouTubePlayerSupportFragment mFragment;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player);

        mButton = findViewById(R.id.button_play_video);

        initPlayer();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment.initialize(API_KEY, mOnInitializedListener);
            }
        });
    }

    private void initPlayer() {
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("SUgI9TQ7JKA");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this, "Couldn't load video", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
