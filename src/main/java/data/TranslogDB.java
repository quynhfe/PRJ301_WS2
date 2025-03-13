/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import common.Constant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Translog;

/**
 *
 * @author ADMIN
 */
public class TranslogDB {

    public ArrayList<Translog> getTransaction() {
        ArrayList<Translog> translogs = new ArrayList<>();
        try (PreparedStatement ps = DBContext.getConnection()
                .prepareStatement(Constant.GET_TRANSACTION)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String transID = rs.getNString("transID");
                String fromAccount = rs.getNString("fromAccount");
                String toAccount = rs.getNString("toAccount");
                double amount = rs.getDouble("amount");
                String timestamp = rs.getNString("timestamp");
                Translog tr = new Translog(transID, fromAccount, toAccount, amount, timestamp);
                translogs.add(tr);
            }
            return translogs;
        } catch (Exception e) {
            System.out.println("Error Student DAO listAll in ");
            e.printStackTrace();
        }
        return null;
    }
}
