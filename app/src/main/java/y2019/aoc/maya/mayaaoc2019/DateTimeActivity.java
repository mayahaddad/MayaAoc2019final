package y2019.aoc.maya.mayaaoc2019;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;


public class DateTimeActivity extends AppCompatActivity {
    Button ButtonCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        ButtonCalendar = findViewById(R.id.DateButton);
        ButtonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CALANDAR", year + " " + month + " " + day + " ");
                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeActivity.this, dateSetListener, year, month, day);
                if (datePickerDialog != null)
                    datePickerDialog.show();
            }
        }