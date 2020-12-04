package com.retail.web.models;

import com.retail.trx.models.enums.ItemTypeEnum;

public class BillRequestTransaction extends RequestTransaction{

    private ItemTypeEnum billItemsType;
    private double totalAmount;

    public ItemTypeEnum getBillItemsType() {
        return billItemsType;
    }

    public void setBillItemsType(ItemTypeEnum billItemsType) {
        this.billItemsType = billItemsType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
