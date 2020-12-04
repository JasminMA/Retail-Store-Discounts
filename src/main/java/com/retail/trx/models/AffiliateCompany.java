package com.retail.trx.models;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AffiliateCompany")
@NamedQueries({
        @NamedQuery(name = "getAllAffiliateCompanies",
                query = "Select aff.code from AffiliateCompany aff")})
public class AffiliateCompany {
    private long id;
    private String name;
    private String code;

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
