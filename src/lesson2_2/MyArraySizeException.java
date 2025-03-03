package lesson2_2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Неверный размер массива. Размер массива должен быть 4х4. ");
    }
}
