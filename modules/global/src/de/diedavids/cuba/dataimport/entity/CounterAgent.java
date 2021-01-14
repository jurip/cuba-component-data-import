package de.diedavids.cuba.dataimport.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DDCDI_COUNTER_AGENT")
@Entity(name = "ddcdi_CounterAgent")
public class CounterAgent extends StandardEntity {
    private static final long serialVersionUID = 2948263183166837290L;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}