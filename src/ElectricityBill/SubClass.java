/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectricityBill;

/**
 *
 * @author PRIYANKA M
 */
public class SubClass {

    // Encapsulation (private variables)
    private String meterNumber;
    private String customerName;
    private String customerAddress;
    private int lastMonthReading;
    private int presentMonthReading;
    private char category;   // f / b / h
    private int numberOfUnits;
    private double energyUsageRate;
    private double billAmount;

    // Getters and Setters
    public String getMeterNumber() { return meterNumber; }
    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public int getLastMonthReading() { return lastMonthReading; }
    public void setLastMonthReading(int lastMonthReading) { this.lastMonthReading = lastMonthReading; }

    public int getPresentMonthReading() { return presentMonthReading; }
    public void setPresentMonthReading(int presentMonthReading) { this.presentMonthReading = presentMonthReading; }

    public char getCategory() { return category; }
    public void setCategory(char category) { this.category = category; }

    public int getNumberOfUnits() { return numberOfUnits; }

    public double getBillAmount() { return billAmount; }

    // Business Logic
    public void calculateBill() {

        numberOfUnits = presentMonthReading - lastMonthReading;

        switch (category) {

            case 'f':   // Flat
                if (numberOfUnits >= 25000)
                    energyUsageRate = 26.9;
                else if (numberOfUnits >= 23000)
                    energyUsageRate = 24.5;
                else if (numberOfUnits >= 20000)
                    energyUsageRate = 22.1;
                else
                    energyUsageRate = 19;
                break;

            case 'b':   // Business
                if (numberOfUnits > 10000)
                    energyUsageRate = 17.9;
                else if (numberOfUnits >= 7000)
                    energyUsageRate = 15;
                else if (numberOfUnits >= 4000)
                    energyUsageRate = 12.9;
                else
                    energyUsageRate = 10.9;
                break;

            case 'h':   // Home
                if (numberOfUnits > 1000)
                    energyUsageRate = 12;
                else if (numberOfUnits >= 700)
                    energyUsageRate = 7.9;
                else if (numberOfUnits >= 400)
                    energyUsageRate = 4.6;
                else if (numberOfUnits >= 200)
                    energyUsageRate = 2.1;
                else
                    energyUsageRate = 1.5;
                break;

            default:
                System.out.println("Invalid Category");
        }

        billAmount = numberOfUnits * energyUsageRate;
    }

    public void displayBill() {
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Meter Number: " + meterNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + customerAddress);
        System.out.println("Units Consumed: " + numberOfUnits);
        System.out.println("Rate per Unit: ₹" + energyUsageRate);
        System.out.println("Total Bill Amount: ₹" + billAmount);
    }
}
