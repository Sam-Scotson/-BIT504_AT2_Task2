package TicTacToe;

/**
 * Enumeration for the different states of the Tic-Tac-Toe game.
 * This enum is used to track the current state of the game.
 * -
 * The possible states are:
 * Playing: Game is currently in progress.
 * Draw: The game has ended in a draw.
 * Cross_won: The game ended with the crosses ('X') player winning.
 * Nought_won: The game has ended with the noughts ('O') player winning.
 */
public enum GameState {
    Playing, 
    Draw,
    Cross_won,
    Nought_won  
}