package com.retail.trx.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
    @Autowired
    protected SessionFactory sessionFactory;

}
