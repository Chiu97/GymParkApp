package com.example.a97rea.gymparkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);
        Button gotoNews=(Button) findViewById(R.id.NewsBtn);
        Button gotoTrainerList=(Button) findViewById(R.id.TrainerBtn);
        gotoNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoNewsReview=new Intent(mainContent.this,newsDisplay.class);
                startActivity(gotoNewsReview);
            }
        });
        gotoTrainerList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent gotoTrainerActivity=new Intent(mainContent.this,TrainerListActivity.class);
                startActivity(gotoTrainerActivity);
            }
        });
    }
}
