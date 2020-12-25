package com.retail.trx.dao.impl;

import com.retail.trx.dao.BaseDAO;
import com.retail.trx.dao.api.UserDAO;
import com.retail.trx.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {
    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    @Override
    public Boolean userIsEmployee(String nationalID) {
        logger.trace("userIsEmployee");
        Session session = sessionFactory.openSession();
        List<User> users = session.getNamedQuery("getEmployeeByNationalID").setParameter("nationalID", nationalID).list();
        session.close();
        logger.info("Employee = " , users);
        return users.size() == 1 ? true : false;
    }

    @Override
    public User getUserByNationalID(String nationalID) {
        logger.trace("getUserByNationalID");
        Session session = sessionFactory.openSession();
        List<User> users = session.getNamedQuery("getUserByNationalID").setParameter("nationalID", nationalID).list();
        session.close();
        if (users.size() == 1)
            return users.get(0);
        else
            return null;
    }
}
