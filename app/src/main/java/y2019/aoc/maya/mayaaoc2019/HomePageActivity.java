package y2019.aoc.maya.mayaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }



    public boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    
}

