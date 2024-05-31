package pong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private static final int DELAY = 10; // Milliseconds between timer ticks

    public PongPanel() {
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
    }
}