package android.mwanser.tequilatracker;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int userId=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button findTequila=(Button)findViewById(R.id.findTequila);
        final Button findBar=(Button)findViewById(R.id.findBar);
        final Button addBar = (Button)findViewById(R.id.addBar);
        final Button addTequila = (Button)findViewById(R.id.addTequila);
        final Button logout = (Button)findViewById(R.id.logout);
        final Button myTequila = (Button)findViewById(R.id.myTequila);
        final Button myBar = (Button)findViewById(R.id.myBar);

        assert findTequila != null; //What is this
        findTequila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","FindTequila button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), FindTequila.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });
        assert findBar != null; //What is this
        findBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","findBar button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), FindBar.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });
        assert addBar != null; //What is this
        addBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","AddBAr button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), AddBar.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });
        assert logout != null; //What is this
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","Logout button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });
        assert myTequila != null; //What is this
        myTequila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","Mytequila button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), MyTequila.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });
        assert myBar != null; //What is this
        myBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","mybar button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), MyBar.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });
        assert addTequila != null; //What is this
        addTequila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","AddTequila button clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), AddTequila.class);
                //intent.putExtra("");
                startActivity(intent);
            }
        });




    }
    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);
        if(action==MotionEvent.ACTION_DOWN){
            Log.d("Mainactivity","Swipe down detected");
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            //intent.putExtra("");
            startActivity(intent);

            return true;
        }
        return false;

    }
}
