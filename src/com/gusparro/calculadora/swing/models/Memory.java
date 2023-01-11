package com.gusparro.calculadora.swing.models;

public class Memory {

    private static final Memory INSTANCE = new Memory();

    private String currentText = "";

    private Memory() {
    }

    public static Memory getInstance() {
        return INSTANCE;
    }

    public String getCurrentText() {
        return currentText.isBlank() ? "0" : currentText;
    }
}
