package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kornel on 24.06.17.
 */
public class Game {


    private int[][] board;
    private PlayerHuman playerHumanX = new PlayerHuman(1);
    private PlayerHuman playerHumanO = new PlayerHuman(2);
    private PlayerHuman playerDraw = new PlayerHuman(3);
    private List<Integer> listOfUsedDigit = new ArrayList<>(); // store used numbers (numbers of fields)
    private int myCounter = 9; //countdown how many digits was used and is using to
    // find out draw appeared


    //constructor
    public Game(int rows, int cols) {
        this.board = new int[rows][cols];
    }

    //check if number was already used in game and makes
    public boolean makeMove(int chosenField, int player) {
        int numberOfField = 0;
        int chosenFieldTmp = chosenField - 1;

        if (!isFull())
            if (!isSet(chosenField))
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (numberOfField == chosenFieldTmp) {
                            setSign(i, j, player);
                            myCounter--;
                            return true;
                        } else
                            numberOfField++;
                    }
                }
        return false;
    }

    public String parseBoardToString(){
        String stringToReturn = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                stringToReturn += board[i][j];
            }
        }
        return stringToReturn;
    }



    //check if digit is set
    //use list to store used digits
    private boolean isSet(int chosenField) {
        if (listOfUsedDigit.contains(chosenField))
            return true;
        else {
            listOfUsedDigit.add(chosenField);
            return false;
        }
    }

    //check if board is full
    //check list if contains any empty element
    public boolean isFull() {
        if (listOfUsedDigit.contains(0))
            return true;
        else
            return false;

    }

    //sets signs in board,
    private void setSign(int i, int j, int player) {
        if (board[i][j] == 0) {
            if (player == 1)
                board[i][j] = 1;
            else
                board[i][j] = 2;
        }
    }


    //get digit from selected position,
    // use two loop to get field
    public int getField(int numberOfField) {
        int field = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (field == numberOfField) {
                    return board[i][j];
                } else
                    field++;
            }
        }
        return 10;
    }

    //check if game is finished, use simple method to check
    public boolean isDone() {

        //vertically
        if ((board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == 1) ||
                (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == 1) ||
                (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == 1) ||
                (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == 1) ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == 1) ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == 1) ||
                (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == 1) ||
                (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] == 1)) {
            playerHumanX.setWinner(true);
            return true;
        }

        //player 'O'
        //vertically
        else if ((board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == 2) ||
                (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == 2) ||
                (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == 2) ||
                (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == 2) ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == 2) ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == 2) ||
                (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == 2) ||
                (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] == 2)
                ) {
            playerHumanO.setWinner(true);
            return true;
        } else if (myCounter == 0) {
            playerDraw.setWinner(true);
            return true;
        } else
            return false;
    }

    //get winner of play from PlayerHuman class
    public PlayerHuman getWinner() {
        if (playerHumanX.isWinner())
            return playerHumanX;
        else if (playerHumanO.isWinner())
            return playerHumanO;
        else
            return playerDraw;
    }

}