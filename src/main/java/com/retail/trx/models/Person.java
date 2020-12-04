package com.retail.trx.models;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Person {
    private long id;
    private String Name;
    private Date CreationDate;

    private String nationalID;


    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    @Column(nullable = false)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(nullable = false)
    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    @Column(unique = true)
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
}
