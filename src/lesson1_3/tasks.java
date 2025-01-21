package lesson1_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class tasks {
    public static void main(String[] args) {
        // Задачи №1,3,4,6,7,8 делались во втором уроке
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];
        task2(arr);
        print(2, arr);

        int len = 5, initialValue = 1;
        print(5, task5(len, initialValue));

        print(9);
        task9(scanner);

        print(10);
        task10(scanner);

        System.out.println("Введите количество массивов");
        int amount = scanner.nextInt();
        int[][] arrays = new int[amount][];
        for (int i = 0; i < amount; i++) {
            System.out.print("Введите количество элементов массива №" + (i + 1) + ": ");
            int numberOfElements = scanner.nextInt();

            System.out.print("Введите через пробел элементы массива: ");
            arrays[i] = new int[numberOfElements];
            for (int j = 0; j < numberOfElements; j++)
                arrays[i][j] = scanner.nextInt();
        }
        print(11, task11(arrays));

        print(12);
        System.out.print("Введите выражение без пробелов: ");
        task12(0, scanner.next());
    }

    private static void task2(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
    }

    private static int[] task5(int len, int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < len; i++)
            arr[i] = initialValue;

        return arr;
    }

    private static void task9(Scanner scanner) {
        System.out.println("==============================================================================");
        Random random = new Random();
        int number = random.nextInt(9);
        int attempts = 3, answer;

        while (attempts > 0) {
            System.out.println("Угадайте загаданную цифру. Осталось попыток: " + attempts + "\nВедите цифру: ");
            answer = scanner.nextInt();

            if (answer == number)
                System.out.println("Вы угадали число!");
            if (answer == number || attempts == 1) {
                System.out.println("Игра завершена. Повторить игру еще раз? 1 – да / 0 – нет");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        attempts = 3;
                        number = random.nextInt(9);
                        System.out.println("\n\n==============================================================================");
                        continue;
                    default:
                        System.out.println("Нет такого действия!");
                }
            }

            attempts--;
        }
    }

    private static void task10(Scanner scanner) {
        System.out.println("==============================================================================");
        Random random = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[random.nextInt(words.length)];

        while (true) {
            System.out.println("Угадайте загаданное слово: ");
            String answer = scanner.next();

            if (answer.equals(word)) {
                System.out.println("Вы угадали слово!" + "\nИгра закончена");
                break;
            }

            char[] buff = new char[15];
            Arrays.fill(buff, '#');

            for (int i = 0; i < Math.min(answer.length(), word.length()); i++) {
                if (answer.charAt(i) == word.charAt(i))
                    buff[i] = answer.charAt(i);
            }
            System.out.println(String.valueOf(buff));
        }
    }

    private static int[] task11(int[]... arrays) {
        int finalLength = 0;
        for (int[] array : arrays)
            finalLength += array.length;

        int[] result = new int[finalLength];

        int counter = 0;
        for (int[] array : arrays) {
            for (int arr : array) {
                result[counter++] = arr;
            }
        }
        return result;
    }

    private static double task12(int level, String string) {
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
            switch (symbol) {
                case '+':
                    result += calculate(Double.toString(task12(level + 1, buff[i])));
                    break;
                case '-':
                    if (i == 0)
                        result = calculate(Double.toString(task12(level + 1, buff[i])));
                    else
                        result -= calculate(Double.toString(task12(level + 1, buff[i])));
                    break;
                case '*':
                    result *= calculate(Double.toString(task12(level + 1, buff[i])));
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

    public static void print(int taskNumber, int... arr) {
        System.out.println("\nЗадание " + taskNumber + ":");

        if (arr == null || arr.length == 0)
            return;

        System.out.print("Результат: ");
        for (int number : arr)
            System.out.print(number + " ");

        System.out.println();
    }
}
