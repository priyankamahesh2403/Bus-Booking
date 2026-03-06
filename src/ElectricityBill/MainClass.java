/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectricityBill;
import java.util.Scanner;
/**
 *
 * @author PRIYANKA M
 */
public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SubClass bill = new SubClass();

        System.out.print("Enter Meter Number: ");
        bill.setMeterNumber(sc.nextLine());

        System.out.print("Enter Customer Name: ");
        bill.setCustomerName(sc.nextLine());

        System.out.print("Enter Customer Address: ");
        bill.setCustomerAddress(sc.nextLine());

        System.out.print("Enter Last Month Reading: ");
        bill.setLastMonthReading(sc.nextInt());

        System.out.print("Enter Present Month Reading: ");
        bill.setPresentMonthReading(sc.nextInt());

        System.out.print("Enter Category (f/b/h): ");
        bill.setCategory(sc.next().toLowerCase().charAt(0));

        bill.calculateBill();
        bill.displayBill();

        sc.close();
    }
}
    

