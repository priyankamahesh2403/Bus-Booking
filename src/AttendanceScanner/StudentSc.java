/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AttendanceScanner;

 import java.sql.*;
/**
 *
 * @author PRIYANKA M
 */
public class StudentSc extends UserSc{
    public StudentSc(String name) {
        super(name);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empcrud",
                "root",
                "Priyanka@15"
        );
    }

    public void markattendanceSc(String subject, String status) {
        String query = "INSERT INTO attendance(name,subject,status,date) VALUES(?,?,?,CURDATE())";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, this.name);
            pst.setString(2, subject);
            pst.setString(3, status);

            pst.executeUpdate();
            System.out.println("Attendance marked for " + this.name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewattendanceSc() {
        String query = "SELECT * FROM attendance";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ID | Name | Subject | Status | Date");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("subject") + " | " +
                        rs.getString("status") + " | " +
                        rs.getDate("date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateattendanceSc(int id, String newStatus) {
        String sql = "UPDATE attendance SET status = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, newStatus);
            pst.setInt(2, id);

            pst.executeUpdate();
            System.out.println("Record ID " + id + " updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleterecord(int id) {
        String sql = "DELETE FROM attendance WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Record ID " + id + " deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
