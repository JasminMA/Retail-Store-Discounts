package com.retail.web.models;

public class RequestTransaction {

    private String userNationalID;
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserNationalID() {
        return userNationalID;
    }

    public void setUserNationalID(String userNationalID) {
        this.userNationalID = userNationalID;
    }
}
