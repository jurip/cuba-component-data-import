package de.diedavids.cuba.dataimport.entity;

import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "DDCDI_OPERATION")
@Entity(name = "ddcdi_Operation")
public class Operation extends StandardEntity {
    @Column(name = "PURPOSE_OF_PAYMENT")
    private String purposeOfPayment;
    @Column(name = "INCOME")
    private String income;
    @Column(name = "BANK")
    private String bank;
    @Column(name = "INCOMEG")
    private Double incomeg;
    @Column(name = "NR")
    private String nr;
    @Column(name = "NRG")
    private Integer nrg;
    @Column(name = "TYPE_")
    private String type;
    @Column(name = "OUTCOME")
    private String outcome;
    @Column(name = "COUNTER_AGENT_ACCOUNT_NUMBER")
    private String counterAgentAccountNumber;
    @Column(name = "COUNTER_AGENT_BANK_NAME")
    private String counterAgentBankName;
    @Column(name = "COUNTER_AGENT_BANK_CORR_ACCOUNT")
    private String counterAgentBankCorrAccount;
    @Column(name = "OUTCOMEG")
    private Double outcomeg;
    @Column(name = "COUNTER_AGENT_BANK_BIK")
    private String counterAgentBankBIK;
    @Column(name = "OPERATION_DATE")
    private LocalDate operationDate;
    @Column(name = "COUNTER_AGENT_INN")
    private String counterAgentINN;
    @Column(name = "COUNTER_AGENT")
    private String counterAgent;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "DATE_")
    private LocalDateTime date;
    @Column(name = "DOC_DATE_TEXT")
    private String docDateText;
    @Column(name = "OPERATION_DATE_TEXT")
    private String operationDateText;
    @Column(name = "DOC_NUMBER")
    private String docNumber;
    @Column(name = "OSTATOK")
    private Double ostatok;
    @Column(name = "OSTATOK_TEXT")
    private String ostatokText;
    @Column(name = "OSTATOK_DATE_TEXT")
    private String ostatokDateText;
    private static final long serialVersionUID = 6497785863344811442L;

    public Integer getNrg() {
        return nrg;
    }

    public void setNrg(Integer nrg) {
        this.nrg = nrg;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getOstatokDateText() {
        return ostatokDateText;
    }

    public void setOstatokDateText(String ostatokDateText) {
        this.ostatokDateText = ostatokDateText;
    }

    public String getOstatokText() {
        return ostatokText;
    }

    public void setOstatokText(String ostatokText) {
        this.ostatokText = ostatokText;
    }

    public Double getOstatok() {
        return ostatok;
    }

    public void setOstatok(Double ostatok) {
        this.ostatok = ostatok;
    }

    public Double getOutcomeg() {
        return outcomeg;
    }

    public void setOutcomeg(Double outcomeg) {
        this.outcomeg = outcomeg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getIncomeg() {
        return incomeg;
    }

    public void setIncomeg(Double incomeg) {
        this.incomeg = incomeg;
    }

    public String getOperationDateText() {
        return operationDateText;
    }

    public void setOperationDateText(String operationDateText) {
        this.operationDateText = operationDateText;
    }

    public String getDocDateText() {
        return docDateText;
    }

    public void setDocDateText(String docDateText) {
        this.docDateText = docDateText;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getCounterAgentAccountNumber() {
        return counterAgentAccountNumber;
    }

    public void setCounterAgentAccountNumber(String counterAgentAccountNumber) {
        this.counterAgentAccountNumber = counterAgentAccountNumber;
    }

    public String getCounterAgentBankName() {
        return counterAgentBankName;
    }

    public void setCounterAgentBankName(String counterAgentBankName) {
        this.counterAgentBankName = counterAgentBankName;
    }

    public String getCounterAgentBankCorrAccount() {
        return counterAgentBankCorrAccount;
    }

    public void setCounterAgentBankCorrAccount(String counterAgentBankCorrAccount) {
        this.counterAgentBankCorrAccount = counterAgentBankCorrAccount;
    }

    public String getCounterAgentBankBIK() {
        return counterAgentBankBIK;
    }

    public void setCounterAgentBankBIK(String counterAgentBankBIK) {
        this.counterAgentBankBIK = counterAgentBankBIK;
    }

    public String getCounterAgentINN() {
        return counterAgentINN;
    }

    public void setCounterAgentINN(String counterAgentINN) {
        this.counterAgentINN = counterAgentINN;
    }

    public String getCounterAgent() {
        return counterAgent;
    }

    public void setCounterAgent(String counterAgent) {
        this.counterAgent = counterAgent;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
}