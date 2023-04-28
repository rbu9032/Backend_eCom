package com.rbu.ecp.dto;

import java.util.Objects;

public class PaymentInfo {

    private int amount;
    private String currency;
    private String receiptEmail;

    public PaymentInfo() {
    }

    public PaymentInfo(int amount, String currency, String receiptEmail) {
        this.amount = amount;
        this.currency = currency;
        this.receiptEmail = receiptEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", receiptEmail='" + receiptEmail + '\'' +
                '}';
    }
}
