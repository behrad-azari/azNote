package com.example.aznote.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteDatabase extends SQLiteOpenHelper {

    public final static String DB_NAME="note.db";
    public final static String TABLE_NOTE="tbl_note";
    final static  int VERSION=1;

    public NoteDatabase(@Nullable Context context ) {
        super(context, DB_NAME , null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table "+TABLE_NOTE+" (id Integer PRIMARY KEY AUTOINCREMENT , title Text," +
                "description Text , timeCreate Text , dateCreate Text )";



        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
