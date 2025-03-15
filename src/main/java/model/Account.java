/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Account {

    private Integer accountNo;
    private String  idNo;
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public Account(Integer accountNo, String idNo, double balance) {
        this.accountNo = accountNo;
        this.idNo = idNo;
        this.balance = balance;
    }

    public Account(String idNo, double balance) {
        this.idNo = idNo;
        this.balance = balance;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int provideAccountNo() {
        return 100003 + (new Random()).nextInt(999999 - 100003 + 1);
    }

    @Override
    public String toString() {
        return "Account{" + "accountNo=" + accountNo + ", idNo=" + idNo + ", balance=" + balance;
    }
}
