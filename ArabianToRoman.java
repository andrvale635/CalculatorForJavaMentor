package CalculatorForJavaMentor;

public class ArabianToRoman {

    private static final int MAX_DIVIDER = 1000;
    private static int divider = MAX_DIVIDER;

    public static String convert(int number) {
        if (number == 0)
            return Roman.O.toString();

        StringBuilder sb = new StringBuilder();
        int result = number / divider;
        int integralPart = divider * result;

        if (result > 0) {
            if (result == 4 || result == 9) {
                sb.append(Roman.valueOf(divider)).append(Roman.valueOf(integralPart + divider));
                result -= result;
            }
            if (result >= 5) {
                sb.append(Roman.valueOf(5 * divider));
                result -= 5;
            }
            for (int j = 0; j < result; j++) {
                if (j == 3)
                    break;
                sb.append(Roman.valueOf(divider));
            }
        }

        divider /= 10;
        number -= integralPart;

        if (number != 0)
            sb.append(convert(number));

        divider = MAX_DIVIDER;

        return sb.toString();
    }
}

