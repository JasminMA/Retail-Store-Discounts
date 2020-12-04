package com.retail.web.models;

public class BillResponseTransaction extends ResponseTransaction {

    private double totalDiscount;

    BillResponseTransaction() {
    }

    BillResponseTransaction(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(long totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public static BillResponseTransaction buildSuccessResponse(double totalDiscount) {
        BillResponseTransaction billResponseTransaction = new BillResponseTransaction(totalDiscount);
        billResponseTransaction.setStatusCode("0");
        return billResponseTransaction;
    }

    public static BillResponseTransaction buildFailedResponse(Exception exception) {
        BillResponseTransaction billResponseTransaction = new BillResponseTransaction();
        billResponseTransaction.setStatusCode("100");
        billResponseTransaction.setErrorMessage(exception.getMessage());
        return billResponseTransaction;
    }
}
