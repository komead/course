package lesson1_8;

import java.util.Arrays;

public class Calculator {
    public static double run(int level, String string, double x) {
        double result = 0;
        int counter = 1;
        char symbol = switch (level) {
            case 0 -> '+';
            case 1 -> '-';
            case 2 -> '*';
            case 3 -> '/';
            default -> ' ';
        };

        if (level == 2 || level == 3)
            result++;

        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) == symbol)
                counter++;

        String[] buff = new String[counter];
        Arrays.fill(buff, "");

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != symbol)
                buff[buff.length - counter] += string.charAt(i);
            else
                counter--;
        }

        for (int i = 0; i < buff.length; i++) {
            buff[i] = replaceX(buff[i], x);
            switch (symbol) {
                case '+':
                    result += calculate(Double.toString(run(level + 1, buff[i], x)));
                    break;
                case '-':
                    if (i == 0)
                        result = calculate(Double.toString(run(level + 1, buff[i], x)));
                    else
                        result -= calculate(Double.toString(run(level + 1, buff[i], x)));
                    break;
                case '*':
                    result *= calculate(Double.toString(run(level + 1, buff[i], x)));
                    break;
                case '/':
                    if (i == 0)
                        result = calculate(buff[i]);
                    else
                        result /= calculate(buff[i]);
                    break;
            }
        }

        return result;
    }

    private static String replaceX(String string, double x) {
        return string.replace("x", Double.toString(x));
    }

    private static double calculate(String string) {
        if (string.startsWith("sin"))
            return Math.sin(Math.toRadians(Double.valueOf(string.substring(4, string.length() - 1))));

        if (string.startsWith("cos"))
            return Math.cos(Math.toRadians(Double.valueOf(string.substring(4, string.length() - 1))));

        if (string.startsWith("tg"))
            return Math.tan(Math.toRadians(Double.valueOf(string.substring(3, string.length() - 1))));

        if (string.startsWith("ctg"))
            return 1.0 / Math.tan(Math.toRadians(Double.valueOf(string.substring(4, string.length() - 1))));

        return Double.valueOf(string);
    }
}
