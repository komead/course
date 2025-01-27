package lesson1_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private int fieldSize;
    private int lineLength;
    private char playerFigure;
    private char computerFigure;

    private char[][] field;

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        System.out.println("Введите размер квадратного игрового поля: ");
        setFieldSize(scanner.nextInt());

        if (fieldSize < 3) {
            setFieldSize(3);
            lineLength = 3;
            System.out.println("Размер поля не может быть таким маленьким. Установлен стандартный размер поля.");
        } else {
            lineLength = 4;
        }
        field = new char[fieldSize][fieldSize];
        int stepCounter = 0;
        clearBoard();

        if (random.nextBoolean()) {
            setFigures('x', 'o');
        } else {
            setFigures('o', 'x');
        }
        System.out.println("Вы играете за " + playerFigure);

        char winner;
        while (stepCounter < fieldSize * fieldSize) {
            if (computerFigure == 'o' || stepCounter != 0) {
                computerMove();
                printField(field);
                winner = checkWinner();
                stepCounter++;

                if (winner == computerFigure) {
                    System.out.println("Вы проиграли!");
                    break;
                }
                if (stepCounter == fieldSize * fieldSize) {
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
            if (stepCounter == fieldSize * fieldSize) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public void computerMove() {
        // Сюда будут записываться кол-во фигур игрока, кол-во фигур компьютера, кол-во пробелов, индексы и направления линий
        int[] bestCombination = new int[] {0, 0, 0, 0, 0, 0, 0};
        int[] tempCombination;

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (j < fieldSize - lineLength + 1) {
                    tempCombination = checkCombination(i, j, 0, 1);
                    if (tempCombination != null) {
                        bestCombination = tempCombination;
                    }
                }

                if (i < fieldSize - lineLength + 1) {
                    tempCombination = checkCombination(i, j, 1, 0);
                    if (tempCombination != null) {
                        bestCombination = tempCombination;
                    }
                }

                if (i < fieldSize - lineLength + 1 && j < fieldSize - lineLength + 1) {
                    tempCombination = checkCombination(i, j, 1, 1);
                    if (tempCombination != null) {
                        bestCombination = tempCombination;
                    }
                }

                if (i > lineLength - 2 && j < fieldSize - lineLength + 1) {
                    tempCombination = checkCombination(i, j, -1, 1);
                    if (tempCombination != null) {
                        bestCombination = tempCombination;
                    }
                }
            }
        }

        for (int k = 0; k < lineLength; k++) {
            int i = bestCombination[3] + k * bestCombination[5];
            int j = bestCombination[4] + k * bestCombination[6];

            if (field[i][j] == ' ') {
                field[i][j] = computerFigure;
                break;
            }
        }
    }

    public int[] checkCombination(int i, int j, int iShift, int jShift) {
        int playerFigureCounter = 0;
        int computerFigureCounter = 0;
        int spaceCounter = 0;

        for (int k = 0; k < fieldSize; k++) {
            if (field[i][j] == computerFigure)
                computerFigureCounter++;
            else if (field[i][j] == playerFigure)
                playerFigureCounter++;
            else
                spaceCounter++;

            i += iShift;
            j += jShift;
        }

        if (spaceCounter == 0)
            return null;

        return new int[] {playerFigureCounter, computerFigureCounter, spaceCounter, i - iShift * fieldSize, j - jShift * fieldSize, iShift, jShift};
    }

    public void playerMove(int yPos, int xPos) {
        field[yPos][xPos] = playerFigure;
    }

    public char checkWinner() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if ((j < fieldSize - 2 && field[i][j] == field[i][j + 1] && field[i][j + 1] == field[i][j + 2])
                || (i < fieldSize - 2 && field[i][j] == field[i + 1][j] && field[i + 1][j] == field[i + 2][j])
                || (i < fieldSize - 2 && j < fieldSize - 2 && field[i][j] == field[i + 1][j + 1] && field[i + 1][j + 1] == field[i + 2][j + 2])
                || (i > 1 && j < fieldSize - 2 && field[i][j] == field[i - 1][j + 1] && field[i - 1][j +1] == field[i - 2][j + 2])) {
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
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
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
