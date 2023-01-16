package com.gusparro.calculadora.swing.models;

import java.util.ArrayList;
import java.util.List;

import static com.gusparro.calculadora.swing.models.TypeOfEvent.*;

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
        TypeOfEvent typeOfEvent = detectTyoeOfEvent(value);
        System.out.println(typeOfEvent);

        currentText += value;

        listeners.forEach(listener -> listener.updatValue(getCurrentText()));
    }

    public TypeOfEvent detectTyoeOfEvent(String value) {
        if (currentText.isBlank() && value.equals("0"))
            return null;

        try {
            Integer.parseInt(value);
            return NUMBER;
        } catch (NumberFormatException exception) {
            if ("AC".equals(value)) {
                return CLEAN;
            } else if (",".equals(value)) {
                return COMMA;
            } else if ("*".equals(value)) {
                return MULTI;
            } else if ("/".equals(value)) {
                return DIV;
            } else if ("+".equals(value)) {
                return SUM;
            } else if ("-".equals(value)) {
                return SUB;
            } else if ("=".equals(value)) {
                return EQUAL;
            }
        }

        return null;
    }
}
