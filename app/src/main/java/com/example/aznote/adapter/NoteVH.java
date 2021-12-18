package com.example.aznote.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aznote.R;

public class NoteVH extends RecyclerView.ViewHolder {


    AppCompatTextView lbl_title ,txt_title , txt_time , txt_date;
    AppCompatImageView img_delete , img_share;


    public NoteVH(@NonNull View itemView) {
        super(itemView);

        lbl_title = itemView.findViewById(R.id.lbl_title);
        txt_title = itemView.findViewById(R.id.txt_title);
        txt_time = itemView.findViewById(R.id.txt_time);
        txt_date = itemView.findViewById(R.id.txt_date);
        img_delete = itemView.findViewById(R.id.img_delete);
        img_share = itemView.findViewById(R.id.img_share);
    }
}
