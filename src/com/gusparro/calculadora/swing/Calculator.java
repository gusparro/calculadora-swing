package com.gusparro.calculadora.swing;

import com.gusparro.calculadora.swing.components.Display;
import com.gusparro.calculadora.swing.components.Keyboard;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

public class Calculator extends JFrame {
    public Calculator() {
        initLayout();
        buildLayout();
    }

    private void initLayout() {
        setSize(232, 322);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildLayout() {
        setLayout(new BorderLayout());
        add(new Display(), NORTH);
        add(new Keyboard(), CENTER);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
