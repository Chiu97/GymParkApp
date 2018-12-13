package com.example.a97rea.gymparkapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //to get the write external storage permission and the read phone state permission
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_PHONE_STATE)!=
                PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(
                    MainActivity.this,new String[]{Manifest.permission.READ_PHONE_STATE},2);
        Bmob.initialize(this,"05a5688c588c2eeb11e5160168093dfd");
//        BmobQuery<User> bmobQuery = new BmobQuery<User>();
//        bmobQuery.getObject("MoCl777K", new QueryListener<User>() {
//            @Override
//            public void done(User user, BmobException e) {
//                if(e==null){
//                    Toast.makeText(getApplicationContext(),"查询成功",Toast.LENGTH_LONG);
//                }else{
//                    Toast.makeText(getApplicationContext(),"查询失败",Toast.LENGTH_LONG);
//                }
//            }
//        });
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 123);
        }
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
