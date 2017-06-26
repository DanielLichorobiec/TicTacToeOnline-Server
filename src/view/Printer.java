package view;

import model.Game;

/**
 * Created by kornel on 24.06.17.
 */
public class Printer {
    Game game;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String BLINK = "\u001B[4m";


    public void printTable(Game recivedGame) {
        this.game = recivedGame;
        int counter = 0;

        int k = 0;
        System.out.println();
        System.out.println("****************");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (counter == 1) {
                    if (game.getField(k) == 0)
                        System.out.print("|   |");
                    else if (game.getField(k) == 1)
                        System.out.print("|" + ANSI_RED + " X " + ANSI_RESET + "|");
                    else if (game.getField(k) == 2)
                        System.out.print("|" + ANSI_YELLOW + " O " + ANSI_RESET + "|");

                } else {
                    if (game.getField(k) == 0)
                        System.out.print("   ");
                    else if (game.getField(k) == 1)
                        System.out.print(ANSI_RED + " X " + ANSI_RESET);
                    else if (game.getField(k) == 2)
                        System.out.print(ANSI_YELLOW + " O " + ANSI_RESET);
                }
                counter++;
                k++;
            }
            counter = 0;
            if (i != 2) {
                System.out.println("\n" + "---+---+---");
            }
        }
        System.out.println(); //just to make console more readable
    }


    public static void printInfo(Game game) {
        if (game.getWinner().getNumOfPlayer() == 1)
            System.out.println(BLINK + "Player 1 has won" + ANSI_RESET);
        else if (game.getWinner().getNumOfPlayer() == 2)
            System.out.println(BLINK + "Player 2 has won" + ANSI_RESET);
        else
            System.out.println(BLINK + "Draw! Nobody won :(" + ANSI_RESET);
    }

    public void printMessageToPlayerOnConsole(int playerId) {
        if (playerId == 1)
            System.out.print(ANSI_RED + "Player X: " + ANSI_RESET);
        else if (playerId == 2)
            System.out.print(ANSI_YELLOW + "Player O: " + ANSI_RESET);
    }

    public void printSampleGameBoardWithNumbers(int ROWS, int COLS) {
        Integer[] sampleTable = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int i = 0;

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (sampleTable[col] != null) {
                    System.out.print(" " + sampleTable[i] + " ");
                }
                if (col < COLS - 1)
                    System.out.print("|");
                i++;
            }

            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }

    }

    public static void printSampleGameBoardWithoutNumbers(int ROWS, int COLS) {
        String[] sampleTable = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

        int i = 0;

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (sampleTable[col] != null) {
                    System.out.print(" " + sampleTable[i] + " ");
                }
                if (col < COLS - 1)
                    System.out.print("|");
                i++;
            }

            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }

    }
}
