/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import common.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;
import model.Customer;

/**
 *
 * @author ADMIN
 */
public class AccountDB {

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> accList = new ArrayList<>();
        try (PreparedStatement ps = DBContext.getConnection()
                .prepareStatement(Constant.ACCOUNT_SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int accountNo = rs.getInt("accountNo");
                int custID = rs.getInt("custID");
                double balance = rs.getDouble("balance");
                accList.add(new Account(accountNo, custID, balance));
            }
            return accList;
        } catch (Exception e) {
            System.out.println("Error get all account ");
            e.printStackTrace();
        }
        return null;
    }

    public double getBalance(String accountNo) {
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(Constant.GET_BALANCE)) {
            ps.setString(1, accountNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private boolean transferMoney(double amount, Customer fromCus, Customer toCus) {
        boolean check = false;
        try (PreparedStatement ps = DBContext
                .getConnection()
                .prepareStatement(Constant.TRANFER_MONEY)) {
            ps.setDouble(1, amount);
            ps.setString(2, fromCus.getAccountNo());
            ps.setDouble(3, amount);
            ps.setDouble(4, amount);
            ps.setString(5, toCus.getAccountNo());
            ps.setString(6, fromCus.getAccountNo());
            ps.setString(7, toCus.getAccountNo());
            ps.setDouble(8, amount);
            int result = ps.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("Error transfer money");
            e.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
        AccountDB accountDB = new AccountDB();
        ArrayList<Account> accList = accountDB.getAllAccount();
        for(Account a : accList){
            System.out.println(a.toString());
        }

    }
}
