package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.Homepage;
import com.example.popla.gorkhavidyutpowerpay.Power;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.Verifier.VerifierNewConnection;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;
import com.example.popla.gorkhavidyutpowerpay.db.Register;
import com.example.popla.gorkhavidyutpowerpay.db.User;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    EditText emailid;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailid =(EditText) findViewById(R.id.UserName) ;
       pass = (EditText)findViewById(R.id.password);

        // insertDataIntoDb();
        //getUserDATA();
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
*/
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
            DaoSession daoSession = ((AppController)getApplication()).getDaoSession();
            List <Register> list= daoSession.getRegisterDao().loadAll();
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
        }
    }
    public void sign(View v)
    {
        Intent r= new Intent(this, Homepage.class);
        startActivity(r);
    }
    public void sign1(View view)
    {
        intent = new Intent(this,VerifierNewConnection.class);
        startActivity(intent);
    }
}
