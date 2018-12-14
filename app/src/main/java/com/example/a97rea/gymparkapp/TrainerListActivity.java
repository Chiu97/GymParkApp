package com.example.a97rea.gymparkapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a97rea.gymparkapp.SQLiteTool.TrainerHelper;
import com.example.a97rea.gymparkapp.SQLiteTool.TrainerTable;

import java.util.ArrayList;
import java.util.List;

public class TrainerListActivity extends Activity {
    RecyclerView recyclerView;
    TrainerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Trainer> list;
    private final String[] projection={
            TrainerTable.TrainerEntry.COLUMN_NAME,
            TrainerTable.TrainerEntry.COLUMN_PHONE,
            TrainerTable.TrainerEntry.COLUMN_EMAIL,
            TrainerTable.TrainerEntry.COLUMN_PIC
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
//        this.initTrainerList();
        SQLiteDatabase db;
        TrainerHelper helper=new TrainerHelper(this);
//        db=helper.getWritableDatabase();
//        for(Trainer trainer:list)
//            helper.insertItem(db,trainer.getName(),trainer.getPhoneNumber(),trainer.getEmail(),trainer.getTrainerPic());
        db=helper.getReadableDatabase();
        Cursor cursor=db.query(TrainerTable.TrainerEntry.TABLE_NAME,projection,null,null,null,null,null);
        while(cursor.moveToNext()){
            String name,phone,email;
            int pic;
            name=cursor.getString(cursor.getColumnIndex(TrainerTable.TrainerEntry.COLUMN_NAME));
            phone=cursor.getString(cursor.getColumnIndex(TrainerTable.TrainerEntry.COLUMN_PHONE));
            email=cursor.getString(cursor.getColumnIndex(TrainerTable.TrainerEntry.COLUMN_EMAIL));
            pic=cursor.getInt(cursor.getColumnIndex(TrainerTable.TrainerEntry.COLUMN_PIC));
            Trainer trainer=new Trainer(name,phone,email,pic);
            list.add(trainer);
        }
        setContentView(R.layout.activity_trainer_list);
        recyclerView=findViewById(R.id.trainer_list_view);
        layoutManager=new LinearLayoutManager(this);
        adapter=new TrainerAdapter(list,this);
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
