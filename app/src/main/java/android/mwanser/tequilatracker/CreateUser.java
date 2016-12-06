package android.mwanser.tequilatracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CreateUser extends AppCompatActivity {
    private EditText userName=null;
    private EditText userEmail1=null;
    private EditText userEmail2=null;
    private EditText userPassword1=null;
    private EditText userPassword2=null;
    private RadioGroup userRadio=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userName= (EditText)findViewById(R.id.userName);
        userEmail1=(EditText)findViewById(R.id.userEmail1);
        userEmail2=(EditText)findViewById(R.id.userEmail2);
        userPassword1=(EditText)findViewById(R.id.userPassword1);
        userPassword2=(EditText)findViewById(R.id.userPassword2);
        userRadio=(RadioGroup)findViewById(R.id.radioUserType);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("createUSer","Adding user");
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                if(verifyCredentials()){
                    //go to next intent
                    //push to database


                        RadioButton radioButton= (RadioButton) findViewById(userRadio.getCheckedRadioButtonId());

                        String string = userName.getText().toString()+" "+userEmail1.getText().toString()+" "+
                                userPassword1.getText().toString()+" "+radioButton.getText()+"\n";

                        Log.d("createUser", string);
                        try {
                            String filename = "loginCredentials.txt";
                            File myFile = new File(Environment
                                    .getExternalStorageDirectory(), filename);
                            if (!myFile.exists())
                                myFile.createNewFile();
                            FileOutputStream fos;

                            try {
                                fos = new FileOutputStream(myFile,true);
                                OutputStreamWriter myOutWriter= new OutputStreamWriter(fos);
                                myOutWriter.append(string);
                                myOutWriter.flush();
                                myOutWriter.close();

                                fos.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    Log.d("CreateUser","Success+++++");
                }
                else{
                    Log.d("CreateUser", "Failed----");
                }

            }
        });
    }

    private boolean verifyCredentials(){
        int temp=0;
        Log.d("CreateUser","Verify Credentials of user");
        //verify the user credentials
        if(!userEmail1.getText().toString().equals(userEmail2.getText().toString())) {
            Log.d("CreateUser","emails do not match");
            temp=1;
        }
        if (!userPassword1.getText().toString().equals(userPassword2.getText().toString())){
            Log.d("CreateUSer","passwords do not match ");
            temp=1;
        }
        if(userRadio.getCheckedRadioButtonId()==-1) {
            Log.d("CreateUser","No radio selected ");
            temp=1;
        }
        if(temp==0) return true;
        else return false;


    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}


