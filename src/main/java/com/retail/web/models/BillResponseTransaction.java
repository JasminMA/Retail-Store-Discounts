package com.retail.web.models;

public class BillResponseTransaction extends ResponseTransaction {

    private double totalAmountAfterDiscount;

    BillResponseTransaction() {
    }

    BillResponseTransaction(double totalDiscount) {
        this.totalAmountAfterDiscount = totalDiscount;
    }

    public double getTotalAmountAfterDiscount() {
        return totalAmountAfterDiscount;
    }

    public void setTotalAmountAfterDiscount(long totalAmountAfterDiscount) {
        this.totalAmountAfterDiscount = totalAmountAfterDiscount;
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
