package com.retail.trx.dao.api;

import com.retail.trx.models.User;

public interface UserDAO {

    Boolean userIsEmployee(String nationalID);

    User getUserByNationalID(String nationalID);

}
