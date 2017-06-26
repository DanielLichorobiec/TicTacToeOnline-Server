package model;

/**
 * Created by kornel on 25.06.17.
 */
public class PlayerHuman {
    private boolean winner = false;
    private int numOfPlayer;

    public PlayerHuman(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }
}
