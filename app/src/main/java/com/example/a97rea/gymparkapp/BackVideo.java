package com.example.a97rea.gymparkapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class BackVideo extends AppCompatActivity {
    VideoView videoView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_video);
        url=getString(R.string.back_importance);
        Uri uri=Uri.parse(url);
        videoView=findViewById(R.id.back_video);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
