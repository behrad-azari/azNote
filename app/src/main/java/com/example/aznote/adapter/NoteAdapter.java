package com.example.aznote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aznote.R;
import com.example.aznote.database.NoteDBAdapter;
import com.example.aznote.models.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteVH> {

    Context context;
    List<Note> noteList;

    public NoteAdapter (Context context , List<Note> noteList){

        this.context = context;
        this.noteList = noteList;


    }


    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.note_row , null);




        return new NoteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {

        Note note = noteList.get(position);

        holder.txt_title.setText(note.getTitle());
        holder.txt_time.setText(note.getTimeCreate());
        holder.txt_date.setText(note.getDateCreate());

    }

    @Override
    public int getItemCount() {
        return noteList.size() ;
    }
}
