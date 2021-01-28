package de.diedavids.cuba.dataimport.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "годовой_отчет")
@Entity(name = "ddcdi_NewEntity")
public class NewEntity extends StandardEntity {
    private static final long serialVersionUID = 6704305483393063857L;
    @Column(name = "СЧЕТ")
    private String accountNumber;
    @Column(name = "ГОД")
    private String year;

    @Column(name = "КОМПАНИЯ")
    private String company;
    @Column(name = "Наименование")
    private String name;
    @Column(name = "ЗАЧИСЛЕНИЯ")
    private String income;

    @Column(name = "СПИСАНИЯ")
    private String outcome;
    @Column(name = "БАЛАНС")
    private String balanse;
    @Column(name = "конечный_остаток")
    private String konechnyjOstatok;
    @Column(name = "начальный_остаток")
    private String nachalnyjOstatok;
    @Column(name = "БАНК")
    private String bank;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getBalanse() {
        return balanse;
    }

    public void setBalanse(String balanse) {
        this.balanse = balanse;
    }

    public String getKonechnyjOstatok() {
        return konechnyjOstatok;
    }

    public void setKonechnyjOstatok(String konechnyjOstatok) {
        this.konechnyjOstatok = konechnyjOstatok;
    }

    public String getNachalnyjOstatok() {
        return nachalnyjOstatok;
    }

    public void setNachalnyjOstatok(String nachalnyjOstatok) {
        this.nachalnyjOstatok = nachalnyjOstatok;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}