package de.haw_hamburg.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Console;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,
                        AddEntryActivity.class);
                startActivity(intent);
            }
        });

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year,month,dayOfMonth);
                Log.d("STATE", "Das Datum wurde gespeichert");
            }
        });

        try {
            Event event;
            Object obj = ReadService.readObject(getApplicationContext());
            if (obj == null) throw new InvalidClassException("The object has to be an instance of Event");
            else {
                event = (Event) obj;
            }
            Log.i("", Long.toString(event.getTime().getTimeInMillis()));
            calendarView.setDate(event.getTime().getTimeInMillis());

            Log.i("STATE", "HIER!!! ES HAT GEKLAPPT!!!!" + event.toString());
        } catch (IOException e) {
            Log.d("STATE", "Es ist ein Fehler aufgetreten");
        } catch (ClassNotFoundException e) {
            Log.d("STATE", "Es ist ein Fehler aufgetreten");
        }


    }
}