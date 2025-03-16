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

    public static final String CUSTOMER_CHANGE_PASSWORD = "UPDATE Customer SET password =? WHERE idNo = ?";
    public static final String CUSTOMER_UPDATE_ALL = "UPDATE Customer SET firstName = ?, lastName = ?, phoneNo = ?, email = ?, address = ?, initialBalance = ?, password =? WHERE idNo = ?";
    public static final String CUSTOMER_ADD = "INSERT INTO Customer (idNo, firstName, lastName, phoneNo, email, address, initialBalance, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String CUSTOMER_SELECT_ALL = "SELECT * FROM Customer";

    public static final String ACCOUNT_SELECT_ALL = "SELECT * FROM Account";
    public static final String ACCOUNT_SELECT_BY_ACCOUNTNO = "SELECT * FROM Account WHERE accountNo= ?";
    public static final String ACCOUNT_ADD = "INSERT INTO Account (idNO, balance) VALUES (?, ?)";

    public static final String TRANSLOG_ADD = "INSERT INTO Translog (fromAccount, toAccount, amount)\n"
            + "VALUES \n"
            + "(?, ?, ?)";
    public static final String TRANSFER_MONEY
        = "BEGIN TRANSACTION;\n"
        + "UPDATE Account SET balance = balance - ? WHERE accountNo = ? AND balance >= ?;\n"
        + "IF @@ROWCOUNT = 0 \n"
        + "BEGIN \n"
        + "   ROLLBACK TRANSACTION;\n"
        + "   RETURN; -- Insufficient balance or account not found\n"
        + "END \n"
        + "UPDATE Account SET balance = balance + ? WHERE accountNo = ?;\n"
        + "INSERT INTO Translog (fromAccount, toAccount, amount, timestamp, message) "
        + "VALUES (?, ?, ?, GETDATE(), ?);\n"
        + "COMMIT TRANSACTION;";

    public static final String GET_BALANCE = "SELECT balance FROM Account WHERE accountNo = ?";
    public static final String GET_TRANSACTION = "SELECT * FROM Translog WHERE fromAccount = ? OR toAccount = ? ORDER BY timestamp DESC";
}
