package y2019.aoc.maya.mayaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignUp = findViewById(R.id.buuttonSignUp);

        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);

        buttonSignUp.setOnLongClickListener(this);

    }
    public void onClick(View v){
        if(v==buttonSignIn){
            Toast.makeText(this, "sign in", Toast.LENGTH_LOGN).show();
        }else{
            Toast.makeText(this, "sign up", Toast.LENGTH_LOGN).show();
        }



    }
}
