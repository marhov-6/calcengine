package com.pluralsight.calcengine;

public class MathEquation {
    private MathOperation opCode;
    private double leftVal, rightVal, result;

    private static int numberOfCalculations;
    private static double sumOfCalculations;

    public MathEquation() {}

    public MathEquation(MathOperation opCode) {
        this.opCode = opCode;
    }

    public MathEquation(MathOperation opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public String toString() {
        char symbol = this.opCode.getSymbol();
        var builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }

    public void setOpCode(MathOperation opCode) {
        this.opCode = opCode;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    protected void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    protected double getResult() {
        return this.result;
    }

    public static double getAverageResult() {
        return  sumOfCalculations/numberOfCalculations;
    }

    void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this. rightVal = rightVal;
        execute();
    }

    void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this. rightVal = rightVal;
        execute();
        result = (int) result;
    }

    void execute() {
            switch (opCode) {
                case ADD:
                result = this.leftVal + rightVal;
                break;
                case SUBSTRACT:
                result = leftVal - rightVal;
                break;
                case MULTIPLY:
                result = leftVal * rightVal;
                break;
                case DIVIDE:
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode " + opCode);
                result = 0.0d;
        }
            numberOfCalculations++;
            sumOfCalculations += result;
    }
}