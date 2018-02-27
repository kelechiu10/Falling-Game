import java.awt.Color;
import javax.swing.JPanel; 
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Graphics;
import javax.swing.KeyStroke;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class GameControl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameControl extends JPanel
{
    // instance variables - replace the example below with your own
    private InputMap inputMap; 
    private ActionMap actionMap;
    private Player myPlayer;
    private int myDeltaX; 
    private List<Obstacle> myObstacles;

    /**
     * Constructor for objects of class GameControl
     * 
     * @param player - Player object to assign keybinds to
     */
    public GameControl(Player player, List<Obstacle> obstacles)
    {
        //assign player and obstacle reference
        myPlayer = player;
        myObstacles = obstacles;
        //assign input and action maps
        setBackground(Color.GRAY);
        inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW); 
        actionMap = getActionMap(); 
    }
    /**
     * method paintComponent - call this to repaint the window whenever a change is made
     */
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //draw Player
        g.drawImage(myPlayer.getImage(), myPlayer.getX(), myPlayer.getY(), this); 
        //draw obstacles
        for(Obstacle obstacle : myObstacles)
        {
            g.drawImage(obstacle.getImage(), obstacle.getX(), obstacle.getY(), this);
        }
        
    }
    public void drawEnd(Graphics g, int score)
    {
        g.drawString("Game Over!", 200, getHeight()/2); 
        g.drawString("Your score -  " + score, 200, getHeight()/2 + 25);
        g.drawString("Click to restart", 200, getHeight()/2 + 50);
    }
    public void addAction(String name, int deltaX, int keyCode)
    {
        new moveAction(name, deltaX, keyCode); 
    }
    public void movePlayer(int deltaX)
    {
        myPlayer.move(deltaX);
    }   
    /**
     * class moveAction - class for action objects created by GameControl
     *
     * @author Alan Wang
     * @version 022318
     */
    private class moveAction extends AbstractAction implements ActionListener
    {
        // instance variables - replace the example below with your own
        private int myDeltaX;
        /**
         * Constructor for objects of class moveAction
         * 
         * @param name - name of action
         * @param deltaX - change in x for Player object
         * @param keyCode -keyCode to bind action to
         */
        public moveAction(String name, int deltaX, int keyCode)
        {
            super(name); //create abstractAction with name
            myDeltaX = deltaX;
            
            //assign action to input and actionmaps
            inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), getValue(NAME));
            actionMap.put(getValue(NAME), this);
        }
        public void actionPerformed(ActionEvent e)
        {
            movePlayer(myDeltaX);
        }
    }
}
