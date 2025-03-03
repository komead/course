package lesson2_2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"12", "3", "dfajk", "1"},
                {"2", "1", "2", "3"},
                {"0", "4", "0", "2"},
                {"3", "36t", "9", "0"}};

        System.out.println("\nResult: " + new Main().sumNumbers(arr));
    }

    public int sumNumbers(String[][] array) {
        if (array == null || array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        int buff;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                buff = 0;
                try {
                    buff = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // !!!!!!!!!!! Можно ли так делать? Взять и проигнорировать NumberFormatException, который мы ловим
                    new MyArrayDataException(i, j, array[i][j]).printStackTrace();
                } finally {
                    sum += buff;
                }
            }
        }

        return sum;
    }
}
