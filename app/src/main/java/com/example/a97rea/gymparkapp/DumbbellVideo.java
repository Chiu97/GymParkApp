package com.example.a97rea.gymparkapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class DumbbellVideo extends AppCompatActivity {
    VideoView videoView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dumbbell_video);
        url=getString(R.string.dumbbells);
        Uri uri=Uri.parse(url);
        videoView=findViewById(R.id.dumbbell_video);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
