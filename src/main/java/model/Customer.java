/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Customer {
//    idNo, firstName, lastName, phoneNo, email, address, initialBalance, password. Customer photo is optional. 
    private String idNo;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String address;
    private double initialBalance;
    private String password;

    public Customer() {
    }

    public Customer(String idNo, String firstName, String lastName, String phoneNo, String email, String address, double initialBalance, String password) {
        this.idNo = idNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.initialBalance = initialBalance;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "Customer{" + "idNo=" + idNo + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo + ", email=" + email + ", address=" + address + ", initialBalance=" + initialBalance + ", password=" + password + '}';
    }

}
