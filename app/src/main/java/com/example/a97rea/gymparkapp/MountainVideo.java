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
        url="http://v.hoopchina.com.cn/w/20181214/82c5a538316245334cf488de1a93b1f49b70f1c4919a19db03bff00ce04dbcaf.mp4?auth_key=1544862982-0-0-18c9e883e2fd870c8e163c9ca7c825bd";
        Uri uri=Uri.parse(url);
        videoView=findViewById(R.id.mountain_video);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
