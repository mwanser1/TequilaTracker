package android.mwanser.tequilatracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MyBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Bar> arrayOfBars  = new ArrayList<Bar>();
        // Create the adapter to convert the array to views
        BarAdapter adapter = new BarAdapter(this, arrayOfBars);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.barItems);
        listView.setAdapter(adapter);

        // Add item to adapter
        Bar newUser = new Bar("On the Border", "Restuarant",5);
        Bar newUser2 = new Bar("Taco Bell","Fast Food",1);
        Bar newUser3 = new Bar("Off the boarder", "Dive",3);
        Bar newUser4 = new Bar("Casa de House", "Club",4);
        Bar newUser5 = new Bar("Puerto vallarta", "Bar",4);

        adapter.add(newUser);
        adapter.add(newUser2);
        adapter.add(newUser3);
        adapter.add(newUser4);
        adapter.add(newUser5);
        adapter.add(newUser);
        adapter.add(newUser2);
        adapter.add(newUser3);
        adapter.add(newUser4);
        adapter.add(newUser5);
        adapter.add(newUser);
        adapter.add(newUser2);
        adapter.add(newUser3);
        adapter.add(newUser4);
        adapter.add(newUser5);
    }

}
