package lesson1_4;

public class TicTacToe {
    public static void main(String[] args) {

    }

    public static void printField(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
