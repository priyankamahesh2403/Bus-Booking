/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;
import java.sql.*;

/**
 *
 * @author PRIYANKA M
 */
public class BankDAO {
    public void deposit(int accNo, double amount) {
        Connection conn = DBConncetion.getConnection();

        try {
            conn.setAutoCommit(false);

            String updateSQL = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";
            PreparedStatement pstmt1 = conn.prepareStatement(updateSQL);
            pstmt1.setDouble(1, amount);
            pstmt1.setInt(2, accNo);
            pstmt1.executeUpdate();

            String logSQL = "INSERT INTO transactions (acc_no, tran_type, amount) VALUES (?, 'deposit', ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(logSQL);
            pstmt2.setInt(1, accNo);
            pstmt2.setDouble(2, amount);
            pstmt2.executeUpdate();

            conn.commit();
            System.out.println("Deposit successful.");

        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // WITHDRAW
    public void withdraw(int accNo, double amount) {
        Connection conn = DBConncetion.getConnection();

        try {
            conn.setAutoCommit(false);

            String checkSQL = "SELECT balance FROM accounts WHERE acc_no = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
            checkStmt.setInt(1, accNo);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {
                    String updateSQL = "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?";
                    PreparedStatement pstmt1 = conn.prepareStatement(updateSQL);
                    pstmt1.setDouble(1, amount);
                    pstmt1.setInt(2, accNo);
                    pstmt1.executeUpdate();

                    String logSQL = "INSERT INTO transactions (acc_no, tran_type, amount) VALUES (?, 'withdraw', ?)";
                    PreparedStatement pstmt2 = conn.prepareStatement(logSQL);
                    pstmt2.setInt(1, accNo);
                    pstmt2.setDouble(2, amount);
                    pstmt2.executeUpdate();

                    conn.commit();
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Account not found.");
            }

        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // VIEW ACCOUNT
    public void viewAccountDetails(int accNo) {
        String sql =
            "SELECT c.name, a.balance, t.tran_type, t.amount, t.tran_date " +
            "FROM customers c " +
            "JOIN accounts a ON c.cust_id = a.cust_id " +
            "JOIN transactions t ON a.acc_no = t.acc_no " +
            "WHERE a.acc_no = ?";

        try (Connection conn = DBConncetion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accNo);
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;

            while (rs.next()) {
                if (!found) {
                    System.out.println("\n--- Account Statement ---");
                    System.out.println("Customer: " + rs.getString("name"));
                    System.out.println("Balance: " + rs.getDouble("balance"));
                    System.out.println("------------------------");
                    found = true;
                }
                System.out.println(
                    rs.getString("tran_type") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getTimestamp("tran_date")
                );
            }

            if (!found) {
                System.out.println("No records found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
