package y2019.aoc.maya.mayaaoc2019;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Calendar;


public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton DateButton;
    ImageButton TimeButton;
    ImageButton Time2Button;
    Button addShiftButton;
    TextView TimeText;
    TextView DateText;
    TextView Time2Text;

    int day;
    int month;
    int year1;
    long startingHour = 0, endingHour=0;
    double totalWage=0;

    //gets the currently logged in user
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users/"+user.getUid()+"/Shifts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        addShiftButton=findViewById(R.id.addShiftButton);
        DateButton=findViewById(R.id.DateButton);
        TimeButton=findViewById(R.id.TimeButton);
        Time2Button=findViewById(R.id.Time2Button);
        DateText=findViewById(R.id.DateText);
        TimeText=findViewById(R.id.TimeText);

        Time2Text=findViewById(R.id.Time2Text);


        DateButton.setOnClickListener( this);
        TimeButton.setOnClickListener( this);
        Time2Button.setOnClickListener( this);
        addShiftButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        if (v == DateButton) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            final int mYear = c.get(Calendar.YEAR);
            final int mMonth = c.get(Calendar.MONTH);
            final int mDay = c.get(Calendar.DAY_OF_MONTH);


            final DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            day = dayOfMonth;
                            month = monthOfYear;
                            year1 = year;
                            DateText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == TimeButton) {
            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(DateTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                    startingHour = selectedHour;
                    TimeText.setText( selectedHour + ":" + selectedMinute);
                }
            }, hour, minute, true);//Yes 24 hour time
            mTimePicker.setTitle("Select Time");
            mTimePicker.show();
        }
        if (v == Time2Button) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            endingHour = hourOfDay;
                            Time2Text.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if(v == addShiftButton){

                myRef.push().setValue(new Shifts(day, month, year1, startingHour, endingHour, totalWage));
             Intent i=new Intent( this,MyShiftsActivity.class);
            startActivity(i);
        }
    }
}
 /* // Get Current Time
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            TimeText.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();*/