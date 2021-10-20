package com.example.aznote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    AppCompatTextView bz_note_txt , version_txt , click_on_txt , developed_behrad_txt;
    AppCompatImageView img_note , img_back;
    CardView card_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        bz_note_txt = findViewById(R.id.bz_note_txt);
        version_txt = findViewById(R.id.version_txt);
        click_on_txt = findViewById(R.id.click_on_txt);
        developed_behrad_txt = findViewById(R.id.developed_behrad_txt);

        img_note = findViewById(R.id.img_note);
        img_back = findViewById(R.id.img_back);
        card_view = findViewById(R.id.card_view);





        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ContentActivity.class);
                startActivity(intent);



            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






    }
}