package lesson1_2;

public class Level1_2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0};
        task1(arr1);
        printArr(arr1);

        int[] arr2 = new int[8];
        task2(arr2);
        printArr(arr2);

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task3(arr3);
        printArr(arr3);

        System.out.println();
        int[][] arr4 = new int[5][5];
        task4(arr4);

        int[] arr5 = {10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task5(arr5);

        int[] arr6 = {1, 1, 2, 2, 3, 4, 5};
        System.out.println("\n" + task6(arr6));
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
            System.out.println();
            for (int j : i)
                System.out.print(j + " ");
        }
    }

    public static void task5(int[] arr) {
        int min = arr[0], max = arr[0];

        for (int number : arr) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        System.out.println("\n\nmin: " + min + " max: " + max);
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

    public static void printArr(int[] arr) {
        System.out.print("\n\nРезультат: ");

        for (int number : arr)
            System.out.print(number + " ");
    }
}
