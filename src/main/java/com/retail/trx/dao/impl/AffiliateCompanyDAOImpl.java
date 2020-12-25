package com.retail.trx.dao.impl;

import com.retail.trx.dao.BaseDAO;
import com.retail.trx.dao.api.AffiliateCompanyDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AffiliateCompanyDAOImpl extends BaseDAO implements AffiliateCompanyDAO {
    private static final Logger logger = LogManager.getLogger(AffiliateCompanyDAOImpl.class);
    @Override
    public List<String> getAllAffiliateCompanies() {
        logger.trace("getAllAffiliateCompanies");
        Session session = sessionFactory.openSession();
        List<String> affiliateCompanies = session.getNamedQuery("getAllAffiliateCompanies").getResultList();
        session.close();
        logger.info("affiliateCompanies = ", affiliateCompanies);
        return affiliateCompanies;
    }
}
