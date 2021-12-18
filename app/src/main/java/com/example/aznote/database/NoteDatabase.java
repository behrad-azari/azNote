package com.example.aznote.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteDatabase extends SQLiteOpenHelper {

    public final static String DB_NAME="note.db";
    public final static String TABLE_NOTE="tbl_note";
    public final static String KET_ID="id";
    public final static String KET_TITLE="title Text";
    public final static String KET_DESCRIPTION="description Text";
    public final static String KET_TIME="timeCreate Text";
    public final static String KET_DATE="dateCreate Text";
    final static  int VERSION=1;

    public NoteDatabase(@Nullable Context context ) {
        super(context, DB_NAME , null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //String query = "create table "+TABLE_NOTE+" ("+KET_ID+" Integer PRIMARY KEY AUTOINCREMENT  "+ KET_TITLE +"
              //  +KET_DESCRIPTION+" , "+KET_TIME+" , "+KET_DATE+" )";



       // db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
