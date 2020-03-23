package y2019.aoc.maya.mayaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonNow, buttonWorkSettings ,buttonMyShifts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNow = findViewById(R.id.buttonNow);

        buttonNow.setOnClickListener(this);

        buttonMyShifts = findViewById(R.id.buttonMyShifts);
        buttonMyShifts.setOnClickListener(this);

        buttonWorkSettings = findViewById(R.id.buttonWorkSettings);
        buttonWorkSettings.setOnClickListener(this);
    }

    public void onClick (View v){
        if (v==buttonNow){
            Intent goToNextActivity=new Intent(this,HomePageActivity.class);
            startActivity( goToNextActivity);
        }
        if(v == buttonMyShifts){
            Intent goToNextActivity=new Intent(this,MyShiftsActivity.class);
            startActivity( goToNextActivity);
        }

        if(v==buttonWorkSettings){
            Intent goToNextActivity=new Intent(this,MyWorkActivity.class);
            startActivity( goToNextActivity);
        }




    }

    public boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToNextActivity;

        switch (item.getItemId()) {


            case R.id.logout:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure?");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent goToNextActivity = new Intent(getApplicationContext(), LogInActivity.class);
                        startActivity(goToNextActivity);
                    }
                });
                builder.setNegativeButton("NO", null);
                AlertDialog dialog = builder.create();
                dialog.show();


                break;

        }
        return true;
    }


    }
