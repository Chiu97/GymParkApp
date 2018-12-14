package com.example.a97rea.gymparkapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class register extends AppCompatActivity {
    EditText username_edit_text,password_edit_text,password_confirm_edit_text,email_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Button register=(Button) findViewById(R.id.registerBtn);
        username_edit_text=findViewById(R.id.password_register);
        password_edit_text=findViewById(R.id.password_register);
        password_confirm_edit_text=findViewById(R.id.password_confirm_register);
        email_edit_text=findViewById(R.id.email_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String username,password,password_confirm,email;
                username=username_edit_text.getText().toString();
                password=password_edit_text.getText().toString();
                password_confirm=password_confirm_edit_text.getText().toString();
                email=email_edit_text.getText().toString();
                if(username=="")
                    toast("您输入的用户名为空");
                if(password==""){
                    toast("您输入的密码为空");
                }
                if(password!=password_confirm){
                    toast("两次输入的密码不一致");
                }
                if(!isValidEmail(email)){
                    toast("您输入的邮箱格式有误");
                }
                else{
                    toast("成功创建新用户!");
                    AppUser user=new AppUser();
                    user.setName(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            toast("WOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW");
                        }
                    });
                    Intent gotoMainActivity=new Intent(register.this,MainActivity.class);
                    startActivity(gotoMainActivity);
                }
            }
        });
    }
    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
