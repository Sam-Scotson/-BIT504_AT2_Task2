package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMain extends JPanel implements MouseListener {
    // Constants for game
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final String TITLE = "Tic Tac Toe";
    public static final int CELL_SIZE = 100;
    public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
    public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
    public static final int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public static final int SYMBOL_STROKE_WIDTH = 8;

    // Declare game object variables
    private Board board;
    private GameState currentState;
    private Player currentPlayer;
    private JLabel statusBar;

    /** Constructor to setup the UI and game components on the panel */
    public GameMain() {
        // This JPanel fires a MouseEvent on MouseClicked so add required event listener to 'this'
        this.addMouseListener(this);

        // Setup the status bar (JLabel) to display status message
        statusBar = new JLabel(" ");
        statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
        statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        statusBar.setOpaque(true);
        statusBar.setBackground(Color.LIGHT_GRAY);

        // Layout of the panel is in border layout
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);

        // Account for statusBar height in overall height
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT + 30));

        // Create a new instance of the game "Board" class
        board = new Board();

        // Call the method to initialize the game board
        initGame();
    }

    public static void main(String[] args) {
        // Run GUI code in Event Dispatch thread for thread safety.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create a main window to contain the panel
                JFrame frame = new JFrame(TITLE);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new GameMain());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /** Custom painting codes on this JPanel */
    public void paintComponent(Graphics g) {
        // Fill background and set color to white
        super.paintComponent(g);
        setBackground(Color.WHITE);

        board.paint(g);

        // Set status bar message
        if (currentState == GameState.Playing) {
            statusBar.setForeground(Color.BLACK);
            if (currentPlayer == Player.Cross) {
                statusBar.setText("X's Turn");
            } else {
                statusBar.setText("O's Turn");
            }
        } else if (currentState == GameState.Draw) {
            statusBar.setForeground(Color.RED);
            statusBar.setText("It's a Draw! Click to play again.");
        } else if (currentState == GameState.Cross_won) {
            statusBar.setForeground(Color.RED);
            statusBar.setText("'X' Won! Click to play again.");
        } else if (currentState == GameState.Nought_won) {
            statusBar.setForeground(Color.RED);
            statusBar.setText("'O' Won! Click to play again.");
        }
    }

    /** Initialize the game-board contents and the current status of GameState and Player */
    public void initGame() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                // All cells empty
                board.cells[row][col].content = Player.Empty;
            }
        }
        currentState = GameState.Playing;
        currentPlayer = Player.Cross;
    }

    /**
     * Updates the game state after a player's move.
     * 
     * Checks if the current player has won by placing their symbol in the specified cell.
     * If so, updates the game state to reflect the winner. If no winner, checks for a draw.
     * If neither condition is met, the game state remains as Playing.
     *
     */
    public void updateGame(Player thePlayer, int row, int col) {

        if (board.hasWon(thePlayer, row, col)) {
            if (thePlayer == Player.Cross) {
                currentState = GameState.Cross_won;
            } else {
                currentState = GameState.Nought_won;
            }
        } else if (board.isDraw()) {
            currentState = GameState.Draw;
        }
    }

    /** Event handler for the mouse click on the JPanel. 
     * 	If selected cell is valid and Empty then current player is added to cell content.
     *  UpdateGame is called, which will call the methods to check for winner or Draw. if none then GameState remains playing.
     *  If win or Draw then call is made to method that resets the game board. 
     *  Finally a call is made to refresh the canvas so that new symbol appears
     */
    public void mouseClicked(MouseEvent e) {
        // Get the coordinates of where the click event happened
        int mouseX = e.getX();
        int mouseY = e.getY();
        // Get the row and column clicked
        int rowSelected = mouseY / CELL_SIZE;
        int colSelected = mouseX / CELL_SIZE;

        if (currentState == GameState.Playing) {
            if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0 && colSelected < COLS && board.cells[rowSelected][colSelected].content == Player.Empty) {
                board.cells[rowSelected][colSelected].content = currentPlayer;
                updateGame(currentPlayer, rowSelected, colSelected);
                // Switch player
                if (currentPlayer == Player.Cross) {
                    currentPlayer = Player.Nought;
                } else {
                    currentPlayer = Player.Cross;
                }
            }
        } else {
            // Game over and restart
            initGame();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
