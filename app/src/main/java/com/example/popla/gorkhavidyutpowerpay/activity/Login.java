package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.Power;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.User;

import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        insertDataIntoDb();
        getUserDATA();
    }

    private void getUserDATA() {
        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();
        List<User> list = daoSession.getUserDao().loadAll();
        Log.i("RESULT", list.get(0).getEmail());
        Toast.makeText(this,  list.get(0).getEmail().toString(), Toast.LENGTH_LONG).show();
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

    Intent intent;
    public void SignIn(View view)
    {
        intent =new Intent(this,EmployeRegistration.class);
        startActivity(intent);
    }
    public void sign(View view)
    {
        intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}
