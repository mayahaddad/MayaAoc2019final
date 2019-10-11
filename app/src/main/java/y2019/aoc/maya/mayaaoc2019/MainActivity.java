package y2019.aoc.maya.mayaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }

    public void onClick (View v){
        if (v==buttonNow){
            Intent goToNextActivity=new Intent(this,HomePageActivity.class);
            startActivity( goToNextActivity);
        }
    }

}
