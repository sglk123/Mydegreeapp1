package com.example.lksg.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // test

    // Eric Test
    
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
     DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db=new DatabaseHelper(this);


        mTextUsername=findViewById(R.id.editText);
        mTextPassword=findViewById(R.id.editText2);
        mButtonLogin=findViewById(R.id.button);
        mTextViewRegister=findViewById(R.id.textView2);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=mTextUsername.getText().toString().trim();
                String pwd=mTextPassword.getText().toString().trim();
                Boolean res=db.checkUsers(user,pwd);
                if(res==true){
                  Intent LoginScreen=new Intent(MainActivity.this, HomeActivity.class);
                   startActivity(LoginScreen);
                }else {
                    Toast.makeText(MainActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
