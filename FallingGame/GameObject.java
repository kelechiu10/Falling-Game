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
    public GameObject(int x, int y, String imageFile)
    {
        myX = x;
        myY = y;
        visible = true;
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
    public void setX(int x)
    {
        myX = x;
    }
    public void setY(int y)
    {
        myY = y;
    }
    public int getWidth()
    {
        return myWidth;
    }
    public int getHeight()
    {
        return myHeight;    
    }
    public BufferedImage getImage()
    {
        return image; 
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int) myX, (int) myY, myWidth, myHeight);
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
