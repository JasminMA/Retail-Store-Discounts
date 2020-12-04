package com.retail.trx.models;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@org.hibernate.annotations.NamedQueries({
        @NamedQuery(name = "getUserByNationalID",
                query = "from User where nationalID = :nationalID")})
public class User extends Person {

    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
