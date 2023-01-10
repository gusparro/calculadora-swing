package com.gusparro.calculadora.swing;

import javax.swing.*;

public class Calculator extends JFrame {
    public Calculator() {
        setSize(232, 322);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
