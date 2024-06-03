package pong;

import java.awt.Color;

public class Paddle extends Sprite {
    private static final Color PADDLE_COLOUR = Color.WHITE;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
    private static final int DISTANCE_FROM_EDGE = 40;

    public Paddle(Player player, int panelWidth, int panelHeight) {
        setColour(PADDLE_COLOUR);
        setWidth(PADDLE_WIDTH);
        setHeight(PADDLE_HEIGHT);

        int initialX;
        int initialY = panelHeight / 2 - (getHeight() / 2);

        if (player == Player.One) {
            initialX = DISTANCE_FROM_EDGE;
        } else {
            initialX = panelWidth - DISTANCE_FROM_EDGE - getWidth();
        }

        setInitialPosition(initialX, initialY);
        resetToInitialPosition();
    }

    // Additional methods specific to Paddle can be added here
}