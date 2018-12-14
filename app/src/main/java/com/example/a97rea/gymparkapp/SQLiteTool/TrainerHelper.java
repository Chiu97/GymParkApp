package com.example.a97rea.gymparkapp.SQLiteTool;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TrainerHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="trainer";
    private static int VERSION=1;
    private static final String SQL_CREATE_TRAINER=
            "CREATE TABLE "+TrainerTable.TrainerEntry.TABLE_NAME+"("+
                    TrainerTable.TrainerEntry.COLUMN_NAME+" TEXT,"+
                    TrainerTable.TrainerEntry.COLUMN_PHONE+" TEXT,"+
                    TrainerTable.TrainerEntry.COLUMN_EMAIL+" TEXT,"+
                    TrainerTable.TrainerEntry.COLUMN_PIC+" INTEGER)";
    private static final String SQL_DELETE_TRAINER=
            "DROP TABLE IF EXISTS "+TrainerTable.TrainerEntry.TABLE_NAME;


    public TrainerHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TRAINER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TRAINER);
        onCreate(db);
    }
    public long insertItem(SQLiteDatabase db,String name,String phone,String email,int imageID){
        ContentValues contentValues=new ContentValues();
        contentValues.put(TrainerTable.TrainerEntry.COLUMN_NAME,name);
        contentValues.put(TrainerTable.TrainerEntry.COLUMN_PHONE,phone);
        contentValues.put(TrainerTable.TrainerEntry.COLUMN_EMAIL,email);
        contentValues.put(TrainerTable.TrainerEntry.COLUMN_PIC,imageID);
        long rowID=db.insert(TrainerTable.TrainerEntry.TABLE_NAME,null,contentValues);
        return rowID;
    }
}
