package com.retail.trx.dao.impl;

import com.retail.trx.dao.BaseDAO;
import com.retail.trx.dao.api.UserDAO;
import com.retail.trx.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public Boolean userIsEmployee(String nationalID) {
        Session session = sessionFactory.openSession();
        List<User> users = session.getNamedQuery("getEmployeeByNationalID").setParameter("nationalID", nationalID).list();
        session.close();
        return users.size() == 1 ? true : false;
    }

    @Override
    public User getUserByNationalID(String nationalID) {
        Session session = sessionFactory.openSession();
        List<User> users = session.getNamedQuery("getUserByNationalID").setParameter("nationalID", nationalID).list();
        session.close();
        if (users.size() == 1)
            return users.get(0);
        else
            return null;
    }
}
