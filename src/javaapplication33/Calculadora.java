/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication33;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author enamo
 */
class Calculadora {
    JFrame frame;
    JTextField textField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, sqrtButton, sinButton, cosButton, tanButton, equalsButton;
    private JButton clearButton;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculadora() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 50));
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        sqrtButton = new JButton("√");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        equalsButton = new JButton("=");

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        clearButton = new JButton("C");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));

        panel.add(clearButton);

        for (int i = 1; i < 10; i++) {
            panel.add(numberButtons[i]);
        }

        panel.add(numberButtons[0]);

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(sqrtButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(equalsButton);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        for (JButton button : numberButtons) {
            button.addActionListener(new NumberButtonListener());
        }

        addButton.addActionListener(new OperatorButtonListener());
        subtractButton.addActionListener(new OperatorButtonListener());
        multiplyButton.addActionListener(new OperatorButtonListener());
        divideButton.addActionListener(new OperatorButtonListener());
        sqrtButton.addActionListener(new FunctionButtonListener());
        sinButton.addActionListener(new FunctionButtonListener());
        cosButton.addActionListener(new FunctionButtonListener());
        tanButton.addActionListener(new FunctionButtonListener());
        equalsButton.addActionListener(new EqualsButtonListener());

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
                operator = '\u0000';
            }
        });

        frame.setVisible(true);
    }

    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            textField.setText(textField.getText() + button.getText());
        }
    }

    private class OperatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            num1 = Double.parseDouble(textField.getText());
            operator = button.getText().charAt(0);
            textField.setText("");
        }
    }

    private class FunctionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            double number = Double.parseDouble(textField.getText());
            String buttonText = button.getText();

            if (buttonText.equals("√")) {
                result = Math.sqrt(number);
            } else if (buttonText.equals("sin")) {
                result = Math.sin(Math.toRadians(number));
            } else if (buttonText.equals("cos")) {
                result = Math.cos(Math.toRadians(number));
            } else if (buttonText.equals("tan")) {
                result = Math.tan(Math.toRadians(number));
            }

            textField.setText(String.valueOf(result));
        }
    }

    private class EqualsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
        }
    }
}