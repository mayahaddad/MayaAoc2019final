package y2019.aoc.maya.mayaaoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEmail, editTextPassword, editTextConfirmPassword, editTextHourlyWages, editTextBreak;
    Button buttonSignUp;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        //editTextHourlyWages = findViewById(R.id.editTextHourlyWages);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
     //   editTextBreak = findViewById(R.id.editTextBreak);


        buttonSignUp = findViewById(R.id.buttonSignUp2);
        buttonSignUp.setOnClickListener(this);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
      //  updateUI(currentUser);
    }
    public void signUp (String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information


                            Log.d("firebase", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                          //  updateUI(user);
                            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                            i.putExtra("Email", editTextEmail.getText().toString());
                            i.putExtra("password", editTextPassword.getText().toString());
                            i.putExtra("password", editTextConfirmPassword.getText().toString());
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("firebase", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void onClick(View v) {
        if (v == buttonSignUp) {
            if ((editTextEmail == null) || (editTextConfirmPassword == null) || (editTextHourlyWages == null) || (editTextPassword == null) || (editTextBreak == null)) {
                Toast.makeText(this, "somthing is wrong", Toast.LENGTH_LONG).show();
            }
            if ((editTextPassword.getText().toString().equals("")) || (editTextEmail.getText().toString().equals(""))) {
                Toast.makeText(this, "Empty Email or Password", Toast.LENGTH_LONG).show();
            } /*else if (!editTextConfirmPassword.getText().toString().equals(editTextPassword)) {
                    Toast.makeText(this, "confirm password is empty or wrong", Toast.LENGTH_LONG).show();
                } */else {
                signUp(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }



        }
    }

}
