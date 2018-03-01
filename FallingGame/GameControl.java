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
    /**
     * method drawEnd - draws the ending screen
     */
    public void drawEnd(Graphics g, int score)
    {
        g.setColor(Color.WHITE);
        g.fillRect(50, 200, 300, 300);
        g.setColor(Color.BLACK); 
        g.drawString("Game Over!", 100, 300); 
        g.drawString("Your score -  " + score, 100, 350);
        g.drawString("Click to restart", 100, 400);
    }
    /**
     * method addAction - adds new action to the action map for move command
     * 
     * @param name - name of Action
     * @param deltaX - how fast it moves the player
     * @param keyCode - key to bind Action to
     */
    public void addAction(String name, int deltaX, int keyCode)
    {
        MoveAction moveAction = new MoveAction(name, deltaX, keyCode); 
        //assign action to input and actionmaps
        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), name);
        getActionMap().put(name, moveAction);
    } 
    /**
     * class moveAction - class for action objects created by GameControl
     *
     * @author Alan Wang
     * @version 022318
     */
    private class MoveAction extends AbstractAction implements ActionListener
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
        public MoveAction(String name, int deltaX, int keyCode)
        {
            super(name); //create abstractAction with name
            myDeltaX = deltaX;
        }
        //called whenever key is pressed
        public void actionPerformed(ActionEvent e)
        {
            myPlayer.move(myDeltaX);
        }
    }
}
