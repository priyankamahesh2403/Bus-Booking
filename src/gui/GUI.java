/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author PRIYANKA M
 */
public class GUI {
      public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Sum Calculator");
        frame.setSize(800, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create UI components
        JLabel label1 = new JLabel("Enter First Number:");
        JTextField input1 = new JTextField(10);

        JLabel label2 = new JLabel("Enter Second Number:");
        JTextField input2 = new JTextField(10);

        JButton calculateBtn = new JButton("Calculate Sum");
        JLabel resultLabel = new JLabel("Result: ");

        // Button action
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(input1.getText());
                    double num2 = Double.parseDouble(input2.getText());
                    double sum = num1 + num2;

                    resultLabel.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter valid numbers",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Add components to frame
        frame.add(label1);
        frame.add(input1);
        frame.add(label2);
        frame.add(input2);
        frame.add(calculateBtn);
        frame.add(resultLabel);

        // Show frame
        frame.setVisible(true);
    }
}
