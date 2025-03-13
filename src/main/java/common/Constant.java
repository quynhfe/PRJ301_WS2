/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author ADMIN
 */
public class Constant {

    public static final String CUSTOMER_ALL_UPDATE = "UPDATE Customer SET firstName = ?, lastName = ?, phoneNo = ?, email = ?, address = ? "
            + "WHERE custID = ?";
    public static final String CUSTOMER_ADD = "INSERT INTO Customer (idNo, firstName, lastName, phoneNo, email, address) VALUES (?, ?, ?, ?, ?,?,?)";
    public static final String ACCOUNT_SELECT_ALL = "SELECT* FROM Account";
    
    public static final String USER_UPDATE_PASSWORD = "UPDATE [User] SET password = ? WHERE userID = ?";
    public static final String USER_SELECT_ALL = "SELECT* FROM [User]";
    public static final String USER_ADD = "INSERT INTO [User] (username, password, role) VALUES (?,?,'customer')";

    public static final String TRANFER_MONEY = "BEGIN TRANSACTION;\n"
            + "UPDATE Account\n"
            + "SET balance = balance - ?\n"
            + "WHERE accountNo = ? AND balance >= ?;\n"
            + "UPDATE Account\n"
            + "SET balance = balance + ?\n"
            + "WHERE accountNo = ?;\n"
            + "INSERT INTO Translog (fromAccount, toAccount, amount, timestamp)\n"
            + "VALUES (?, ?, ?, GETDATE());\n"
            + "COMMIT TRANSACTION;";
    public static final String GET_BALANCE = "SELECT balance FROM Account WHERE accountNo = ?";
    public static final String GET_TRANSACTION = "SELECT * FROM Translog WHERE fromAccount = ? OR toAccount = ? ORDER BY timestamp DESC";
}
