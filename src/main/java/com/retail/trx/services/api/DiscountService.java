package com.retail.trx.services.api;

import com.retail.exceptions.DiscountException;
import com.retail.trx.models.enums.ItemTypeEnum;

public interface DiscountService {

    double getDiscountAmount(String userNationalID, ItemTypeEnum itemType, double totalAmount) throws DiscountException;
}
