package pong;

import java.awt.Color;
import java.awt.Rectangle

public class Sprite {
    private int xPosition, yPosition;
    private int xVelocity, yVelocity;
    private int width, height;
    private int initialXPosition;
    private int initialYPosition;
    private Color colour;

    public void setInitialPosition(int initialX, int initialY) {
        initialXPosition = initialX;
        initialYPosition = initialY;
    }

    public void resetToInitialPosition() {
        setXPosition(initialXPosition);
        setYPosition(initialYPosition);
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setXPosition(int newX, int panelWidth) {
        if (newX >= 0 && newX + width <= panelWidth) {
            xPosition = newX;
        }
    }

    public void setYPosition(int newY, int panelHeight) {
        if (newY >= 0 && newY + height <= panelHeight) {
            yPosition = newY;
        }
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }
    
    public Rectangle getRectangle() {
         return new Rectangle(getXPosition(), getYPosition(), getWidth(), getHeight());
   }
}