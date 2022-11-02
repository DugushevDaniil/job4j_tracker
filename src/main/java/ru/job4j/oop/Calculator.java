package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public double sumAllOperation(int y) {
        return divide(y) + minus(y) + sum(y) + multiply(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("sum - " + result);
        result = Calculator.minus(10);
        System.out.println("minus - " + result);
        Calculator calculator = new Calculator();
        double resultDiv = calculator.divide(10);
        System.out.println("divide - " + resultDiv);
        int resultMulti = calculator.multiply(10);
        System.out.println("multiply - " + resultMulti);
        double resultSumAll = calculator.sumAllOperation(10);
        System.out.println("sumAllOperation - " + resultSumAll);
    }
}
