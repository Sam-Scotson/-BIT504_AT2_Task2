package breakout;

import java.awt.Color;
import javax.swing.JFrame;

public class Breakout extends JFrame {

    static final long serialVersionUID = 1L;

    private BreakoutPanel panel;

    public Breakout() {
        /* Settings
         * Window Title \w WINDOW_NAME
         * Size of the screen w\ WINDOW_WIDTH and WINDOW_HEIGHT
         * Background color w\ WHITE
         */
        setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);

        setTitle(Settings.WINDOW_NAME);

        getContentPane().setBackground(Color.WHITE);
        
        // Set so window is not resizable
        setResizable(false);
        // Set the window to be visible
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new BreakoutPanel(this);
        add(panel);
        
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Breakout();
            }
        });
    }
}
