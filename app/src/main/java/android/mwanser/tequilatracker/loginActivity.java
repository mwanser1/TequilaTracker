package android.mwanser.tequilatracker;

import android.content.Intent;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    //fun
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Button and text stuff finder
        final Button buttonLogin=(Button)findViewById(R.id.submitLogin);
        final Button buttonCreate=(Button)findViewById(R.id.newAccount);
        final EditText textUserName = (EditText)findViewById(R.id.userEmail);
        final EditText textPassword = (EditText)findViewById(R.id.thePassword);
        final TextView textError = (TextView)findViewById(R.id.loginError);


        //Login button set
        assert buttonLogin != null; //What is this
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "Submit Login Clicked");
                int theID = checkLoginCredentials(textUserName.getText().toString(), textPassword.getText().toString());

                if (theID == -1) {
                    textError.setText("User login failed, please try again");
                    return;
                }
                else {
                    //Set intent to new intent
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //intent.putExtra("");
                    startActivity(intent);
                }
            }
        });
        assert buttonCreate != null; //What is this
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "Create Login Clicked");
                //Set intent to new intent
                Intent intent = new Intent(getApplicationContext(), CreateUser.class);
                //intent.putExtra("");
                startActivity(intent);

            }
        });
    }
    //Questions: how do i keep track of who is logged in? how do i actually pass the app the ID of the user ?
    //HOw can i keep user logged in to his phone?
    /**
     *
     * @param u - user name user submitted
     * @param p - password user submitted
     * @return -1 if user does not exist, password wrong or error.
     * if username and password match database, it returns the user ID
     */
    private int checkLoginCredentials(String u, String p){
        Log.d("LoginActivity","name: "+u+" password: "+p);
        if(u.length()==0 || p.length()==0){
            Log.d("LoginActivity","LoginCredentials failed something is blank");
            return -1;
        }
        //go to databaase and check username to password
        //if both match return id
        //MainActivity.ID=1;
        ArrayList<String> users = new ArrayList<>();
        try {
            String filename = "loginCredentials.txt";
            File myFile = new File(Environment
                    .getExternalStorageDirectory(), filename);
            if (!myFile.exists())
                myFile.createNewFile();
            FileInputStream fos;

            try {
                String temp;
                fos = new FileInputStream(myFile);
                BufferedReader myReader = new BufferedReader(new InputStreamReader(fos));
                while((temp=myReader.readLine())!=null){
                    Log.d("Loginactivity","temp "+temp);
                    users.add(temp);
                }
                myReader.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e2){
            e2.printStackTrace();
        }
        int i=0;
        for(String s: users){
            String temp[]=s.split(" ");
            if(u.equals(temp[0]))
                if(p.equals(temp[2]))
                    return i;
            i++;
        }
        return -1;
    }
}
