/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Attendance;

import java.sql.*;
public class Student extends User{
    public Student(String name){ 
        super (name);}
    public void markattendance(String subject, String status){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud","root","Priyanka@15");
            String query="INSERT INTO attendance(name,subject,status,date)"+"VALUES(?,?,?,CURDATE())";
            PreparedStatement pst=conn.prepareStatement(query);
            
            pst.setString(1, this.name);
            pst.setString(2, subject);
            pst.setString(3, status);
            
            pst.executeUpdate();
            
            System.out.println("Attendance marked for "+this.name);
            conn.close();
            
        }
        catch(Exception e){e.printStackTrace();}
        
        
    }
    public void viewattendance(){
            String query="SELECT * FROM attendance";
            try(
                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud","root","Priyanka@15");
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery(query)
                    ){
                System.out.println("ID | Name | Subject | Status | Date");
                while(rs.next()){
                    System.out.println(rs.getInt("id")+ " | "+
                            rs.getString("name")+" | "+
                            rs.getString("status")+" | "+
                            rs.getDate("date"));
            }
            }catch(SQLException e){
                e.printStackTrace();
}
    }
    public void updateattendance(int id, String newStatus){
        String sql="UPDATE aatendance SET status = ? WHERE id =?";
        try(
                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306"+"/empcrud","root","Priyanka@15");
                PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,newStatus);
            pst.setInt(2,id);
            pst.executeUpdate();
            System.out.println("record ID "+id+" updated to "+newStatus);
        }catch(SQLException e){ e.printStackTrace();}
    }
    public void deleterecord(int id){
        String sql="DELETE FROM attendance WHERE id=?";
        try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"empcrud","root","Priyanka@15");
                PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Record ID "+id+" deleted successfully.");
            
        }catch(SQLException e){ e.printStackTrace();
        }
    }
}


/**
 *
 * @author PRIYANKA M
 */
 