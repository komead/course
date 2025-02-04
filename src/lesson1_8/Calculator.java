package lesson1_8;

import java.util.Arrays;

public class Calculator {
    public static double run(int level, String expression, double x) {
        // Убираем пробелы
        expression = expression.replaceAll("\\s+", "");
        double result = (level == 2 || level == 3) ? 1 : 0;

        char symbol = switch (level) {
            case 0 -> '+';
            case 1 -> '-';
            case 2 -> '*';
            case 3 -> '/';
            default -> ' ';
        };
        // Если символ отсутствует, переходим к следующему уровню
        if (!expression.contains(Character.toString(symbol))) {
            return calculate(expression, x);
        }

        int counter = 1;
        for (int i = 0; i < expression.length(); i++)
            if (expression.charAt(i) == symbol)
                counter++;

        String[] buff = new String[counter];
        Arrays.fill(buff, "");

        int brackets = 0;
        counter = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') brackets++;
            if (c == ')') brackets--;
            if (c == symbol && brackets == 0) {
                counter++;
            } else {
                buff[counter] += c;
            }
        }

        for (int i = 0; i < buff.length; i++) {
            double value = run(level + 1, buff[i], x);
            switch (symbol) {
                case '+':
                    result += value;
                    break;
                case '-':
                    if (i == 0)
                        result = value;
                    else
                        result -= value;
                    break;
                case '*':
                    result *= value;
                    break;
                case '/':
                    if (i == 0)
                        result = value;
                    else
                        result /= value;
                    break;
            }
        }

        return result;
    }

    private static String replaceX(String string, double x) {
        return string.replace("x", Double.toString(x));
    }

    private static double calculate(String string, double x) {
        string = replaceX(string, x);

        if (string.startsWith("sin"))
            return Math.sin(run(0, string.substring(4, string.length() - 1), x));

        if (string.startsWith("cos"))
            return Math.cos(run(0, string.substring(4, string.length() - 1), x));

        if (string.startsWith("tg"))
            return Math.tan(run(0, string.substring(3, string.length() - 1), x));

        if (string.startsWith("ctg"))
            return 1.0 / Math.tan(run(0, string.substring(4, string.length() - 1), x));


        return Double.valueOf(string);
    }
}
