package com.gusparro.calculadora.swing.components;

import com.gusparro.calculadora.swing.models.Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;

public class Keyboard extends JPanel implements ActionListener {

    public Keyboard() {
        Color DARK_GREY = new Color(68, 68, 68);
        Color LIGHT_GREY = new Color(99, 99, 99);
        Color ORANGE = new Color(242, 163, 60);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        constraints.fill = BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 3;

        addButton("AC", DARK_GREY, constraints, 0, 0);

        constraints.gridwidth = 1;

        addButton("/", ORANGE, constraints, 3, 0);

        addButton("7", LIGHT_GREY, constraints, 0, 1);
        addButton("8", LIGHT_GREY, constraints, 1, 1);
        addButton("9", LIGHT_GREY, constraints, 2, 1);
        addButton("*", ORANGE, constraints, 3, 1);

        addButton("4", LIGHT_GREY, constraints, 0, 2);
        addButton("5", LIGHT_GREY, constraints, 1, 2);
        addButton("6", LIGHT_GREY, constraints, 2, 2);
        addButton("-", ORANGE, constraints, 3, 2);

        addButton("1", LIGHT_GREY, constraints, 0, 3);
        addButton("2", LIGHT_GREY, constraints, 1, 3);
        addButton("3", LIGHT_GREY, constraints, 2, 3);
        addButton("+", ORANGE, constraints, 3, 3);

        constraints.gridwidth = 2;

        addButton("0", LIGHT_GREY, constraints, 0, 4);

        constraints.gridwidth = 1;

        addButton(",", LIGHT_GREY, constraints, 2, 4);
        addButton("=", ORANGE, constraints, 3, 4);
    }

    private void addButton(String text, Color color, GridBagConstraints constraints, int x, int y) {
        Button button = new Button(text, color);
        button.addActionListener(this);

        constraints.gridx = x;
        constraints.gridy = y;

        add(button, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof JButton button)
            Memory.getInstance().processInput(button.getText());
    }

}
