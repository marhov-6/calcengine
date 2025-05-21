package com.pluralsight.calcengine;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0)
           performCalculations();
        else if (args.length == 1 && args[0].equals("interactive"))
            performInteractively();
        else if (args.length == 3)
            performOperation(args);
         else
            System.out.println("Invalid argument(s) or number of arguments");
    }

    private static void performCalculations() {
        var equations = new MathEquation[4];
        equations[0] = new MathEquation(MathOperation.DIVIDE,100.0d,50.0d);
        equations[1] = new MathEquation(MathOperation.ADD,25.0d, 92.0d);
        equations[2] = new MathEquation(MathOperation.SUBSTRACT,225.0d,17.0d);
        equations[3] = new MathEquation(MathOperation.MULTIPLY,11.0d, 3.0d);

        System.out.println(LocalDate.now() + " " + LocalTime.now());
        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println(equation);
        }
        System.out.println("Average sum of calculations " + MathEquation.getAverageResult());

        //useOverLoads();
    }

    private static void useOverLoads() {
        var equationOverload = new MathEquation(MathOperation.DIVIDE);
        equationOverload.execute(9.0d, 4.0d);
        System.out.println("Overload Result = "  + equationOverload.getResult());

        equationOverload.execute(9, 4);
        System.out.println("Overload INT Result = "  + equationOverload.getResult());

    }

     private static void performInteractively() {
        System.out.println("Enter an operation and two numbers");
        var scanner = new Scanner(System.in);
        var userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = valueFromString(parts[1]);
        double rightVal = valueFromString(parts[2]);
        var equation = new MathEquation(opCode, leftVal, rightVal);
        equation.execute();
        System.out.println(equation);
    }

    static double valueFromString(String word){
        String[] numberWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        double value = 0.0d;
        boolean isValueSet = false;

        for (byte index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                isValueSet = true;
                break;
            }
        }
        if (!isValueSet) {
            value = Double.parseDouble(word);
        }
        return value;
    }
}