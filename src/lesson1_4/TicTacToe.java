package lesson1_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private int fieldSize;
    private int lineLength;
    private char playerFigure;
    private char computerFigure;

    private char[][] field;

    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        int stepCounter = 0;

        setFieldParams();
        field = new char[fieldSize][fieldSize];

        clearBoard();
        setFigures();

        while (stepCounter < fieldSize * fieldSize) {
            if (computerFigure == 'o' || stepCounter != 0) {
                computerMove();
                System.out.println("Компьютер сделал ход:");
                printField(field);
                stepCounter++;

                if (checkWinner(stepCounter)) {
                    return;
                }
            } else {
                printField(field);
            }

            int yPos, xPos;
            while (true) {
                System.out.println("Введите координаты выбранной ячейки через пробел  (Номер_строки Номер_столбца): ");
                yPos = scanner.nextInt();
                xPos = scanner.nextInt();

                if (yPos >= fieldSize || xPos >= fieldSize) {
                    System.out.println("Нет такой координаты");
                    continue;
                }

                if (cellIsAvailable(yPos, xPos)) {
                    break;
                }
                System.out.println("Данная ячейка занята!");
            }
            playerMove(yPos, xPos);
            System.out.println("Ваш ход:");
            printField(field);
            stepCounter++;

            if (checkWinner(stepCounter)) {
                return;
            }
        }
    }

    public void computerMove() {
        // Сюда будут записываться кол-во фигур игрока, кол-во фигур компьютера, индексы первого элемента и направления линий
        int[] bestCombination = new int[] {0, 0, 0, 0, 0, 0};

        // Проходимся по полю
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                // Проверяем главную диагональ
                if (i < fieldSize - lineLength + 1 && j < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, 1, 1);

                    // Если осталось поставить только 1 фигуру для победы, то ставим её
                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }

                // Проверяем побочную диагональ
                if (i > lineLength - 2 && j < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, -1, 1);

                    // Если осталось поставить только 1 фигуру для победы, то ставим её
                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }

                // Проверяем горизонтальную линию
                if (j < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, 0, 1);

                    // Если осталось поставить только 1 фигуру для победы, то ставим её
                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }

                // Проверяем вертикальную линию
                if (i < fieldSize - lineLength + 1) {
                    bestCombination = checkCombination(bestCombination, i, j, 1, 0);

                    // Если осталось поставить только 1 фигуру для победы, то ставим её
                    if (bestCombination[0] == 0 && (lineLength - bestCombination[0] - bestCombination[1] == 1)) {
                        setComputerFigureOnBoard(bestCombination);
                        return;
                    }
                }
            }
        }

        setComputerFigureOnBoard(bestCombination);
    }

    // Метод устанавливает фигуру компьютера в первую пустую линию для полученной комбинации
    public void setComputerFigureOnBoard(int[] bestCombination) {
        for (int k = 0; k < lineLength; k++) {
            // Вычисляем индекс текущей ячейки
            int i = bestCombination[2] + k * bestCombination[4];
            int j = bestCombination[3] + k * bestCombination[5];

            if (field[i][j] == ' ') {
                field[i][j] = computerFigure;
                break;
            }
        }
    }

    // Метод вычисляет лучшую комбинацию из полученной и текущей
    public int[] checkCombination(int[] combination, int i, int j, int iShift, int jShift) {
        int playerFigureCounter = 0;
        int computerFigureCounter = 0;
        int spaceCounter = 0;

        // Проходимся по линии и считаем сколько каких фигур в ней есть
        for (int k = 0; k < lineLength; k++) {
            if (field[i][j] == computerFigure)
                computerFigureCounter++;
            else if (field[i][j] == playerFigure)
                playerFigureCounter++;
            else
                spaceCounter++;

            i += iShift;
            j += jShift;
        }

        // Если линия полностью заполнена, то дальше нет смысла проверять
        if (combination != null && spaceCounter == 0)
            return combination;

        i = i - iShift * lineLength;
        j = j - jShift * lineLength;

        if (combination == null) {
            return new int[] {playerFigureCounter, computerFigureCounter, i, j, iShift, jShift};
        }

        if (playerFigureCounter > combination[0] || (playerFigureCounter == 0 && spaceCounter == 1)) {
            return new int[] {playerFigureCounter, computerFigureCounter, i, j, iShift, jShift};
        }

        return combination;
    }

    // Метод устанавливает фигуру игрока в указанную ячейку
    public void playerMove(int yPos, int xPos) {
        field[yPos][xPos] = playerFigure;
    }

    // Метод проверяет есть ли линия с одинаковыми фигурами. Возвращает фигуру победителя или пробел
    public boolean checkWinner(int stepCounter) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                // Проверяем главную диагональ
                if (i < fieldSize - lineLength + 1 && j < fieldSize - lineLength + 1) {
                    int[] combination = checkCombination(null, i, j, 1, 1);

                    if (combination[0] == lineLength || combination[1] == lineLength) {
                        printWinner(combination);
                        return true;
                    }
                }

                // Проверяем побочную диагональ
                if (i > lineLength - 2 && j < fieldSize - lineLength + 1) {
                    int[] combination = checkCombination(null, i, j, -1, 1);

                    if (combination[0] == lineLength || combination[1] == lineLength) {
                        printWinner(combination);
                        return true;
                    }
                }

                // Проверяем горизонтальную линию
                if (j < fieldSize - lineLength + 1) {
                    int[] combination = checkCombination(null, i, j, 0, 1);

                    if (combination[0] == lineLength || combination[1] == lineLength) {
                        printWinner(combination);
                        return true;
                    }
                }

                // Проверяем вертикальную линию
                if (i < fieldSize - lineLength + 1) {
                    int[] combination = checkCombination(null, i, j, 1, 0);

                    if (combination[0] == lineLength || combination[1] == lineLength) {
                        printWinner(combination);
                        return true;
                    }
                }
            }
        }

        if (stepCounter == fieldSize * fieldSize) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    // Метод проверяет комбинацию на победителя
    public void printWinner(int[] combination) {
        if (combination[1] == lineLength)
            System.out.println("Вы проиграли!");
        else if (combination[0] == lineLength)
            System.out.println("Вы победили!");
    }

    // Метод проверяет, является ли выбранная ячейка пустой
    public boolean cellIsAvailable(int yPos, int xPos) {
        return field[yPos][xPos] == ' ';
    }

    // Метод очищает доску
    public void clearBoard() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = ' ';
            }
        }
    }

    // Метод устанавливает размер поля и длину линии, которую нужно собрать для победы
    public void setFieldParams() {
        while (true) {
            System.out.println("""
                    Выберите размер игрового поля:
                    1 - 3x3
                    2 - 4x4
                    3 - 5x5""");
            switch (scanner.nextInt()) {
                case 1:
                    this.fieldSize = 3;
                    lineLength= 3;
                    return;
                case 2:
                    this.fieldSize = 4;
                    lineLength = 3;
                    return;
                case 3:
                    this.fieldSize = 5;
                    lineLength = 4;
                    return;
                default:
                    System.out.print("Нет такого варианта!" );
                    break;
            }
        }
    }

    // Метод устанавливает фигурки для игроков
    public void setFigures() {
        Random random = new Random();

        if (random.nextBoolean()) {
            this.playerFigure = 'x';
            this.computerFigure = 'o';
        } else {
            this.playerFigure = 'o';
            this.computerFigure = 'x';
        }
        System.out.println("Вы играете за " + playerFigure);
    }

    // Метод выводит поле
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
            System.out.println();
        }
        System.out.println();
    }
}
