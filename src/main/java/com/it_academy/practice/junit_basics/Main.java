package com.it_academy.practice.junit_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Main program = new Main();
        program.run(System.in);
        program.runWithUndefinedNumber();

    }

    public void run(InputStream source) {
        Scanner sc = new Scanner(source);

        int n1 = Integer.parseInt(sc.next());
        int n2 = Integer.parseInt(sc.next());

        Calculator calculator = new Calculator(n1, n2);

        System.out.println("Plus result: " + calculator.calculate('+'));
        System.out.println("Minus result: " + calculator.calculate('-'));
        System.out.println("Division result: " + calculator.calculate('/'));
        System.out.println("Multiply result: " + calculator.calculate('*'));
        System.out.println("Exponentiation result: " + calculator.calculate('^'));
        System.out.println("Take a root result: " + calculator.calculate('√'));
    }

    public void runWithUndefinedNumber() throws IOException {
        System.out.println("Please, enter numbers in a line with space separator and press enter when finish");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
//        var numbs = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<String> numbersInString = Arrays.asList(input.split(" "));
        List<Integer> numbers = new ArrayList<>();
        for (String numberInString:numbersInString) {
            int number = Integer.parseInt(numberInString);
            numbers.add(number);
        }

        float previousResultPlus = numbers.get(0);
        float previousResultMinus = numbers.get(0);
        float previousResultDivide = numbers.get(0);
        float previousResultMultiply = numbers.get(0);
        float previousResultExponentiation = numbers.get(0);
        float previousResultRoot = numbers.get(0);
        for (int number: numbers.stream().skip(1).collect(Collectors.toList())) {
            previousResultPlus = new Calculator((int) previousResultPlus, number).calculate('+');
            previousResultMinus = new Calculator((int) previousResultMinus, number).calculate('-');
            previousResultDivide = new Calculator((int) previousResultDivide, number).calculate('/');
            previousResultMultiply = new Calculator((int) previousResultMultiply, number).calculate('*');
            previousResultExponentiation = new Calculator((int) previousResultExponentiation, number).calculate('^');
            previousResultRoot = new Calculator((int) previousResultRoot, number).calculate('√');
        }

        System.out.println("Plus result: " + previousResultPlus);
        System.out.println("Minus result: " + previousResultMinus);
        System.out.println("Division result: " + previousResultDivide);
        System.out.println("Multiply result: " + previousResultMultiply);
        System.out.println("Exponentiation result: " + previousResultExponentiation);
        System.out.println("Take a root result: " + previousResultRoot);
    }
}
