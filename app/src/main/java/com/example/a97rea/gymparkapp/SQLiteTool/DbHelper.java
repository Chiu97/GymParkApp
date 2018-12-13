package com.example.a97rea.gymparkapp.SQLiteTool;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//link about this session: https://developer.android.com/training/data-storage/sqlite#java
public class DbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_NEWS=
            "CREATE TABLE "+NewsTable.NewsEntry.TABLE_NAME+"("+
                    NewsTable.NewsEntry._ID + " INTEGER PRIMARY KEY,"+
                    NewsTable.NewsEntry.COLUMN_NAME_TITLE + " TEXT,"+
                    NewsTable.NewsEntry.COLUMN_NAME_IMAGE + " INTEGER)";
    private static final String SQL_DELETE_NEWS=
            "DROP TABLE IF EXISTS "+NewsTable.NewsEntry.TABLE_NAME;
    private static final int VERSION=1;
    public static final String DATABASE_NAME="myDb";

    public DbHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NEWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_NEWS);
        onCreate(db);
    }
    public long insertItem(SQLiteDatabase db,String title,int imageID){
        ContentValues values=new ContentValues();
        values.put(NewsTable.NewsEntry.COLUMN_NAME_TITLE,title);
        values.put(NewsTable.NewsEntry.COLUMN_NAME_IMAGE,imageID);
        long newRowID=db.insert(NewsTable.NewsEntry.TABLE_NAME,null,values);
        return newRowID;
    }
}
