package com.example.aznote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.aznote.models.Note;

public class NoteDBAdapter extends NoteDatabase {

    public final static String KEY_ID="id";
    public final static String KEY_TITLE="title";
    public final static String KEY_DESCRIPTION="description";
    public final static String KEY_TIME="timeCreate";
    public final static String KEY_DATE="dateCreate";


    public NoteDBAdapter(@Nullable Context context) {
        super(context);
    }


    public long insertNote(Note note) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_TITLE , note.getTitle());
        contentValues.put(KEY_DESCRIPTION , note.getDescription());
        contentValues.put(KEY_TIME , note.getTimeCreate());
        contentValues.put(KEY_DATE , note.getDateCreate());

         return db.insert(NoteDatabase.TABLE_NOTE , null , contentValues);



    }



}
