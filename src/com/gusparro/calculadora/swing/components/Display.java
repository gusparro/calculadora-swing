package com.gusparro.calculadora.swing.components;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.WHITE;
import static java.awt.FlowLayout.RIGHT;
import static java.awt.Font.PLAIN;

public class Display extends JPanel {

    private final JLabel label;

    public Display() {
        setBackground(new Color(46, 49, 50));
        setPreferredSize(new Dimension(232, 60));
        setLayout(new FlowLayout(RIGHT, 10, 25));

        label = new JLabel("123");
        label.setForeground(WHITE);
        label.setFont(new Font("courier", PLAIN, 30));
        add(label);
    }
}
