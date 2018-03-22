package com.example.popla.gorkhavidyutpowerpay.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.popla.gorkhavidyutpowerpay.db.User;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;
import com.example.popla.gorkhavidyutpowerpay.db.Register;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;
import com.example.popla.gorkhavidyutpowerpay.db.Bill_details;

import com.example.popla.gorkhavidyutpowerpay.db.UserDao;
import com.example.popla.gorkhavidyutpowerpay.db.EmployeeDao;
import com.example.popla.gorkhavidyutpowerpay.db.RegisterDao;
import com.example.popla.gorkhavidyutpowerpay.db.New_ConnectionDao;
import com.example.popla.gorkhavidyutpowerpay.db.Bill_detailsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig employeeDaoConfig;
    private final DaoConfig registerDaoConfig;
    private final DaoConfig new_ConnectionDaoConfig;
    private final DaoConfig bill_detailsDaoConfig;

    private final UserDao userDao;
    private final EmployeeDao employeeDao;
    private final RegisterDao registerDao;
    private final New_ConnectionDao new_ConnectionDao;
    private final Bill_detailsDao bill_detailsDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        employeeDaoConfig = daoConfigMap.get(EmployeeDao.class).clone();
        employeeDaoConfig.initIdentityScope(type);

        registerDaoConfig = daoConfigMap.get(RegisterDao.class).clone();
        registerDaoConfig.initIdentityScope(type);

        new_ConnectionDaoConfig = daoConfigMap.get(New_ConnectionDao.class).clone();
        new_ConnectionDaoConfig.initIdentityScope(type);

        bill_detailsDaoConfig = daoConfigMap.get(Bill_detailsDao.class).clone();
        bill_detailsDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        employeeDao = new EmployeeDao(employeeDaoConfig, this);
        registerDao = new RegisterDao(registerDaoConfig, this);
        new_ConnectionDao = new New_ConnectionDao(new_ConnectionDaoConfig, this);
        bill_detailsDao = new Bill_detailsDao(bill_detailsDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Employee.class, employeeDao);
        registerDao(Register.class, registerDao);
        registerDao(New_Connection.class, new_ConnectionDao);
        registerDao(Bill_details.class, bill_detailsDao);
    }

    public void clear() {
        userDaoConfig.clearIdentityScope();
        employeeDaoConfig.clearIdentityScope();
        registerDaoConfig.clearIdentityScope();
        new_ConnectionDaoConfig.clearIdentityScope();
        bill_detailsDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public RegisterDao getRegisterDao() {
        return registerDao;
    }

    public New_ConnectionDao getNew_ConnectionDao() {
        return new_ConnectionDao;
    }

    public Bill_detailsDao getBill_detailsDao() {
        return bill_detailsDao;
    }

}
