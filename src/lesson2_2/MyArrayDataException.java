package lesson2_2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j, String value) {
        super("Элемент массива не является числом: array[" + i + "][" + j + "] = " + value);
    }
}
