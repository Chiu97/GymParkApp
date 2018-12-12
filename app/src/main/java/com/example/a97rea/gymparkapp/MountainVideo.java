package com.example.a97rea.gymparkapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MountainVideo extends AppCompatActivity {
    VideoView videoView;
    String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_mountain);
        url=getString(R.string.mountaindog);
        Uri uri=Uri.parse(url);
        videoView=findViewById(R.id.mountain_video);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
