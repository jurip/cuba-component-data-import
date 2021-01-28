package de.diedavids.cuba.dataimport.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DDCDI_ACCOUNT")
@Entity(name = "ddcdi_Account")
public class Account extends StandardEntity {
    private static final long serialVersionUID = 8725140810067700883L;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "BANK")
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}