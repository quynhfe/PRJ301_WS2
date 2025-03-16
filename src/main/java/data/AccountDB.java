/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import common.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDB {

    public boolean addAccount(Account c) {
        boolean check = false;
        try (PreparedStatement ps = DBContext
                .getConnection()
                .prepareStatement(Constant.ACCOUNT_ADD)) {
            ps.setString(1, c.getIdNo());
            ps.setDouble(2, c.getBalance());
            int result = ps.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("Error add account");
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> accList = new ArrayList<>();
        try (PreparedStatement ps = DBContext.getConnection()
                .prepareStatement(Constant.ACCOUNT_SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer accountNo = rs.getInt("accountNo");
                String idNo = rs.getString("idNo");
                double balance = rs.getDouble("balance");
                accList.add(new Account(accountNo, idNo, balance));
            }
            return accList;
        } catch (Exception e) {
            System.out.println("Error get all account ");
            e.printStackTrace();
        }
        return accList;
    }

    public Account getAccountByAccountNo(Integer accountNo) {
        System.out.println(accountNo);
        ArrayList<Account> aList = getAllAccount();
        for (Account a : aList) {
            if (a.getAccountNo() == accountNo) {
                return a;
            }
        }
        return null;
    }

    public Account getAccountByIdNo(String idNo) {
        for (Account a : getAllAccount()) {
            if (a.getIdNo().equalsIgnoreCase(idNo)) {
                return a;
            }
        }
        return null;
    }

    public double getBalance(Integer accountNo) {
        try (PreparedStatement ps = DBContext.getConnection()
                .prepareStatement(Constant.GET_BALANCE)) {
            ps.setInt(1, accountNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean transferMoney(double amount, Account fromAcc, Account toAcc, String message) {
        boolean check = false;
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(Constant.TRANSFER_MONEY)) {
            ps.setDouble(1, amount);
            ps.setInt(2, fromAcc.getAccountNo());
            ps.setDouble(3, amount);
            ps.setDouble(4, amount);
            ps.setInt(5, toAcc.getAccountNo());
            ps.setInt(6, fromAcc.getAccountNo());
            ps.setInt(7, toAcc.getAccountNo());
            ps.setDouble(8, amount);
            ps.setString(9, message);
            int result = ps.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("Error during money transfer: " + e.getMessage());
            e.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
        AccountDB accountDB = new AccountDB();
        ArrayList<Account> accList = accountDB.getAllAccount();
        for (Account a : accList) {
            System.out.println(a.toString());
        }
        Account a = accountDB.getAccountByAccountNo(100000);
        Account b = accountDB.getAccountByAccountNo(100002);
        System.out.println(accountDB.transferMoney(300, a, b, "quynh"));
        System.out.println("hihi" + accountDB.getAccountByAccountNo(100002));
    }
}
