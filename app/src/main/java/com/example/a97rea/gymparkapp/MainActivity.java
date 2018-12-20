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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
public class MainActivity extends Activity {
    EditText UserName_input,Password_input;
    Button Login,Register;
    Boolean flag;

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
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_NETWORK_STATE)!=
                PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(MainActivity.this,new String[]
                    {Manifest.permission.ACCESS_NETWORK_STATE},3);
        Bmob.initialize(this,"05a5688c588c2eeb11e5160168093dfd");
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 123);
        }
        Login=(Button) findViewById(R.id.Login);
        Register=(Button) findViewById(R.id.Register);
        UserName_input=findViewById(R.id.UserName_INPUT);
        Password_input=findViewById(R.id.Password_INPUT);
        //set an listener on Login Button to jump to the mainContent
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=false;
                String name=UserName_input.getText().toString();
                String password=Password_input.getText().toString();
                BmobQuery<AppUser> query=new BmobQuery<AppUser>();
                query.addWhereEqualTo("name",name);
                query.addWhereEqualTo("password",password);
                query.findObjects(new FindListener<AppUser>() {
                    @Override
                    public void done(List<AppUser> list, BmobException e) {
                        if(e==null&&list.get(0)!=null){
                            flag=true;
                            Intent gotoMainContent=new Intent(MainActivity.this,mainContent.class);
                            startActivity(gotoMainContent);
                            toast("成功登录");
                        }
                        else {
                            toast("您输入的账户名或者密码有误");
                        }
                    }
                });
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
    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
