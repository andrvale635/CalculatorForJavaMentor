package CalculatorForJavaMentor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final List<Integer> NUMBERS = new ArrayList<>(2);
    private static String operator;
    private static int answer;
    private static boolean arabian;

    public static void start() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите выражение");
            String expression = br.readLine().toUpperCase();
            Calculator.setNumbers(expression);
            Calculator.setOperator(expression);
            Calculator.compute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (arabian)
            System.out.println("Результат: " + answer);
        else System.out.println("Результат: " + ArabianToRoman.convert(answer));
    }

    public static void setOperator(String expression) {
        String[] characters = expression.split("\\s");
        if (characters[1].matches("[-+/*]"))
            operator = characters[1];
        else throw new IllegalStateException("Вы ввели неверное выражение.");
    }

    public static void setNumbers(String expression) {
        String[] characters = expression.split("\\s");
        try {
            NUMBERS.add(RomanToArabian.convert(characters[0]));
            NUMBERS.add(RomanToArabian.convert(characters[2]));
            arabian = false;
        } catch (IllegalStateException e) {
            NUMBERS.add(Integer.parseInt(characters[0]));
            NUMBERS.add(Integer.parseInt(characters[2]));
            arabian = true;
        }
        for (Integer number : NUMBERS)
            if (number > 10 || number < 0 || characters.length > 3)
                throw new IllegalStateException("Вы ввели неверное выражение.");
    }

    public static void compute() {
        switch (operator) {
            case "+":
                answer = NUMBERS.get(0) + NUMBERS.get(1);
                break;
            case "-":
                answer = NUMBERS.get(0) - NUMBERS.get(1);
                break;
            case "*":
                answer = NUMBERS.get(0) * NUMBERS.get(1);
                break;
            case "/":
                answer = NUMBERS.get(0) / NUMBERS.get(1);
                break;
        }
    }
}


