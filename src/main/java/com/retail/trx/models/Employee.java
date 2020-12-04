package com.retail.trx.models;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@org.hibernate.annotations.NamedQueries({
        @NamedQuery(name = "getEmployeeByNationalID",
                query = "from Employee where nationalID = :nationalID")})
public class Employee extends Person {

}
