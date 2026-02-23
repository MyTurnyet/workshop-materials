package com.workshop.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Calculator class.
 * Some tests are FAILING - you'll fix them in Challenge 1!
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-5, -5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(-25, calculator.multiply(-5, 5));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(-2, calculator.divide(-10, 5));
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    /**
     * FAILING TEST - Fix the percentage() method to make this pass
     */
    @Test
    public void testPercentageCalculation() {
        assertEquals(30.0, calculator.percentage(150, 20), 0.001);
        assertEquals(50.0, calculator.percentage(100, 50), 0.001);
        assertEquals(12.5, calculator.percentage(50, 25), 0.001);
    }

    /**
     * FAILING TEST - Fix to make this pass
     */
    @Test
    public void testPercentageWithLargeNumbers() {
        assertEquals(2000.0, calculator.percentage(20000, 10), 0.001);
    }
}
