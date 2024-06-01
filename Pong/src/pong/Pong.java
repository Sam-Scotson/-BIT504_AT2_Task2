package pong;

import javax.swing.JFrame;

public class Pong extends JFrame {
    // Define static final variables for the window title, width, and height
    private static final String WINDOW_TITLE = "Pong";
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public Pong() {
        // Use the static final variables instead of magic numbers
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        add(new PongPanel());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {      
    	 
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
          public void run() {
 
                 new Pong();
 
          }
 
        });
 
    }}