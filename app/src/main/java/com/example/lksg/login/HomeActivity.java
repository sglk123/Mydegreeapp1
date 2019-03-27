package com.example.lksg.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    Button level1;
    Button level2;
    Button level3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        level1=findViewById(R.id.levelone);
        level2=findViewById(R.id.leveltwo);
        level3=findViewById(R.id.levelthree);
    }
}
