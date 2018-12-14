package com.example.a97rea.gymparkapp.SQLiteTool;

import android.provider.BaseColumns;

import com.example.a97rea.gymparkapp.Trainer;

public final class TrainerTable {
    private TrainerTable(){}

    public class TrainerEntry implements BaseColumns{
        public static final String TABLE_NAME="trainer";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_PHONE="phone";
        public static final String COLUMN_EMAIL="email";
        public static final String COLUMN_PIC="picture";
    }
}
