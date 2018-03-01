import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 * class FallingGame - main class for game
 *
 * @author Alan Wang
 * @version 022418
 */
public class FallingGame extends JFrame implements ActionListener, MouseListener
{
    // instance variables - replace the example below with your own
    private final int WIDTH = 400;
    private final int HEIGHT = 800;
    private int score;
    private int ticks; 
    private boolean gameOver = false;
    private GameControl control; 
    private List<Obstacle> obstacles;
    private Timer timer;
    private Player player; 
    /**
     * Constructor for objects of class FallingGame
     */
    public FallingGame()
    {
        player = new Player(150, 100, "playertest.png", WIDTH);
        obstacles = new ArrayList<Obstacle>();
        addObstacles(); 
        
        control = new GameControl(player, obstacles);
        timer = new Timer(20, this); 
        
        //add keybinds
        control.addAction("Left", -2, KeyEvent.VK_LEFT);
        control.addAction("Right", 2, KeyEvent.VK_RIGHT);
        
        //add components
        add(control);
        addMouseListener(this);
        control.addMouseListener(this);
        setTitle("Falling Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
       
        timer.start();    
    }
    //adds a pair of obstacles, 1 per side of window
    public void addObstacles()
    {
       int x, y, random;
       String imageFile; 
        //random sized obstacle on left half of screen
       //obstacle1 coordinates
       x = 50 + ((int)(Math.random() * 50));
       y = 600 + obstacles.size() * 100;
       /*
       random = (int) (Math.random() * 3 + 1);
       switch (random)
       {
           case 1: 
            imageFile = "smallObstacle.png";
            break;
           case 2:
            imageFile = "mediumObstacle.png";
            break;
           case 3:
            imageFile = "bigObstacle.png";
            break;
           default:
            imageFile = "bigObstacle.png";
       }
       */
       Obstacle obstacle1 = new Obstacle(x, y, "smallObstacle.png", WIDTH);
       obstacles.add(obstacle1);
       
       //obstacle2 coordinates
       x = 250 + ((int)(Math.random() * 50));
       y = 600 + obstacles.size() * 100;
       Obstacle obstacle2 = new Obstacle(x, y, "smallObstacle.png", WIDTH); 
       obstacles.add(obstacle2); 
    }
    private void updateObstacles()
    {
        ticks++; 
        for(int i = 0; i < obstacles.size(); i++)
        {
            Obstacle myObstacle = obstacles.get(i);
            if(ticks % 25 == 0 && myObstacle.getSpeed() < 10)
            {
                myObstacle.updateSpeed(myObstacle.getSpeed() + 2);
            }
        }
        for(int i = 0; i < obstacles.size(); i++)
        {
            Obstacle myObstacle = obstacles.get(i);
            //if the obstacle is out of screen
            if(myObstacle.getY() + myObstacle.getHeight() < 0)
            {    
                //remove it and replace with new one
                obstacles.remove(i);
                if(obstacles.size() == 0);
                    addObstacles();
            }
            else
                //move obstacle up
                myObstacle.move(); 
        }
    }
    private void checkCollision()
    {
        Rectangle r1 = player.getBounds(); 
        for(Obstacle obstacle : obstacles) 
        {
            Rectangle r2 = obstacle.getBounds(); 
            //if obstacle touches player
            if(r1.intersects(r2))
            {
                gameOver = true;
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(gameOver)
        {
            //end game + draw end screen
            timer.stop(); 
            control.drawEnd(control.getGraphics(), score);
        }
        else
        {
            //continue with game
            updateObstacles();
            checkCollision();
            score++;
            control.repaint(); 
        }
    }
    public void mouseClicked(MouseEvent e)
    {

    }
    public void mousePressed(MouseEvent e)
    {
        if(gameOver)
        {
            //reset game
            obstacles.clear();
            control.removeAll(); 
            control.updateUI(); 
            score = 0; 
            addObstacles();
            timer.start();
            repaint();
            gameOver = false; 
        }
    }
    public void mouseReleased(MouseEvent e)
    {
        
    }
    public void mouseEntered(MouseEvent e)
    {
        
    }
    public void mouseExited(MouseEvent e)
    {
        
    }
}
