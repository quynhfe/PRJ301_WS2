/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import common.Constant;
import java.sql.PreparedStatement;
import model.Customer;

/**
 *
 * @author ADMIN
 */
public class CustomerDB {
//    + Change password
//+ Update personal information
//+ Transfer money between account
//+ View transaction and activity log 

    public boolean addCustomer(Customer c) {
        boolean check = false;
        try (PreparedStatement ps = DBContext
                .getConnection()
                .prepareStatement(Constant.USER_ADD)) {
            ps.setString(1, c.getIdNo());
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            ps.setString(4, c.getPhoneNo());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getAddress());
            ps.setDouble(7, c.getInitialBalance());
            int result = ps.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("Error add user");
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateCustomer(Customer c) {
        boolean check = false;
        try (PreparedStatement ps = DBContext
                .getConnection()
                .prepareStatement(Constant.CUSTOMER_ALL_UPDATE)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getPhoneNo());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAddress());
            ps.setInt(6, c.getCustID());
            int result = ps.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (Exception e) {
            System.out.println("Error update Customer");
            e.printStackTrace();
        }
        return check;
    }
}
