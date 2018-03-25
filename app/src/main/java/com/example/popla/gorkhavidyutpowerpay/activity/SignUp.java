package com.example.popla.gorkhavidyutpowerpay.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Register;

public class SignUp extends AppCompatActivity {

    EditText uname,uemail,umobile,uaadhar,upassword,ukno,repassword;
    DaoSession daoSession;
    Register register;
    String n,e,p,a,pass,k,r;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        uname = (EditText)findViewById(R.id.edit1);
        uemail = (EditText)findViewById(R.id.edit2);
        umobile = (EditText)findViewById(R.id.edit3);
        uaadhar = (EditText)findViewById(R.id.edit4);
        upassword = (EditText)findViewById(R.id.edit5);
        ukno = (EditText)findViewById(R.id.edit7);
        repassword=(EditText)findViewById(R.id.edit6);
        b1=(Button)findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                register();
            }
        });
        repassword.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                String s1 = upassword.getText().toString();
                if((s.length() > 0) && (s1.length() > 0))
                {      if (!(repassword.getText().toString().equals(upassword.getText().toString())))
                    repassword.setError("Password Is Not Matched");
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

    }
    public void register()
    {
        intialize();
        if(!validate())
        {
        }
        else
        {
            onLogInSuccess();
        }

    }
    public void onLogInSuccess()
    {
        //after validate button Click Content
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
    public void intialize()
    {
        n=uname.getText().toString().trim();
        e=uemail.getText().toString().trim();
        p=umobile.getText().toString().trim();
        a=uaadhar.getText().toString().trim();
        pass=upassword.getText().toString().trim();
        k=ukno.getText().toString().trim();
        r=repassword.getText().toString().trim();
    }

    public boolean validate() {
        boolean valid=true;
        if(n.isEmpty()){
            uname.setError("Please Enter Name");
            valid=false;
        }
        if (e.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(e).matches())
        {
            uemail.setError("Please Enter Valid Email Id");
            valid=false;
        }
        if (p.isEmpty())
        {
            umobile.setError("Please Enter  Mobile No.");
            valid=false;
        }
        if (pass.isEmpty())
        {
            upassword.setError("Please Enter Password");
            valid=false;
        }
        if (a.isEmpty())
        {
            uaadhar.setError("Please Enter 12 Digit Aadhar No.");
            valid=false;
        }
        if (k.isEmpty())
        {
            ukno.setError("Please Enter 9 Digit Key No.");
            valid=false;
        }
        if (r.isEmpty())
        {
            repassword.setError("Re Enter Password");
            valid=false;
        }
        return valid;
    }

/*    public void signup(View view)
    {

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
        ukno.setText(null);
        Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();


    }*/
/*
    public void show(View v)
    {
        daoSession = ((AppController)getApplication()).getDaoSession();

    }*/
}
