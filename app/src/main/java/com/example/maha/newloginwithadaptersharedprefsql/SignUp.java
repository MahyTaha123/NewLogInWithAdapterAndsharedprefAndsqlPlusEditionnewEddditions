package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class SignUp extends AppCompatActivity {

    static final String SHARED_PREF_NAME = "current_user";

    TextView textView;
    EditText userNameSign;
    EditText passwordSign;
    Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//////////////
        textView = (TextView) findViewById(R.id.textView);
        textView.setText((String) getIntent().getExtras().get("txtMessage"));
//////////////


        userNameSign = (EditText) findViewById(R.id.userNameSign);
        passwordSign = (EditText) findViewById(R.id.passwordSign);
        done = (Button) findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(userNameSign.getText().toString(), Integer.parseInt(passwordSign.getText().toString()));
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                Gson gson = new Gson();
                String theUser=gson.toJson(gson);
                editor.putString("CurrentU", theUser);
                editor.apply();


            }
        });


    }
}
