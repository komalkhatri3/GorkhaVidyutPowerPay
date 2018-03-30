package com.example.popla.gorkhavidyutpowerpay.manager;

import android.content.Context;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.db.User;
import com.example.popla.gorkhavidyutpowerpay.db.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by DELL on 3/30/2018.
 */

public class UserManager {
    public static String TAG = UserManager.class.getSimpleName();

    public static User load(Context ctx, long id) {
        return getUserDao(ctx).load(id);
    }

    public static List<User> loadAll(Context ctx) {
        return getUserDao(ctx).loadAll();
    }

    public static long count(Context ctx) {
        return getUserDao(ctx).count();
    }

    public static void insertOrReplace(Context ctx, User user) {
        getUserDao(ctx).insertOrReplace(user);
    }

    private static UserDao getUserDao(Context c) {
        return ((PowerApplication) c.getApplicationContext()).getDaoSession().getUserDao();
    }

    public static User getUserByEmail(Context ctx,String email){
        Query<User> query = getUserDao(ctx).queryBuilder().where(UserDao.Properties.User_email.like(email)).build();
        return query.unique();
    }

    public static User getUserByEmailPassword(Context ctx,String email,String pass){
        Query<User> query = getUserDao(ctx).queryBuilder().where(UserDao.Properties.User_email.like(email), UserDao.Properties.User_password.eq(pass)).build();
        return query.unique();
    }

}
