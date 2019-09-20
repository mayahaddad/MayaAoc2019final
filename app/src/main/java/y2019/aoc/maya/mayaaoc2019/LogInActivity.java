package y2019.aoc.maya.mayaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextEmail, editTextPassword;
    Button buttonLogIn, buttonSignUp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

      buttonLogIn =findViewById(R.id.button);
      buttonLogIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==buttonLogIn){
          Intent i = new Intent( this, MainActivity.class);
                  startActivity(i);

        }else{

        }


    }
}