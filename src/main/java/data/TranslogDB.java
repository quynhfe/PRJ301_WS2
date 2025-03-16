/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import common.Constant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Translog;

/**
 *
 * @author ADMIN
 */
public class TranslogDB {

    public ArrayList<Translog> getTransaction(Integer fromAccount) {
        ArrayList<Translog> translogs = new ArrayList<>();
        try (PreparedStatement ps = DBContext.getConnection()
                .prepareStatement(Constant.GET_TRANSACTION)) {
            ps.setInt(1, fromAccount);
            ps.setInt(2, fromAccount);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer transID = rs.getInt("transID");
                Integer toAccount = rs.getInt("toAccount");
                double amount = rs.getDouble("amount");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                String message = rs.getNString("message");
                Translog tr = new Translog(transID, fromAccount, toAccount, amount, timestamp, message);
                translogs.add(tr);
            }
            return translogs; 
        } catch (Exception e) {
            System.out.println("Error get All Transaction ");
            e.printStackTrace();
        }
        return translogs; 
    }

    public static void main(String[] args) {
        TranslogDB translogDB = new TranslogDB();
        for (Translog t : translogDB.getTransaction(100000)) {
            System.out.println(t.toString());
        }
    }
}
