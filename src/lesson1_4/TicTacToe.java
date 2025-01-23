package lesson1_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private int fieldHeight;
    private int fieldLength;
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
        int stepCounter = 0;
        clearBoard();

        printField(field);

        if (random.nextBoolean()) {
            setFigures('x', 'o');
        } else {
            setFigures('o', 'x');
        }
        System.out.println("Вы играете за " + playerFigure);

        char winner;
        while (stepCounter < fieldLength * fieldLength) {
            if (computerFigure == 'o' || stepCounter != 0) {
                computerMove();
                winner = checkWinner();
                stepCounter++;

                if (winner == computerFigure) {
                    System.out.println("Вы проиграли!");
                    break;
                }
                if (stepCounter == fieldLength * fieldLength) {
                    System.out.println("Ничья");
                    break;
                }
            }

            printField(field);

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
            winner = checkWinner();
            stepCounter++;

            if (winner == playerFigure) {
                System.out.println("Вы победили!");
                break;
            }
            if (stepCounter == fieldLength * fieldLength) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public void computerMove() {
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldLength; j++) {
//                if ((j < fieldLength - 2 && field[i][j] == field[i][j + 1] && field[i][j + 1] == field[i][j + 2])
//                || (i < fieldHeight - 2 && field[i][j] == field[i + 1][j] && field[i + 1][j] == field[i + 2][j])
//                || (i < fieldHeight - 2 && j < fieldLength - 2 && field[i][j] == field[i + 1][j + 1] && field[i + 1][j + 1] == field[i + 2][j + 2])
//                || (i > 1 && j < fieldLength - 2 && field[i][j] == field[i - 1][j + 1] && field[i - 1][j +1] == field[i - 2][j + 2])) {
//                    if (field[i][j] == computerFigure || field[i][j] == playerFigure) {
//
//                    }
//
//                }
            }
        }
    }

    public void playerMove(int yPos, int xPos) {
        field[yPos][xPos] = playerFigure;
    }

    public char checkWinner() {
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldLength; j++) {
                if ((j < fieldLength - 2 && field[i][j] == field[i][j + 1] && field[i][j + 1] == field[i][j + 2])
                || (i < fieldHeight - 2 && field[i][j] == field[i + 1][j] && field[i + 1][j] == field[i + 2][j])
                || (i < fieldHeight - 2 && j < fieldLength - 2 && field[i][j] == field[i + 1][j + 1] && field[i + 1][j + 1] == field[i + 2][j + 2])
                || (i > 1 && j < fieldLength - 2 && field[i][j] == field[i - 1][j + 1] && field[i - 1][j +1] == field[i - 2][j + 2])) {
                    if (field[i][j] == computerFigure || field[i][j] == playerFigure)
                        return field[i][j];
                }
            }
        }

        return ' ';
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
        System.out.print(" ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("   " + i);
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j] + " |");
            }
//            System.out.print("\n   ");
//
//            for (int j = 0; j < arr[i].length * 4 - 1; j++) {
//                System.out.print("—");
//            }
            System.out.println();
        }
        System.out.println();
    }
}
