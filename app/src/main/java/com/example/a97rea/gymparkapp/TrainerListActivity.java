package com.example.a97rea.gymparkapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrainerListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TrainerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Trainer> list=new ArrayList<>();
    //here we initialize four private trainer for use


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initTrainerList();
        setContentView(R.layout.activity_trainer_list);
        recyclerView=findViewById(R.id.trainer_list_view);
        layoutManager=new LinearLayoutManager(this);
        adapter=new TrainerAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void initTrainerList(){
        Trainer trainer1=new Trainer("Shark","10001","Shark@me.com",R.drawable.shark);
        Trainer trainer2=new Trainer("Shawn","10003289","Shawn@me.com",R.drawable.shawn);
        Trainer trainer3=new Trainer("Lil","12839798","Hill@me.com",R.drawable.lil);
        Trainer trainer4=new Trainer("Ball","123897","Kanye@me.com",R.drawable.ball);
        list.add(trainer1);
        list.add(trainer2);
        list.add(trainer3);
        list.add(trainer4);
    }
}
