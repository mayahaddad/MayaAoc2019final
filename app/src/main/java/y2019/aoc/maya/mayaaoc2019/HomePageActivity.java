package y2019.aoc.maya.mayaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    Button startShift;
    long startTime, stopTime;
    boolean isStarted = false;
    TextView tvTotalTime;

    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        startShift = findViewById(R.id.buttonStartShift);
        startShift.setOnClickListener(this);

        tvTotalTime = findViewById(R.id.textViewShiftTime);

    }


    @Override
    public void onClick(View v) {
        if(!isStarted) {
            startTime = System.currentTimeMillis();
            startShift.setText("Stop Shift");
            isStarted = true;
        }else {
            stopTime = System.currentTimeMillis();
            startShift.setText("Start Shift");
            isStarted = false;

            tvTotalTime.setText("Worked Minutes: " + ((stopTime - startTime) / 1000 / 60));
            Shifts shifts = new Shifts(new Date(), startTime, stopTime, 70);


            Intent i=new Intent( this,MyShiftsActivity.class);
            startActivity(i);
        }

    }

}

