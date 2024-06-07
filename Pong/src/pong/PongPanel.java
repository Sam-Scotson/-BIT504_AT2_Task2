package pong;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private static final int DELAY = 10; // Milliseconds between timer ticks
    private static final Color BACKGROUND_COLOUR = Color.BLACK;
    private final static int TIMER_DELAY = 5;
    private static final int BALL_MOVEMENT_SPEED = 5;
    GameState gameState = GameState.INITIALISING;
    private final static int POINTS_TO_WIN = 3;
    private int player1Score = 0, player2Score = 0;
    private Player gameWinner;
    Ball ball;
    Paddle paddle1, paddle2;

    public PongPanel() {
        setFocusable(true);
        addKeyListener(this);
        setBackground(BACKGROUND_COLOUR);
        Timer timer = new Timer(TIMER_DELAY, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public void createObjects() {
        ball = new Ball(getWidth(), getHeight());
        paddle1 = new Paddle(Player.One, getWidth(), getHeight());
        paddle2 = new Paddle(Player.Two, getWidth(), getHeight());
    }

    private void update() {
        switch(gameState) {
            case INITIALISING: {
                createObjects();
                ball.setXVelocity(BALL_MOVEMENT_SPEED);
                ball.setYVelocity(BALL_MOVEMENT_SPEED);
                gameState = GameState.PLAYING;
                break;
            }
            case PLAYING: {
            	moveObject(paddle1);
            	moveObject(paddle2);
            	moveObject(ball);
            	checkWallBounce();
            	checkPaddleBounce();
            	checkPaddleBounce(player1);
                checkPaddleBounce(player2);
                checkWin();
                break;
            }
            case GAMEOVER: {
                break;
            }
        }
    }

    private void paintScores(Graphics g) {
        int xPadding = 100;
        int yPadding = 100;
        int fontSize = 50;
        Font scoreFont = new Font("Serif", Font.BOLD, fontSize);
        String leftScore = Integer.toString(player1Score);
        String rightScore = Integer.toString(player2Score);
        g.setFont(scoreFont);
        g.drawString(leftScore, xPadding, yPadding);
        g.drawString(rightScore, getWidth() - xPadding, yPadding);
    }
  
    private void drawString() {
		// TODO Auto-generated method stub
		
	}

	@Override
      public void paintComponent(Graphics g) {
          super.paintComponent(g);
          paintDottedLine(g);
          if(gameState != GameState.INITIALISING) {
              paintSprite(g, ball);
              paintSprite(g, paddle1);
              paintSprite(g, paddle2);
              paintScores(g);
          }
      }

    private void paintDottedLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setPaint(Color.WHITE);
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        g2d.dispose();
    }

    private void paintSprite(Graphics g, Sprite sprite) {
        g.setColor(sprite.getColour());
        g.fillRect(sprite.getXPosition(), sprite.getYPosition(), sprite.getWidth(), sprite.getHeight());
    }

    private void moveObject(Sprite sprite) {
        int newX = sprite.getXPosition() + sprite.getXVelocity();
        int newY = sprite.getYPosition() + sprite.getYVelocity();
        sprite.setXPosition(newX, getWidth());
        sprite.setYPosition(newY, getHeight());
    }
    
    private void resetBall() {
    	ball.resetToInitialPosition();
    }
    
    private void checkWallBounce() {
    	if (ball.getXPosition() <= 0 || ball.getXPosition() + ball.getWidth() >= getWidth()) {
    		resetBall();
    	}
    	if (ball.getYPosition() <= 0 || ball.getYPosition() + ball.getHeight() >= getHeight()) {
    		ball.setYVelocity(-ball.getYVelocity());
    	}
    }
    private void checkPaddleBounce() {
      if(ball.getXVelocity() < 0 && ball.getRectangle().intersects(paddle1.getRectangle())) {
          ball.setXVelocity(BALL_MOVEMENT_SPEED);
      }
      if(ball.getXVelocity() > 0 && ball.getRectangle().intersects(paddle2.getRectangle())) {
           ball.setXVelocity(-BALL_MOVEMENT_SPEED);
           }
      }
    
    private void checkWallBounce() {
        if (ball.x <= 0) {
            // Ball has hit the left side of the screen
            ball.xVelocity = -ball.xVelocity;
            addScore(Player.Two);
        } else if (ball.x + ball.width >= gameWidth) {
            // Ball has hit the right side of the screen
            ball.xVelocity = -ball.xVelocity;
            addScore(Player.One);
        }

        if (ball.y <= 0 || ball.y + ball.height >= gameHeight) {
            // Ball has hit the top or bottom of the screen
            ball.yVelocity = -ball.yVelocity;
        }
    }

    private void addScore(Player player) {
        if (player == Player.One) {
            player1Score++;
        } else if (player == Player.Two) {
            player2Score++;
        }
    }

    private void checkWin() {
        if (player1Score >= POINTS_TO_WIN) {
            gameWinner = Player.One;
            gameState = GameState.GameOver;
        } else if (player2Score >= POINTS_TO_WIN) {
            gameWinner = Player.Two;
            gameState = GameState.GameOver;
        }
    }
    	
    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
        public void keyPressed(KeyEvent event) {
            if(event.getKeyCode() == KeyEvent.VK_UP) {
                paddle2.setYVelocity(-1);
           } else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
                paddle2.setYVelocity(1);
            }
        }
    
      @Override
      public void keyReleased(KeyEvent event) {
          if(event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN) {
              paddle2.setYVelocity(0);
          }
      }

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
        repaint();
    }
}