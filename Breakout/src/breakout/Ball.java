package breakout;

import java.awt.Graphics;

public class Ball extends Sprite {

    private int xVelocity = 1, yVelocity = -1;

    // Constructor
    public Ball() {
    	/* Settings
         * Size of the ball w\ BALL_WIDTH and BALL_HEIGHT
         */
        setWidth(Settings.BALL_WIDTH);
        setHeight(Settings.BALL_HEIGHT);
        
        resetPosition();
    }

    // Resets the ball to its initial position w\ INITIAL_BALL_X/Y
    public void resetPosition() {
        setX(Settings.INITIAL_BALL_X);
        setY(Settings.INITIAL_BALL_Y);
    }

    public void update() {
        x += xVelocity;
        y += yVelocity;

        // Bounce off left side of screen, x set to 0 so it does not leave the screen
        if (x <= 0) {
            x = 0;
            // Change the x velocity to make the ball go right
            xVelocity = -xVelocity;
        }

        // Bounce off right side of screen
        if (x >= Settings.WINDOW_WIDTH - Settings.BALL_WIDTH) {
            // Set x to the right edge of the screen
            x = Settings.WINDOW_WIDTH - Settings.BALL_WIDTH;
            // Change the x velocity to make the ball go left
            xVelocity = -xVelocity;
        }

        // Bounce off top of screen, y set to 0 so it does not leave the screen
        if (y <= 0) {
            y = 0;
            // Change the y velocity to make the ball go downward
            yVelocity = -yVelocity;
        }
    }

    public void setXVelocity(int x) {
        xVelocity = x;
    }

    public void setYVelocity(int y) {
        yVelocity = y;
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void paint(Graphics g) {
        g.fillOval(x, y, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
    }
}
