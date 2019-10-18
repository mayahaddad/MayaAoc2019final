package y2019.aoc.maya.mayaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MyShiftsListActivity extends AppCompatActivity {

    ListView ShiftListView;
    ArrayList<Shifts> shifts = new ArrayList<>();
    CustomAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shifts);

        ShiftListView = findViewById(R.id.ShiftListView);



    }
}
