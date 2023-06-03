/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication33;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author enamo
 */
class CalculadoraEspecial extends Calculadora {
    private JButton areaButton, perimeterButton;

    public CalculadoraEspecial() {
        areaButton = new JButton("Area");
        perimeterButton = new JButton("Perimeter");

        JPanel panel = (JPanel) frame.getContentPane().getComponent(1);
        panel.add(areaButton);
        panel.add(perimeterButton);

        areaButton.addActionListener((ActionListener) new AreaButtonListener());
        perimeterButton.addActionListener(new PerimeterButtonListener());
    }

    private class AreaButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double side = Double.parseDouble(textField.getText());
            double area = side * side;
            textField.setText(String.valueOf(area));
        }
    }

    private class PerimeterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double side = Double.parseDouble(textField.getText());
            double perimeter = 4 * side;
            textField.setText(String.valueOf(perimeter));
        }
    }
}