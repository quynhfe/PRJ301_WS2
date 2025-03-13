/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import common.Constant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDB {

    public boolean updateUserPassword(User u, String password) {
        boolean check = false;
        try (PreparedStatement ps = DBContext
                .getConnection()
                .prepareStatement(Constant.USER_UPDATE_PASSWORD)) {
            ps.setString(1, password);
            ps.setInt(2, u.getUserID());
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

    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        try (PreparedStatement ps = DBContext.getConnection()
                .prepareStatement(Constant.USER_SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String username = rs.getNString("username");
                String password = rs.getNString("password");
                String role = rs.getNString("role");
                userList.add(new User(username, password, role));
            }
            return userList;
        } catch (Exception e) {
            System.out.println("Error get all account ");
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User c) {
        boolean check = false;
        try (PreparedStatement ps = DBContext
                .getConnection()
                .prepareStatement(Constant.USER_ADD)) {
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
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

    public static void main(String[] args) {
        UserDB accountDB = new UserDB();
        ArrayList<User> accList = accountDB.getAllUser();
        for (User a : accList) {
            System.out.println(a.toString());
        }
        User u = new User("quynh", "123", "customer");
        accountDB.addUser(u);
        for (User a : accList) {
            System.out.println(a.toString());
        }
    }
}
