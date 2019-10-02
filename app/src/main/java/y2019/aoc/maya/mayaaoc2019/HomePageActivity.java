package y2019.aoc.maya.mayaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    Button startShift;
    long startTime, stopTime;
    boolean isStarted = false;
    TextView tvTotalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        startShift = findViewById(R.id.buttonStartShift);
        startShift.setOnClickListener(this);

        tvTotalTime = findViewById(R.id.textViewShiftTime);

    }



    public boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent goToNextActivity;

        switch(item.getItemId()){
            case R.id.mywork:

                goToNextActivity=new Intent(getApplicationContext(),MyWorkActivity.class);
                startActivity(goToNextActivity);

                break;

            case R.id.myshifts:

                goToNextActivity=new Intent(getApplicationContext(),MyShiftsActivity.class);
                startActivity(goToNextActivity);

                break;

            case R.id.now:

                goToNextActivity=new Intent(getApplicationContext(),NowActivity.class);
                startActivity(goToNextActivity);

                break;

            case R.id.logout:

                AlertDialog.Builder builder =new AlertDialog.Builder (this);
                builder.setMessage("Are you sure?");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent goToNextActivity=new Intent(getApplicationContext(),LogInActivity.class);
                        startActivity(goToNextActivity);
                    }
                });
                builder.setNegativeButton("NO",null);
                AlertDialog dialog=builder.create();
                dialog.show();



                break;

        }
        return true;

    }

    @Override
    public void onClick(View v) {
        if(!isStarted) {
            startTime = System.currentTimeMillis();
            startShift.setText("Stop Shift");
            isStarted = true;
        }else{
            stopTime = System.currentTimeMillis();
            startShift.setText("Start Shift");
            isStarted = false;

            tvTotalTime.setText("Worked Minutes: " +((stopTime-startTime)/1000/60));


        }

    }

}

