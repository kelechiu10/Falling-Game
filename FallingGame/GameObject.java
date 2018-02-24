import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
/**
 * Write a description of class GameObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameObject
{
    protected int myX;
    protected int myY; 
    protected int myWidth;
    protected int myHeight;
    protected BufferedImage image;
    protected boolean visible;
    private final int GAME_WIDTH;
    public GameObject(int x, int y, String imageFile, gameWidth)
    {
        myX = x;
        myY = y;
        visible = true;
        GAME_WIDTH = gameWidth;
        loadImage(imageFile);
        getImageDimensions();
    }    
    public int getX() 
    { 
        return myX; 
    }
    public int getY() 
    { 
        return myY; 
    }   
    public int getWidth()
    {
        return myWidth;
    }
    public int getHeight()
    {
        return myHeight;    
    }
    public Rectangle getBounds()
    {
        return new Rectangle(myX, myY, myWidth, myHeight);
    }
    
    public boolean isVisible()
    {
        return visible;
    }
    public void setVisibility(boolean vis)
    {
        visible = vis;
    }
    protected void getImageDimensions()
    {
        myWidth = image.getWidth();
        myHeight = image.getHeight();       
    }
    protected void loadImage(String imageFile)
    {   
        try
        {
            image = ImageIO.read(getClass().getResource(imageFile));
        } catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}

