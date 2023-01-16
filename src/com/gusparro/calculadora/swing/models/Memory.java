package com.gusparro.calculadora.swing.models;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private static final Memory INSTANCE = new Memory();
    private final List<MemoryListener> listeners = new ArrayList<>();

    private String currentText = "";

    private Memory() {
    }

    public static Memory getInstance() {
        return INSTANCE;
    }

    public String getCurrentText() {
        return currentText.isBlank() ? "0" : currentText;
    }

    public void addListener(MemoryListener listener) {
        listeners.add(listener);
    }

    public void processInput(String value) {
        currentText += value;

        listeners.forEach(listener -> listener.updatValue(getCurrentText()));
    }

    public void validateInput(String value) {

    }
}
