package com.example.fabrickcontroller.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    private int accountId;
    private String iban;
    private int abiCode;
    private int cabCode;
    private String countryCode;
    private int internationalCin;
    private int account;
    private String alias;
    private String productName;
    private String holderName;
    private String activationDate;
    private String currency;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getAbiCode() {
        return abiCode;
    }

    public void setAbiCode(int abiCode) {
        this.abiCode = abiCode;
    }

    public int getCabCode() {
        return cabCode;
    }

    public void setCabCode(int cabCode) {
        this.cabCode = cabCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getInternationalCin() {
        return internationalCin;
    }

    public void setInternationalCin(int internationalCin) {
        this.internationalCin = internationalCin;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String toString() {
        return "AccountId: " + accountId;
    }
}
