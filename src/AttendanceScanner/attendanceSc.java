/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AttendanceScanner;
import java.util.*;

/**
 *
 * @author PRIYANKA M
 */
public class attendanceSc {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        StudentSc s2 = new StudentSc(name);

        int choice;

        do {
            System.out.println("\n------ Attendance Menu ------");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Update Attendance");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    s2.markattendanceSc(subject, status);
                    break;

                case 2:
                    s2.viewattendanceSc();
                    break;

                case 3:
                    System.out.print("Enter Record ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Status: ");
                    String newStatus = sc.nextLine();

                    s2.updateattendanceSc(id, newStatus);
                    break;

                case 4:
                    System.out.print("Enter Record ID to delete: ");
                    int deleteId = sc.nextInt();

                    s2.deleterecord(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
