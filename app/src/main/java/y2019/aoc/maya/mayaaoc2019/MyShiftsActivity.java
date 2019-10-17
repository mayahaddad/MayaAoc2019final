package y2019.aoc.maya.mayaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class MyShiftsActivity extends AppCompatActivity {

    ArrayList<Shifts> shifts;
    ListView shiftList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shifts);

        shifts = new ArrayList<>();
        shifts.add(new Shifts(null,"13:00","20:00","456"));

        shiftList=findViewById(R.id.ShiftListView);
        shifts=new ArrayList<>();



    }
}
