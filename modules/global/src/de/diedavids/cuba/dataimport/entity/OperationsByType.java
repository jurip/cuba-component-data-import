package de.diedavids.cuba.dataimport.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "operations_by_type")
@Entity(name = "ddcdi_OperationsByType")
public class OperationsByType extends StandardEntity {
    private static final long serialVersionUID = 5437899417829754056L;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "TYPE_")
    private String type;
    @Column(name = "INCOME")
    private String income;

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}