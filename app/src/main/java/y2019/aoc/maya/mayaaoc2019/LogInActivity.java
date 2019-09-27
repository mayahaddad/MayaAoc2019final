package y2019.aoc.maya.mayaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextEmail, editTextPassword;
    Button buttonLogIn, buttonSignUp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

      buttonLogIn =findViewById(R.id.buttonLogin);
      buttonLogIn.setOnClickListener(this);
      buttonSignUp = findViewById(R.id.buttonSignUp);
      buttonSignUp.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void onClick(View v){
        if(v==buttonLogIn){
            if(editTextEmail.getText().toString().equals("")||editTextPassword.getText().toString().equals("")){
                Toast.makeText(this, "Empty username or password", Toast.LENGTH_LONG).show();
            }
            else{
                Intent i =new Intent (this, HomePageActivity.class);
                i.putExtra("email",editTextEmail.getText().toString());
                startActivity(i);


        }
    }
    else{
            Intent i=new Intent( this,SignUpActivity.class);
            startActivity(i);
        }
}
    }