package y2019.aoc.maya.mayaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEmail, editTextPassword;
    Button buttonSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextEmail = findViewById(R.id.editTextPassword);

        buttonSignUp = findViewById(R.id.button);
        buttonSignUp.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v == buttonSignUp) {
            if (editTextPassword.getText().toString().equals("") || editTextEmail.getText().toString().equals("")) {
                Toast.makeText(this, "Empty Email or Password", Toast.LENGTH_LONG).show();

            } else {
                Intent i = new Intent(this, HomePageActivity.class);
                i.putExtra("Email", editTextEmail.getText().toString());
                i.putExtra("password", editTextPassword.getText().toString());
                startActivity(i);
            }


        } else

        {
            Intent i = new Intent(this, HomePageActivity.class);
            startActivity(i);
        }
    }
}