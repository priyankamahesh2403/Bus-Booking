/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Attendance;

/**
 *
 * @author PRIYANKA M
 */
public class attendance {
    public static void main(String[] args){
        Student s1=new Student("Priyanka");
        s1.markattendance("Java Programming", "Present");
        s1.viewattendance();
        s1.updateattendance(3,"absent");
        s1.deleterecord(3);
    }
}
