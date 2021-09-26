package CalculatorForJavaMentor;


public class RomanToArabian {

    public static int convert(String expression) {
        String[] romans = new String[11];
        int counter = 0;

        for (int i = 0; i <= 10; i++)
            romans[i] = ArabianToRoman.convert(i);

        for (String roman : romans) {
            if (roman.equals(expression))
                return counter;
            counter++;
        }
        throw new IllegalStateException();
    }
}
