package com.example.a97rea.gymparkapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Button register=(Button) findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent gotoMainActivity=new Intent(register.this,MainActivity.class);
                startActivity(gotoMainActivity);
            }
        });
    }
}
