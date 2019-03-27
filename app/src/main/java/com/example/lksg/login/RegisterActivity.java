package com.example.lksg.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCfPassword;
    Button mButtonRegister;
    TextView mTextViewRegister;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DatabaseHelper(this);
        mTextUsername=findViewById(R.id.editText3);
        mTextPassword=findViewById(R.id.editText4);
        mTextCfPassword=findViewById(R.id.editText5);
        mButtonRegister=findViewById(R.id.button2);
        mTextViewRegister=findViewById(R.id.textView);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent= new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);

            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=mTextUsername.getText().toString().trim();
                String psw=mTextPassword.getText().toString().trim();
                String cfpsw=mTextCfPassword.getText().toString().trim();

                if(psw.equals(cfpsw)){
                    long val=db.addUser(user,psw);
                    if (val>0) {
                        Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent movetologin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(movetologin);
                    }else{
                        Toast.makeText(RegisterActivity.this, "registered error", Toast.LENGTH_SHORT).show();


                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"password not match",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
