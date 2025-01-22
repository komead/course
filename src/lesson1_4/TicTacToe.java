package lesson1_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private int fieldHeight;
    private int fieldLength;
    private int stepCounter;
    private char playerFigure;
    private char computerFigure;

    private char[][] field;

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        System.out.println("Введите размер игрового поля (y x): ");
        setFieldSize(scanner.nextInt(), scanner.nextInt());

        if (fieldLength < 3 || fieldHeight < 3) {
            fieldLength = 3;
            fieldHeight = 3;
            System.out.println("Размер поля не может быть таким маленьким. Установлен стандартный размер поля.");
        }
        field = new char[fieldHeight][fieldLength];
        stepCounter = 0;
        clearBoard();

        if (random.nextBoolean()) {
            setFigures('x', 'o');
        } else {
            setFigures('o', 'x');
        }
        System.out.println("Вы играете за " + playerFigure);

        while (stepCounter < fieldLength * fieldLength) {
            if (computerFigure == 'o' || stepCounter != 0) {
                computerMove();

                if (checkEndGame()) {
                    System.out.println("Вы проиграли!");
                }
            }
            stepCounter++;

            int yPos, xPos;
            while (true) {
                System.out.println("Введите координаты выбранной ячейки: ");
                yPos = scanner.nextInt();
                xPos = scanner.nextInt();

                if (cellIsAvailable(yPos, xPos)) {
                    break;
                }
                System.out.println("Данная ячейка занята!");
            }
            playerMove(yPos, xPos);

            if (checkEndGame()) {
                System.out.println("Вы победили!");
            }
            stepCounter++;
        }
    }

    public void computerMove() {

    }

    public void playerMove(int yPos, int xPos) {
        field[yPos][xPos] = playerFigure;
    }

    public boolean checkEndGame() {
        if (stepCounter == fieldLength * fieldLength) {
            return true;
        }
        return false;
    }

    public boolean cellIsAvailable(int yPos, int xPos) {
        return field[yPos][xPos] == ' ';
    }

    public void clearBoard() {
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldLength; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public void setFieldSize(int fieldHeight, int fieldLength) {
        this.fieldHeight = fieldHeight;
        this.fieldLength = fieldLength;
    }

    public void setFigures(char playerFigure, char computerFigure) {
        this.playerFigure = playerFigure;
        this.computerFigure = computerFigure;
    }

    public void printField(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
