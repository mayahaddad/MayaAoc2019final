package y2019.aoc.maya.mayaaoc2019;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileNotFoundException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;
    private static final int SELECT_IMAGE = 1;


    EditText editTextEmail, editTextPassword; //editTextConfirmPassword, editTextHourlyWages, editTextBreak;
    Button buttonSignUp;
    ImageView imageView;
    Button btGallery, btTakePhot;
    Bitmap bitmap;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        //editTextHourlyWages = findViewById(R.id.editTextHourlyWages);
     //   editTextBreak = findViewById(R.id.editTextBreak);


        buttonSignUp = findViewById(R.id.buttonSignUp2);
        buttonSignUp.setOnClickListener(this);
        btGallery= findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);
        btTakePhot = findViewById(R.id.btTakePhot);
        btTakePhot.setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(this);


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
            if ((editTextEmail == null)  || (editTextPassword == null) ) {
                Toast.makeText(this, "somthing is wrong", Toast.LENGTH_LONG).show();

            } //else if (!editTextConfirmPassword.getText().toString().equals(editTextPassword)) {
                   // Toast.makeText(this, "confirm password is  wrong", Toast.LENGTH_LONG).show();
             //   }
            else {
                signUp(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }



        }
        if(v == btTakePhot){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        }else{ if(v==btGallery){
            Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }
        }
            }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if the request was from camera and the result was OK meaning the camera worked
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            //the image captured is saved in the data object
            bitmap = (Bitmap) data.getExtras().get("data");
            //set image captured to be the new image
            imageView.setImageBitmap(bitmap);
        }
        else if(requestCode == SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            //URI - unified resource locator is something like URL but can hold different type of paths
            // examples: file:///something.txt, http://www.example.com/, ftp://example.com
            // A Uri object is usually used to tell a ContentProvider what we want to access by reference
            Uri targetUri = data.getData();
            try {
                //Decode an input stream into a bitmap.
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }


}




