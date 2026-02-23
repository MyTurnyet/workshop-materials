package com.workshop.calculator;

/**
 * Basic calculator with arithmetic operations.
 * Note: This class has a bug that you'll fix in Challenge 1!
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Calculates percentage of a value.
     * BUG: This method has a precision issue!
     * Example: percentage(150, 20) should return 30.0 but returns 0.0
     */
    public double percentage(int value, int percent) {
        // BUG: Integer division before multiplication loses precision
        return (value / 100) * percent;
    }
}
