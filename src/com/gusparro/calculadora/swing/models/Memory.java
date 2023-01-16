package com.gusparro.calculadora.swing.models;

import java.util.ArrayList;
import java.util.List;

import static com.gusparro.calculadora.swing.models.TypeOfEvent.*;

public class Memory {

    private static final Memory INSTANCE = new Memory();
    private final List<MemoryListener> listeners = new ArrayList<>();

    private String currentText = "";
    private String textBuffer = "";

    private boolean replaceable;

    private TypeOfEvent lastOperation;

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

        if (typeOfEvent == null) {
            return;
        } else if (typeOfEvent == CLEAN) {
            currentText = "";
            textBuffer = "";
            replaceable = false;
            lastOperation = null;
        } else if (typeOfEvent == NUMBER || typeOfEvent == COMMA) {
            currentText = replaceable ? value : currentText + value;
            replaceable = false;
        } else {
            replaceable = true;
            currentText = getResult();
            textBuffer = currentText;
            lastOperation = typeOfEvent;
        }

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
            } else if (",".equals(value) && !currentText.contains(",")) {
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

    public String getResult() {
        if (lastOperation == null || lastOperation == EQUAL)
            return currentText;

        double result = 0.0;
        double currentNumber = Double.parseDouble(currentText.replace(",", "."));
        double numberBuffer = Double.parseDouble(textBuffer.replace(",", "."));

        if (lastOperation == SUM) {
            result = numberBuffer + currentNumber;
        } else if (lastOperation == SUB) {
            result = numberBuffer - currentNumber;
        } else if (lastOperation == MULTI) {
            result = numberBuffer * currentNumber;
        } else if (lastOperation == DIV) {
            result = numberBuffer / currentNumber;
        }

        String resultString = Double.toString(result).replace(".", ",");
        boolean isInteger = resultString.endsWith(",0");

        return isInteger ? resultString.replace(",0", "") : resultString;
    }
}
