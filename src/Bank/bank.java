/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;
import java.util.Scanner;

/**
 *
 * @author PRIYANKA M
 */
public class bank {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BankDAO bankOps=new BankDAO();
        System.out.println("-------WELCOME TO SECURE BANKING SYSTEM--------");
        while(true){
            System.out.println("\n1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View and Exit");
            System.out.println("4. Choose an option");
            int choice=sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = sc.nextDouble();

                    bankOps.deposit(accNo, depositAmount);
                    bankOps.viewAccountDetails(accNo);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNo1 = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    bankOps.withdraw(accNo1, withdrawAmount);
                    bankOps.viewAccountDetails(accNo1);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNo2 = sc.nextInt();
                    bankOps.viewAccountDetails(accNo2);
                    System.out.println("Thank you for using the banking system!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
    
}
