package y2019.aoc.maya.mayaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Date;

public class MyShiftsActivity extends AppCompatActivity {

    ArrayList<Shifts> shifts;
    ListView shiftList;
    CustomAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shifts);

        shifts = new ArrayList<>();
        shifts.add(new Shifts(new Date(),"13:00","20:00","456"));
        shifts.add(new Shifts(new Date(),"13:00","20:00","456"));

        shifts.add(new Shifts(new Date(),"13:00","20:00","555"));

        shifts.add(new Shifts(new Date(),"13:00","20:00","456"));

        shifts.add(new Shifts(new Date(),"13:00","20:00","456"));


        shiftList=findViewById(R.id.ShiftListView);
        adapter2 = new CustomAdapter2(this, R.layout.shift_item, shifts);
        shiftList.setAdapter(adapter2);





    }
}
