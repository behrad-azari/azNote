package com.example.aznote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    boolean singleBack  = false;


    FloatingActionButton floatingActionButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        floatingActionButton = findViewById(R.id.fab_main);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);



    }

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

                finishAffinity();


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

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                singleBack =false;
            }
        }, 2000);




        //super.onBackPressed();
    }








}