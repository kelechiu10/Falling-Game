import javax.swing.JPanel; 
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Graphics;
import javax.swing.KeyStroke;
/**
 * Write a description of class GameControl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameControl extends JPanel
{
    // instance variables - replace the example below with your own
    private Timer timer;
    private InputMap inputMap; 
    private ActionMap actionMap;
    private Player myPlayer;
    private int myDeltaX; 

    /**
     * Constructor for objects of class GameControl
     */
    public GameControl(Player player)
    {
        myPlayer = player;
        inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW); 
        actionMap = getActionMap(); 
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
    }
    public void addAction(String name, int deltaX, int keyCode)
    {
        new moveAction(name, deltaX, keyCode); 
    }
    public void move(int deltaX)
    {
        int newX = myPlayer.getX() + deltaX;
        if(newX + myPlayer.getWidth() > getWidth())
            newX = getWidth() - myPlayer.getWidth();
        myPlayer.setX(newX);
    }   
    /**
     * Write a description of class moveAction here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    private class moveAction extends AbstractAction implements ActionListener
    {
        // instance variables - replace the example below with your own
        private int myDeltaX;
        /**
         * Constructor for objects of class moveAction
         */
        public moveAction(String name, int deltaX, int keyCode)
        {
            super(name);
            myDeltaX = deltaX;
            
            inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), getValue(NAME));
            getActionMap().put(getValue(NAME), this);
        }
        /**
         * An example of a method - replace this comment with your own
         *
         * @param  y  a sample parameter for a method
         * @return    the sum of x and y
         */
        public void actionPerformed(ActionEvent e)
        {
            move(myDeltaX);
        }
    }
}
