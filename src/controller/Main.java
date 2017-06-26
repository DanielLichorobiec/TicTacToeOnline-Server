package controller;

import model.Game;
import view.Printer;

import java.util.Scanner;

/**
 * Created by kornel on 24.06.17.
 */
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BLINK = "\u001B[4m";

    public static int playedId = 1;


    public static void main(String[] args) {
        int ROWS = 3;
        int COLS = 3;
        int chosenField;

        Game game = new Game(ROWS, COLS);
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);


        System.out.println(ANSI_RED + "Hello in TicTacToe game!" + ANSI_RESET);
        System.out.println(ANSI_RED + "Here is board with numbers." + ANSI_RESET);
        printer.printSampleGameBoardWithNumbers(ROWS, COLS);

        System.out.println();
        System.out.println(ANSI_CYAN + "Let's start the game!" + ANSI_RESET);
        System.out.println();

        printer.printSampleGameBoardWithoutNumbers(ROWS, COLS);
        while (!game.isDone()) {

            printer.printMessageToPlayerOnConsole(playedId);
            chosenField = scanner.nextInt();

            while (!game.makeMove(chosenField, playedId)) {
                printer.printMessageToPlayerOnConsole(playedId);
                chosenField = scanner.nextInt();
            }

            printer.printTable(game);
            switchPlayer(playedId);

        }
        System.out.println("End of game!");
        printer.printInfo(game);
    }

    public static void switchPlayer(int playerdId) {
        if (playedId == 1)
            playedId = 2;
        else
            playedId = 1;
    }

}
