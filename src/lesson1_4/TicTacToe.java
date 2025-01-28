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
        setFieldParams(scanner.nextInt());

        if (fieldSize < 3) {
            setFieldParams(3);
            System.out.println("Размер поля не может быть таким маленьким. Установлен стандартный размер поля.");
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
                System.out.println("Компьютер сделал ход:");
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
            } else {
                printField(field);
            }

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
//            printField(field);
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
        // Сюда будут записываться кол-во фигур игрока, кол-во фигур компьютера, индексы первого элемента и направления линий
        int[] bestCombination = new int[] {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (i < fieldSize - lineLength + 1 && j < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, 1, 1);

                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }

                if (i > lineLength - 2 && j < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, -1, 1);

                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }

                if (j < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, 0, 1);

                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }

                if (i < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, 1, 0);

                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }
            }
        }

        setComputerFigureOnBoard(bestCombination);
    }

    public void setComputerFigureOnBoard(int[] bestCombination) {
        for (int k = 0; k < lineLength; k++) {
            int i = bestCombination[2] + k * bestCombination[4];
            int j = bestCombination[3] + k * bestCombination[5];

            if (field[i][j] == ' ') {
                field[i][j] = computerFigure;
                break;
            }
        }
    }

    public int[] checkCombination(int[] best, int i, int j, int iShift, int jShift) {
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
            return best;

        i = i - iShift * fieldSize;
        j = j - jShift * fieldSize;

        if (playerFigureCounter > best[0] || (playerFigureCounter == 0 && spaceCounter == 1)) {
            return new int[] {playerFigureCounter, computerFigureCounter, i, j, iShift, jShift};
        } /*else if (playerFigureCounter == best[0]) {

        }*/
//        return null;
        return best;
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

    public void setFieldParams(int fieldSize) {
        this.fieldSize = fieldSize;

        if (fieldSize > 4) {
            this.lineLength = 4;
        } else {
            this.lineLength = 3;
        }
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
