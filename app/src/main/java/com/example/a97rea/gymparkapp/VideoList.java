package com.example.a97rea.gymparkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.RelativeLayout;

public class VideoList extends AppCompatActivity {
    RelativeLayout mountain;
    RelativeLayout back;
    RelativeLayout dumbbell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        mountain=(RelativeLayout)findViewById(R.id.mountain_video_part);
        back=(RelativeLayout)findViewById(R.id.back_video_part);
        dumbbell=(RelativeLayout)findViewById(R.id.dumbbell_video_part);
        mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VideoList.this,MountainVideo.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VideoList.this,BackVideo.class);
                startActivity(intent);
            }
        });
        dumbbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VideoList.this,DumbbellVideo.class);
                startActivity(intent);
            }
        });
    }
}
