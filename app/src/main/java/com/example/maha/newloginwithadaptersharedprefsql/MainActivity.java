package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import static com.example.maha.newloginwithadaptersharedprefsql.SignUp.SHARED_PREF_NAME;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;

    Button logIn;

    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
///////////////////////////////////////////////////////////
        Intent fromLogout = getIntent();
//////////////////////////////////////////////////////////
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        logIn = (Button) findViewById(R.id.logIn);

//////////////////////////////////////////
        signUp = (Button) findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SignUp.class);
                intent.putExtra("txtMessage", "Welcome New User");
                startActivity(intent);

            }
        });
/////////////////////////////////////////////////////

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = userName.getText().toString();
              int uPassword= Integer.parseInt(password.getText().toString());


                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
                String xyz=sharedPreferences.getString("currentU","no user");
                Gson gson =new Gson();
                User finalUser=gson.fromJson(xyz,User.class);

//

                if (uName.equals(finalUser.getName()) &&uPassword==finalUser.getPass() ){

                    Intent intent1 = new Intent(MainActivity.this,MainNotes.class);
                    startActivity(intent1);
                    finish();




                }else{

                    Toast.makeText(MainActivity.this,"Not Vlaid",Toast.LENGTH_LONG).show();
                }




            }
        });


    }
}
