package com.workshop.calculator;

/**
 * Service layer for calculator operations.
 * TODO: Add logging to all methods (Challenge 1)
 */
public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService() {
        this.calculator = new Calculator();
    }

    public int performAddition(int a, int b) {
        // TODO: Add logging here
        return calculator.add(a, b);
    }

    public int performSubtraction(int a, int b) {
        // TODO: Add logging here
        return calculator.subtract(a, b);
    }

    public int performMultiplication(int a, int b) {
        // TODO: Add logging here
        return calculator.multiply(a, b);
    }

    public int performDivision(int a, int b) {
        // TODO: Add logging and error handling here
        return calculator.divide(a, b);
    }

    public double performPercentageCalculation(int value, int percent) {
        // TODO: Add logging here
        return calculator.percentage(value, percent);
    }
}
