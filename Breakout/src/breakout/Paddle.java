package breakout;

import java.awt.Graphics;

public class Paddle extends Sprite {

    private int xVelocity;

    public Paddle() {
        // Set width & height w\ PADDLE_WIDTH & PADDLE_HEIGHT
        setWidth(Settings.PADDLE_WIDTH);
        setHeight(Settings.PADDLE_HEIGHT);
        resetPosition();
    }

    public void resetPosition() {
        // Set initial x & y position w\  INITIAL_PADDLE_X/Y)
        setX(Settings.INITIAL_PADDLE_X);
        setY(Settings.INITIAL_PADDLE_Y);
    }

    public void update() {
        x += xVelocity;

        // Prevent the paddle from moving outside of the screen
        if (x < 0) {
            x = 0;
        }
        if (x > Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH) {
            x = Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH;
        }
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
    }

    public void setXVelocity(int vel) {
        xVelocity = vel;
    }
}