package com.example.aznote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import com.example.aznote.database.NoteDBAdapter;
import com.example.aznote.models.Note;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    AppCompatImageView img_back;
    AppCompatButton btn_date , btn_time , btn_save;
    AppCompatEditText  edt_description , edt_title;
    TextInputLayout edt_textinput , edt_textinput2;


    NoteDBAdapter noteDBAdapter;

    String  date = "";
    String  time = "";

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        img_back = findViewById(R.id.img_back);
        btn_date = findViewById(R.id.btn_date);
        btn_time = findViewById(R.id.btn_time);
        btn_save = findViewById(R.id.btn_save);
        edt_title = findViewById(R.id.edt_title);
        edt_description = findViewById(R.id.edt_description);
        edt_textinput2 = findViewById(R.id.edt_textinput2);
        edt_textinput = findViewById(R.id.edt_textinput);
        noteDBAdapter = new NoteDBAdapter(getApplicationContext());

         calendar = Calendar.getInstance();



        img_back.setOnClickListener(v -> finish());


        btn_date.setOnClickListener(v -> {

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        date = year1 +"/"+ month1 +"/"+dayOfMonth;
                        btn_date.setText(date);
                    }, year  , month , day );
            datePickerDialog.show();

        });

        btn_time.setOnClickListener(v -> {

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog = new TimePickerDialog(AddActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    time = hourOfDay+ ":" + minute;
                    btn_time.setText(time);

                }
            } , hour , minute , true );
            timePickerDialog.show();

        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Note note = new Note();
                note.setTitle(edt_title.getText().toString());
                note.setDescription(edt_description.getText().toString());
                note.setTimeCreate(time);
                note.setDateCreate(date);

             long result =  noteDBAdapter.insertNote(note);

             if(result>0){

                    Snackbar.make( v , R.string.added_nte ,Snackbar.LENGTH_SHORT).show();

             }else {

                 Snackbar.make( v , R.string.empty_note ,Snackbar.LENGTH_LONG).show();

             }



            }
        });




    }
}