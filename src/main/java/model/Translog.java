/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class Translog {

    private Integer transID;
    private Integer fromAccount;
    private Integer toAccount;
    private double amount;
    private Timestamp timestamp;
    private String message; 

    public Translog() {
    }

    public Translog(Integer transID, Integer fromAccount, Integer toAccount, double amount, Timestamp timestamp, String message) {
        this.transID = transID;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.timestamp = timestamp;
        this.message = message;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Integer getTransID() {
        return transID;
    }

    public void setTransID(Integer transID) {
        this.transID = transID;
    }

    public Integer getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Integer fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Integer getToAccount() {
        return toAccount;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccount = toAccount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Translog{" + "transID=" + transID + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount + ", timestamp=" + timestamp + ", message=" + message + '}';
    }
}