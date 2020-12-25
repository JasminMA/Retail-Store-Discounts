package com.retail.trx.services.impl;

import com.retail.exceptions.DiscountException;
import com.retail.trx.dao.api.AffiliateCompanyDAO;
import com.retail.trx.dao.api.UserDAO;
import com.retail.trx.models.User;
import com.retail.trx.models.enums.ItemTypeEnum;
import com.retail.trx.services.api.DiscountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    private static final Logger logger = LogManager.getLogger(DiscountServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AffiliateCompanyDAO affiliateCompanyDAO;

    @Override
    public double getDiscountAmount(String userId, ItemTypeEnum itemType, double totalAmount) throws DiscountException {
        try {
            long amountAfterApplyingDiscount = 0;
            double totalDiscount = 0.0;
            User user = userDAO.getUserByNationalID(userId);
            if (user == null) {
                throw new DiscountException("User Does Not Exist");
            }
            //The percentage based discounts do not apply on groceries.
            if (ItemTypeEnum.GROCERIES != itemType) {
                //A user can get only one of the percentage based discounts on a bill.
                //1- If the user is an employee of the store, he gets a 30% discount
                if (userDAO.userIsEmployee(userId))
                    totalDiscount = totalAmount * 30 / 100;
                else {
                    //If the user is an affiliate of the store, he gets a 10% discount
                    List<String> affiliateCompanCodeList = affiliateCompanyDAO.getAllAffiliateCompanies();
                    if (affiliateCompanCodeList.contains(user.getCompanyCode())) {
                        totalDiscount = totalAmount * 10 / 100;
                    } else {
                        //If the user has been a customer for over 2 years, he gets a 5% discount.
                        if (isUserRegisterOverYear(2, user.getCreationDate())) {
                            totalDiscount = totalAmount * 5 / 100;
                        }
                    }
                }
            }

            //For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you
            //get $ 45 as a discount).
            if (totalAmount >= 100 ) {
                int discount = (int) (totalAmount/100);
                totalDiscount += (discount % 100) * 5;
            }
            return totalAmount - totalDiscount;
        } catch (Exception exception) {
            throw new DiscountException(exception.getMessage());
        }
    }

    private Boolean isUserRegisterOverYear(int yearNumbers, Date registrationDate) {
        int lastNumberOfYears = -1 * yearNumbers;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, lastNumberOfYears);
        Date lastYear = cal.getTime();
        if (registrationDate.before(lastYear))
            return true;
        return false;
    }
}
