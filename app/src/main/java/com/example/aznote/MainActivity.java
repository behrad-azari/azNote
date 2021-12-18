package com.example.aznote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.aznote.database.NoteDBAdapter;
import com.example.aznote.database.NoteDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    boolean singleBack  = false;


    FloatingActionButton fab_main;
    Toolbar toolbar;
    NoteDatabase noteDatabase;
    ListView lst_note;

    NoteDBAdapter noteDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fab_main = findViewById(R.id.fab_main);
        toolbar = findViewById(R.id.toolbar);
        lst_note = findViewById(R.id.lst_note);


        noteDatabase = new NoteDatabase(getApplicationContext());

        noteDBAdapter = new NoteDBAdapter(getApplicationContext());

        setSupportActionBar(toolbar);


        fab_main.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(),AddActivity.class);
            startActivity(intent);
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        List<String> names =  noteDBAdapter.getTitles();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext() , android.R.layout.simple_list_item_1);

        lst_note.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);



    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_about_app:


                Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intent);



                break;
            case R.id.item_rate_app:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafebazaar.ir/app/com.example.hightechnology.mynote")));


                break;

            case R.id.item_exit:




                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle(R.string.exit);
                alert.setMessage(R.string.exit_message);
                alert.setIcon(R.drawable.ic_baseline_delete_24);

                alert.setPositiveButton("Yes", (dialog, which) -> finishAffinity());

                alert.setNegativeButton("No", (dialog, which) -> {

                });


                alert.show();




                break;





        }



        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {

        if (singleBack ) {
            super.onBackPressed();
            return;
        }

        this.singleBack  = true;
        Toast.makeText(this, "Double Back to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(() -> singleBack =false, 2000);




        //super.onBackPressed();
    }




}