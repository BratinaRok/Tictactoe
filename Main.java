package tictactoe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        String input = "_________";
        char[][] array = new char[3][3];

        inputCells(input, array);
        int count = 0;

        boolean isOver = false;
        while (!isOver) {
            System.out.println("Enter the coordinates: ");
            int coordinateI = scanner.nextInt();
            int coordinateJ = scanner.nextInt();
            if (coordinateI > 3 || coordinateJ > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (array[coordinateI - 1][coordinateJ - 1] == 'X' || array[coordinateI - 1][coordinateJ - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else if(stateOfGame(input,array)) {
                isOver = true;
            } else if(!stateOfGame(input,array)) {
                inputCoordinates(coordinateI, coordinateJ, array, count);
                stateOfGame(input, array);
                count++;
            }
        }
    }

    public static void inputCells(String input, char[][] array) {

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                array[i][j] = '_';
                count++;
            }

        }

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {

                System.out.print(array[i][j] + " ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();

        }
        System.out.println("---------");
    }


    public static void inputCoordinates(int coordinateI, int coordinateJ, char[][] array, int count) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if ((count % 2) == 0) {
                    array[coordinateI - 1][coordinateJ - 1] = 'X';
                } else {
                    array[coordinateI - 1][coordinateJ - 1] = 'O';
                }
            }

        }


        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {

                System.out.print(array[i][j] + " ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();

        }
        System.out.println("---------");
    }


    public static boolean stateOfGame(String input, char[][] array) {

        int countX = 0;
        int countO = 0;
        boolean isX = false;
        boolean isO = false;
        boolean isDraw = false;


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 'X') {
                    countX++;
                } else if (array[i][j] == 'O') {
                    countO++;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i][0] == 'X' && array[i][1] == 'X' && array[i][2] == 'X') {
                isX = true;
                break;
            } else if (array[i][0] == 'O' && array[i][1] == 'O' && array[i][2] == 'O') {
                isO = true;
                break;
            } else if (array[0][i] == 'X' && array[1][i] == 'X' && array[2][i] == 'X') {
                isX = true;
                break;
            } else if (array[0][i] == 'O' && array[1][i] == 'O' && array[2][i] == 'O') {
                isO = true;
                break;
            } else if (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X') {
                isX = true;
                break;
            } else if (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O') {
                isO = true;
                break;
            } else if (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X') {
                isX = true;
                break;
            } else if (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O') {
                isO = true;
                break;
            } else if ((isX && isO) || (countX > (countO + 1) || countO > (countX + 1))) {
                System.out.println("Impossible");
                break;
            } else if ((countO + countX == 9 && !isX && !isO)) {
                System.out.println("Draw");
                isDraw = true;
            }
        }


        if (isX && !isO) {
            System.out.println("X wins");
        } else if (isO && !isX) {
            System.out.println("O wins");

        }
        return (isO || isX || isDraw);
    }
}
