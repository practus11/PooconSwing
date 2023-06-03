package javaapplication33;

import javax.swing.SwingUtilities;


public class CalculadoraApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculadora calculadora = new Calculadora();
                CalculadoraEspecial calculadoraEspecial = new CalculadoraEspecial();
            }
        });
    }
}