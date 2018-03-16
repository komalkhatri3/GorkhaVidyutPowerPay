package com.example.popla.gorkhavidyutpowerpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    Intent intent;
    public void SignIn(View view)
    {
        intent =new Intent(this,Power.class);
        startActivity(intent);
    }
    public void sign(View view)
    {
        intent = new Intent(this,SignUp.class);
    }
}
