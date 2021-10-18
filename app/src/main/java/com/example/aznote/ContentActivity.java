package com.example.aznote;




import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;

public class ContentActivity extends AppCompatActivity {


    AppCompatTextView bz_note_txt , bz_note ;
    AppCompatImageView img_email , img_facebook , img_twitter , img_linkein;
    CardView card_view;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        card_view = findViewById(R.id.card_view);

        bz_note_txt = findViewById(R.id.bz_note_txt);
        bz_note = findViewById(R.id.bz_note);

        img_email = findViewById(R.id.img_email);
        img_facebook = findViewById(R.id.img_facebook);
        img_twitter = findViewById(R.id.img_twitter);
        img_linkein = findViewById(R.id.img_linkein);





        img_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });


        img_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/behrad.tech/")));


            }
        });


        img_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/BehradazTech")));


            }
        });


        img_linkein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/behrad-azari-5058/")));


            }
        });













    }
}