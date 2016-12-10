package android.mwanser.tequilatracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MyTequila extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tequila);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Tequila> arrayOfTequilas = new ArrayList<Tequila>();
        // Create the adapter to convert the array to views
        TequilaAdapter adapter = new TequilaAdapter(this, arrayOfTequilas);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.tequilaItems);
        listView.setAdapter(adapter);

        // Add item to adapter
        Tequila newUser = new Tequila("Don Julio Silver", "Blanco",5);
        Tequila newUser2 = new Tequila("Don Julio 1942","Anejo",5);
        Tequila newUser3 = new Tequila("Jose Cuervo", "Blanco",3);
        Tequila newUser4 = new Tequila("Espolon", "Blanco",4);
        Tequila newUser5 = new Tequila("Herradura", "Repasado",4);

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
