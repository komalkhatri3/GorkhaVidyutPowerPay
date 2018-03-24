package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Register;
import com.example.popla.gorkhavidyutpowerpay.db.User;
import com.example.popla.gorkhavidyutpowerpay.db.UserDao;

public class SignUp extends AppCompatActivity {

    EditText uname,uemail,umobile,uaadhar,upassword,ukno;
    DaoSession daoSession;
    Register register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }
    public void signup(View view)
    {


        uname = (EditText)findViewById(R.id.edit1);
        uemail = (EditText)findViewById(R.id.edit2);
        umobile = (EditText)findViewById(R.id.edit3);
        uaadhar = (EditText)findViewById(R.id.edit4);
        upassword = (EditText)findViewById(R.id.edit5);
        ukno = (EditText)findViewById(R.id.edit7);
        daoSession =((AppController)getApplication()).getDaoSession();
        register=new Register();
        //String un=uname.getText().toString();

        register.setUser_name(uname.getText().toString());
        register.setUser_email(uemail.getText().toString());
        register.setUser_mobile(umobile.getText().toString());
        register.setUser_aadhar(uaadhar.getText().toString());
        register.setUser_password(upassword.getText().toString());
        register.setUser_kno(ukno.getText().toString());
        daoSession.getRegisterDao().insert(register);

        /*uname.setText(null);
        uemail.setText(null);
        umobile.setText(null);
        uaadhar.setText(null);
        upassword.setText(null);
        ukno.setText(null);*/
        Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();


    }

    public void show(View v)
    {
        daoSession = ((AppController)getApplication()).getDaoSession();

    }
}
