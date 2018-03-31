package com.example.popla.gorkhavidyutpowerpay.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.User;
import com.example.popla.gorkhavidyutpowerpay.manager.UserManager;

public class SignUp extends AppCompatActivity {

    public static final String USER = "user";
    public static final String EMPLOYEE = "employee";
    public static final String ADMIN = "admin";


    EditText uname,uemail,umobile,uaadhar,upassword,ukno,repassword;
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
    }
    public void register() {
        intialize();
        if (validate()) {
            onLogInSuccess();
        } else {
            Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
        }

    }
    public void onLogInSuccess()
    {

        User user=new User();
        user.setUser_name(n);
        user.setUser_email(e);
        user.setUser_type(USER);
        user.setUser_mobile(Integer.parseInt(p));
        user.setUser_aadhar(Long.parseLong(a));
        user.setUser_password(pass);
        user.setUser_kno(k);
        UserManager.insertOrReplace(this,user);


        Toast.makeText(this, "User Registered Successfully,Please Login to continue.", Toast.LENGTH_SHORT).show();
        finish();

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
        boolean valid = true;
        if (n.isEmpty()) {
            uname.setError("Please Enter Name");
            valid = false;
        }
        if (e.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            uemail.setError("Please Enter Valid Email Id");
            valid = false;
        }
        if (p.isEmpty()) {
            umobile.setError("Please Enter  Mobile No.");
            valid = false;
        }
        if (pass.isEmpty()) {
            upassword.setError("Please Enter Password");
            valid = false;
        }
        if (r.isEmpty()) {
            repassword.setError("Re Enter Password");
            valid = false;
        }

        if(!pass.isEmpty() && !r.isEmpty() && pass.equals(r)){
            repassword.setError("password not matching with the previous password");
            valid = false;
        }
        if (a.isEmpty()) {
            uaadhar.setError("Please Enter 12 Digit Aadhar No.");
            valid = false;
        }
        if (k.isEmpty()) {
            ukno.setError("Please Enter 9 Digit Key No.");
            valid = false;
        }

        return valid;
    }

}
