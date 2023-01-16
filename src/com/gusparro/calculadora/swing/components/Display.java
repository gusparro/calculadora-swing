package com.gusparro.calculadora.swing.components;

import com.gusparro.calculadora.swing.models.Memory;
import com.gusparro.calculadora.swing.models.MemoryListener;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.WHITE;
import static java.awt.FlowLayout.RIGHT;
import static java.awt.Font.PLAIN;

public class Display extends JPanel implements MemoryListener {

    private final JLabel label;

    public Display() {
        Memory.getInstance().addListener(this);

        setBackground(new Color(46, 49, 50));
        setPreferredSize(new Dimension(232, 60));
        setLayout(new FlowLayout(RIGHT, 10, 25));

        label = new JLabel(Memory.getInstance().getCurrentText());
        label.setForeground(WHITE);
        label.setFont(new Font("courier", PLAIN, 30));
        add(label);
    }

    @Override
    public void updatValue(String newValue) {
        label.setText(newValue);
    }
}
