package com.example.popla.gorkhavidyutpowerpay;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.popla.gorkhavidyutpowerpay.db.DaoMaster;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by DELL on 3/29/2018.
 */

public class PowerApplication extends Application {
    private DaoSession daoSession;

    public static PowerApplication instance;

    public PowerApplication() {
        instance = this;
    }

    public static PowerApplication getInstance(){
        if(instance == null) {
            synchronized (PowerApplication.class) {
                if (instance == null) {
                    instance = new PowerApplication();
                }
            }
        }
     return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();

    }
    public DaoSession getDaoSession(){
        if(daoSession == null){
            synchronized (PowerApplication.class){
                if(daoSession ==null){
                    createDaoSession();
                }
            }

        }
        return daoSession;
    }

    private void createDaoSession(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }


}
