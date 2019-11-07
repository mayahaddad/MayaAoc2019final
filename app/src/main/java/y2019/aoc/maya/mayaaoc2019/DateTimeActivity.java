package y2019.aoc.maya.mayaaoc2019;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.media.Image;
import android.media.TimedText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.Button;import android.widget.Toast;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static y2019.aoc.maya.mayaaoc2019.R.id.DateButton;


public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton DateButton;
    ImageButton TimeButton;
    ImageButton Time2Button;
    TextView TimeText;
    TextView DateText;
    TextView Time2Text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

       DateButton=findViewById(R.id.DateButton);
       TimeButton=findViewById(R.id.TimeButton);
        Time2Button=findViewById(R.id.Time2Button);
        DateText=findViewById(R.id.DateText);
        TimeText=findViewById(R.id.TimeText);

        Time2Text=findViewById(R.id.Time2Text);


        DateButton.setOnClickListener( this);
        TimeButton.setOnClickListener( this);
        Time2Button.setOnClickListener( this);
    }



    @Override
    public void onClick(View v) {

        if (v == DateButton) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);


            final DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {


                            DateText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            //datePickerDialog.dismiss();




                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == TimeButton) {

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
            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(DateTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
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

                            Time2Text.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
