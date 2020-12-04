package com.retail.trx.dao.impl;

import com.retail.trx.dao.BaseDAO;
import com.retail.trx.dao.api.AffiliateCompanyDAO;
import com.retail.trx.models.AffiliateCompany;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AffiliateCompanyDAOImpl extends BaseDAO implements AffiliateCompanyDAO {

    @Override
    public List<String> getAllAffiliateCompanies() {
        Session session = sessionFactory.openSession();
        List<String> affiliateCompanies = session.getNamedQuery("getAllAffiliateCompanies").getResultList();
        session.close();
        return affiliateCompanies;
    }
}
