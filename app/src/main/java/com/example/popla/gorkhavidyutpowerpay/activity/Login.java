package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.Verifier.VerifierNewConnection;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

     EditText emailid,pass;
    CheckBox cb1;
    Button login;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailid =(EditText) findViewById(R.id.UserName) ;
        final TextView textView=(TextView)findViewById(R.id.textView);
       pass = (EditText)findViewById(R.id.password);
       cb1=(CheckBox)findViewById(R.id.checkbox1);
        login=(Button)findViewById(R.id.Login_button);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        // insertDataIntoDb();
        //getUserDATA();
    login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                register();
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
        Intent intent;  int count=0;
        if ((emailid.getText().toString().equals("ab@gmail.com"))&&(pass.getText().toString().equals("1234")))
        {
            intent =new Intent(this,AddNewConnection.class  );
            startActivity(intent);
        }
        else if((emailid.getText().toString()) != null) {
            ListView listView;
            List<String> eid;
            List<String> pass;
            listView = (ListView) findViewById(R.id.list_view);
            eid = new ArrayList<String>();
            pass = new ArrayList<String>();

        }
    }
    public void intialize()
    {
        username=emailid.getText().toString().trim();
        password=pass.getText().toString().trim();
    }

    public boolean validate() {
        boolean valid=true;
        if(username.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            emailid.setError("Please Enter Valid Email Id");
            valid=false;
        }
        if (password.isEmpty()||pass.length()>32)
        {
            pass.setError("Please Enter Password");
            valid=false;
        }
        return valid;
    }

    public void sign(View v)
    {
        Intent r= new Intent(this, SignUp.class);
        startActivity(r);
    }
}
