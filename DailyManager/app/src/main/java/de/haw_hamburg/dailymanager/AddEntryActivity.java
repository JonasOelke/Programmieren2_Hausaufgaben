package de.haw_hamburg.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.Calendar;

public class AddEntryActivity extends AppCompatActivity {
    private Calendar selectedDate =  Calendar.getInstance();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        Spinner spinner = findViewById(R.id.spinner);
        String[] arraySpinner = new String[] {
                "keine", "15 min vorher", "30min vorher", "1h vorher", "morgens um 09:00", "1 Tag vorher"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        CalendarView calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(
            new CalendarView.OnDateChangeListener() {

                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    selectedDate.set(year,month,dayOfMonth);
                    Log.d("STATE", "Das Datum wurde gespeichert");
                }
            }
        );

        Button saveBtn = findViewById(R.id.saveButton);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO
                //editTextTime is ignored and only the day saved in selectedDate will be saved

                EditText editTextName = findViewById(R.id.editTextName);
                String name = editTextName.getText().toString();

                EditText editTextLocation = findViewById(R.id.editTextLocation);
                String location = editTextLocation.getText().toString();

                EditText editTextNote = findViewById(R.id.editTextNote);
                String note = editTextNote.getText().toString();

                Spinner spinnerReminder = findViewById(R.id.spinner);
                String reminder = spinnerReminder.getSelectedItem().toString();

                Event event = new Event(selectedDate, name, location, note, reminder);

                try {
                    WriteService.writeObject(getApplicationContext(), event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(AddEntryActivity.this, MainActivity.class);
                startActivity(intent);

                Log.i("STATE", event.toString());


            }
        });

    }
}