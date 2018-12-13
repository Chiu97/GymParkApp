package com.example.a97rea.gymparkapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a97rea.gymparkapp.SQLiteTool.DbHelper;
import com.example.a97rea.gymparkapp.SQLiteTool.NewsTable;

import java.util.ArrayList;
import java.util.List;

public class newsDisplay extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<News> mList=new ArrayList<>();
    private String[] projection={
            NewsTable.NewsEntry.COLUMN_NAME_TITLE,
            NewsTable.NewsEntry.COLUMN_NAME_IMAGE
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQLiteDatabase db;
        DbHelper dbHelper=new DbHelper(this);
//        db=dbHelper.getWritableDatabase();
/*        dbHelper.onUpgrade(db,1,1);
//        for(News news:mList)
//          dbHelper.insertItem(db,news.title,news.imageID);
//
//        initNews();
*/

        db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query(NewsTable.NewsEntry.TABLE_NAME,projection,null,null,null,null,null);
        while(cursor.moveToNext()){
            News news;
            String title=cursor.getString(cursor.getColumnIndex(NewsTable.NewsEntry.COLUMN_NAME_TITLE));
            int imageID=cursor.getInt(cursor.getColumnIndex(NewsTable.NewsEntry.COLUMN_NAME_IMAGE));
            news=new News(title,imageID);
            mList.add(news);
        }
        setContentView(R.layout.activity_news_display);
        mRecyclerView=findViewById(R.id.my_recycler_view);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new MyAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
    }
    private void initNews(){
        News news1=new News("健身者必须注意的五个事项",R.drawable.pic02);
        mList.add(news1);
        News news2=new News("健身者该有的态度",R.drawable.pic03);
        mList.add(news2);
        News news3=new News("这几样食物会给你带来翻天覆地的变化",R.drawable.pic04);
        mList.add(news3);
        News news4=new News("哑铃还能这样玩？",R.drawable.pic05);
        mList.add(news4);
        News news5=new News("三十天魔鬼腹肌训练",R.drawable.pic06);
        mList.add(news5);
        News news6=new News("双人协作，速成魔鬼身材",R.drawable.pic07);
        mList.add(news6);
        News news7=new News("心灵与身体的合一：瑜伽之王",R.drawable.pic08);
        mList.add(news7);
    }
}
