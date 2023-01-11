package com.gusparro.calculadora.swing.components;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Font.PLAIN;

public class Button extends JButton {

    public Button(String text, Color color) {
        setText(text);
        setOpaque(true);
        setBackground(color);
        setFont(new Font("courier", PLAIN, 25));
        setForeground(WHITE);
        setBorder(BorderFactory.createLineBorder(BLACK));
    }
}
