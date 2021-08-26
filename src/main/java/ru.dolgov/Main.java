package ru.dolgov;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 3;
    public static char EMPETY = '-';
    public static char X = 'X';
    public static char O = '0';
    public static char map[][];
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurman();
            printMap();
            if (isWinCheck(X)) {
                System.out.println("Вы победили");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            pcTurman();
            printMap();
            if (isWinCheck(O)) {
                System.out.println("Вы проиграли");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean isWinCheck(char symb) {
        for (int row = 0; row < SIZE; row++) {
            int counter = 0;
            for (int col = 0; col < SIZE; col++) {
                if (map[row][col] == symb) counter++;
            }
            if (counter == SIZE) {
                return true;
            }
        }
        for (int col = 0; col < SIZE; col++) {
            int counter = 0;
            for (int row = 0; row < SIZE; row++) {
                if (map[row][col] == symb) counter++;
            }
            if (counter == SIZE) {
                return true;
            }
        }

        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                counter++;
            }
            if (counter == SIZE) {
                return true;
            }
        }
        counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][SIZE-1-i] == symb) {
                counter++;
            }
            if (counter == SIZE) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPETY) return false;
            }
        }
        return true;

    }

    public static void pcTurman() {
        int x, y;
        do {
            System.out.println("Введите кординаты в виде 1 3 куда хотите поставить крестик");
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println(x + 1 + " " + y + 1);
        map[x][y] = O;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[x][y] == EMPETY) {
            return true;
        }
        return false;
    }

    public static void humanTurman() {
        int x, y;
        do {
            System.out.println("Введите кординаты в виде 1 3 куда хотите поставить крестик");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = X;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPETY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
