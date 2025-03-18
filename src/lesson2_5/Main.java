package lesson2_5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        float[] arr = new float[10];

        Arrays.fill(arr, 1.0f);
        firstMethod(arr);

        Arrays.fill(arr, 1.0f);
        secondMethod(arr);
    }

    private static void firstMethod(float[] arr) {
        long timer = System.currentTimeMillis();

        calculate(arr, 0);

        timer = System.currentTimeMillis() - timer;

        System.out.println("One thread time: " + timer + " ms.");
    }

    private static void secondMethod(float[] arr) {
        float[] arr1 = new float[arr.length / 2];
        float[] arr2 = new float[arr.length / 2];

        long timer = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, arr2, 0, arr.length / 2);

        new Thread(() -> calculate(arr1, 0)).start();
        new Thread(() -> calculate(arr2, arr.length / 2)).start();

        System.arraycopy(arr1, 0, arr, 0, arr.length / 2);
        System.arraycopy(arr2, 0, arr, arr.length / 2, arr.length / 2);

        timer = System.currentTimeMillis() - timer;

        System.out.println("Two thread time: " + timer + " ms.");
    }

    private static void calculate(float[] arr, int startIndex) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + startIndex) / 5f) * Math.cos(0.2f + (i + startIndex) / 5f) * Math.cos(0.4f + (i + startIndex) / 2f));
        }
    }
}
