public class Level1_1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 1, b = 2;

        if (a + b >= 10)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 21;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Жёлтый");
        else
            System.out.println("Зелёный");
    }

    public static void compareNumbers() {
        int a = 1, b = 2;

        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }
}
