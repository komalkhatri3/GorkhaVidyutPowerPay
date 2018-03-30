package com.example.popla.gorkhavidyutpowerpay.manager;

import android.content.Context;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.db.Register;
import com.example.popla.gorkhavidyutpowerpay.db.RegisterDao;
import com.example.popla.gorkhavidyutpowerpay.db.User;
import com.example.popla.gorkhavidyutpowerpay.db.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by DELL on 3/30/2018.
 */

public class RegisterManager {
    public static String TAG = RegisterManager.class.getSimpleName();

    public static Register load(Context ctx, long id) {
        return getRegisterDao(ctx).load(id);
    }

    public static List<Register> loadAll(Context ctx) {
        return getRegisterDao(ctx).loadAll();
    }

    public static long count(Context ctx) {
        return getRegisterDao(ctx).count();
    }

    public static void insertOrReplace(Context ctx, Register register) {
        getRegisterDao(ctx).insertOrReplace(register);
    }

    public static void insert(Context ctx, Register register) {
        getRegisterDao(ctx).insert(register);
    }

    private static RegisterDao getRegisterDao(Context c) {
        return ((PowerApplication) c.getApplicationContext()).getDaoSession().getRegisterDao();
    }



}
