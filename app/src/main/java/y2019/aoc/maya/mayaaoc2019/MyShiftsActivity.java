package y2019.aoc.maya.mayaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class MyShiftsActivity extends AppCompatActivity {

    ArrayList<Shifts> shifts;
    ListView shiftList;
    CustomAdapter2 adapter2;

    //gets the currently logged in user
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users/"+user.getUid()+"/Shifts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shifts);

        shifts = new ArrayList<>();


        shiftList = findViewById(R.id.ShiftListView);
        adapter2 = new CustomAdapter2(this, R.layout.shift_item, shifts);
        shiftList.setAdapter(adapter2);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Shifts shift = dataSnapshot.getValue(Shifts.class);
                shifts.add(shift);
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.addmenu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.addshift:


                Intent goToNextActivity = new Intent(getApplicationContext(),DateTimeActivity.class);
                startActivity(goToNextActivity);

                break;


        }
        return true;
    }

}
