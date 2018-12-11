package com.example.a97rea.gymparkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Login=(Button) findViewById(R.id.Login);
        Button Register=(Button) findViewById(R.id.Register);
        //set an listener on Login Button to jump to the mainContent
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMainContent=new Intent(MainActivity.this,mainContent.class);
                startActivity(gotoMainContent);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegister=new Intent(
                        MainActivity.this,register.class);
                startActivity(gotoRegister);
            }
        });
    }
}
