package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   register();
            }
        });
        // insertDataIntoDb();
        //getUserDATA();
    /*    login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
             //   if(!vali)
            }

        });*/
    cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(!isChecked){
                pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            else
                pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    });
    }

   /* private void getUserDATA() {
        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();
        List<User> list = daoSession.getUserDao().loadAll();
        Log.i("RESULT", list.get(0).getEmail());
        Toast.makeText(this,  list.get(0).getEmail().toString(),Toast.LENGTH_LONG).show();
    }

    private void insertDataIntoDb() {

        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();
        User user=new User();
        user.setEmail("dfkjdhkjds");
        user.setFirst_name("dfjkdfhkdf");
        user.setLast_name("dfjkdfhkdf");
        user.setUser_id(101);
        daoSession.getUserDao().insert(user);
    }

   public void register()
   {
       intialize();
       if(!validate())
       {

       }

   }
   */
   public  void intialize()
   {
      username=emailid.getText().toString().trim();
       password=pass.getText().toString().trim();
   }
    Intent intent;
    public void LogIn(View view)
    {
        int count=0;
        if ((emailid.getText().toString().equals("1234"))&&(pass.getText().toString().equals("1234")))
        {
            intent =new Intent(this, EmployeRegistration.class  );
            startActivity(intent);
        }
        else if((emailid.getText().toString()) != null)
        {
            ListView listView;
            List<String> eid;
            List<String> pass;
            listView = (ListView) findViewById(R.id.list_view);
            eid = new ArrayList<String>();
            pass = new ArrayList<String>();
          /*  DaoSession daoSession = ((AppController)getApplication()).getDaoSession();
            List <Register> list= daoSession.getRegisterDao().
            for(int i=0;i<list.size();i++)
            {



                eid.add(list.get(i).getUser_email());
                pass.add(list.get(i).getUser_password());
                if((list.get(i).getUser_email()).equals((emailid.getText().toString())))
                {

                    Toast.makeText(this,"Logged-in successfully",Toast.LENGTH_LONG).show();
                     count++;


                }
                else
                {
                    count = 0;
                }

            }
            if(count==0)
            {
                Toast.makeText(this,"Not Registered User",Toast.LENGTH_LONG).show();
            }
            */
        }
    }
    public void sign(View v)
    {
        Intent r= new Intent(this, Homepage.class);
        startActivity(r);
    }
    public void sign1(View view)
    {
        Intent y= new Intent(this,PutBillDetail.class);
        startActivity(y);
    }
    public void Add(View v)
    {
        intent = new Intent(this,VerifierNewConnection.class);
        startActivity(intent);
    }
}
