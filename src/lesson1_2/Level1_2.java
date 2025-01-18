package lesson1_2;

public class Level1_2 {
    public static void main(String[] args) {
        //Задачи не из методички:
        System.out.println("\nЗадание 1:");
        int[] arr1 = {1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0};
        task1(arr1);
        printArr(arr1);

        System.out.println("\nЗадание 2:");
        int[] arr2 = new int[8];
        task2(arr2);
        printArr(arr2);

        System.out.println("\nЗадание 3:");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task3(arr3);
        printArr(arr3);

        System.out.println("\nЗадание 4:");
        int[][] arr4 = new int[5][5];
        task4(arr4);

        System.out.println("\nЗадание 5:");
        int[] arr5 = {10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task5(arr5);

        System.out.println("\nЗадание 6:");
        int[] arr6 = {1, 1, 2, 2, 3, 4, 5};
        System.out.println(task6(arr6));

        System.out.println("\nЗадание 7:");
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = -3;
        task7(arr7, n);
        printArr(arr7);

        //Задачи из методички:
        System.out.println("\nЗадание 8:");
        int a = 13, b = 3;
        System.out.println(task8(a, b));

        System.out.println("\nЗадание 9:");
        a = -2;
        task9(a);

        System.out.println("\nЗадание 10:");
        a = -1;
        System.out.println(task10(a));

        System.out.println("\nЗадание 11:");
        n = 3;
        String str = "Hello world";
        task11(str, n);

        System.out.println("\nЗадание 12:");
        int year = 2100;
        System.out.println(task12(year));
    }

    //Задания не из методички
    public static void task1(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
    }

    public static void task2(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = i * 3;
    }

    public static void task3(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                arr[i] *= 2;
    }

    public static void task4(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i][i] = 1;

        for (int[] i : arr) {
            for (int j : i)
                System.out.print(j + " ");

            System.out.println();
        }
    }

    public static void task5(int[] arr) {
        int min = arr[0], max = arr[0];

        for (int number : arr) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        System.out.println("min: " + min + " max: " + max);
    }

    public static String task6(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < arr.length; i++)
            sumRight += arr[i];

        for (int i = 0; i < arr.length - 1; i++) {
            sumRight -= arr[i];
            sumLeft += arr[i];
            if (sumLeft == sumRight)
                return "true";
        }
        return "false";
    }

    private static void task7(int[] arr, int shift) {
        int k = shift < 0 ? -1 : 1;                 //коэффициент, который определяет в какую сторону сдвигается массив
        int previousNumber = arr[arr.length - 1];   //число, которое поменяли в предыдущей итерации
        int currentNumber;
        int currentIndex = 0, previousIndex;        //индексы для чисел выше

        //данный цикл сдвигает массив на 1 элемент |shift| раз
        for (int i = 0; i < Math.abs(arr.length * shift); i++) {
            //для первого элемента массива обновляется previousNumber
            if (currentIndex == 0) {
                previousIndex = (arr.length - k) % arr.length;
                previousNumber = arr[previousIndex];
            }
            //сохраняется текущее число, на его место становится предыдущее, текущее становится предыдущим и меняется индекс
            currentNumber = arr[currentIndex];
            arr[currentIndex] = previousNumber;

            previousNumber = currentNumber;

            currentIndex = (arr.length + currentIndex + k) % arr.length;
        }
    }

    //Задачи из методички
    public static boolean task8(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber >= 10 && firstNumber + secondNumber <= 20;
    }

    private static void task9(int number) {
        if (number < 0)
            System.out.println("Отрицательное");
        else
            System.out.println("Положительное");
    }

    private static boolean task10(int number) {
        return number < 0;
    }

    private static void task11(String str, int n) {
        for (int i = 0; i < n; i++)
            System.out.println(str);
    }

    private static boolean task12(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static void printArr(int[] arr) {
        System.out.print("Результат: ");

        for (int number : arr)
            System.out.print(number + " ");

        System.out.println();
    }
}
