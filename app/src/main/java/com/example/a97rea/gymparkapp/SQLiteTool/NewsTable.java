package com.example.a97rea.gymparkapp.SQLiteTool;

import android.provider.BaseColumns;

public final class  NewsTable {
    private NewsTable(){}

    public static class NewsEntry implements BaseColumns{
        public static final String TABLE_NAME="news";
        public static final String COLUMN_NAME_TITLE="title";
        public static final String COLUMN_NAME_IMAGE="imageID";
    }

}
