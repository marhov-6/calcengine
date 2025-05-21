package com.pluralsight.calcengine;

public enum MathOperation {
    ADD('+'),
    SUBSTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private MathOperation (char symbol) {
        this.symbol = symbol;
    }

    private char symbol;

    public char getSymbol() {
        return this.symbol;
    }
}
