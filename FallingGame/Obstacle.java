import java.awt.Rectangle;
public class Obstacle extends GameObject
{
    private int mySpeed = 10;
    private final int GAME_WIDTH;
    public Obstacle(int x, int y, String imageFile, int gameWidth)
    {
        super(x, y, imageFile);
        GAME_WIDTH = gameWidth;
    }
    public int getSpeed()
    {
        return mySpeed; 
    }
    public void updateSpeed(int speed)
    {
        mySpeed = speed;
    }
    public void move()
    {
        setY(myY -= mySpeed);
    }
}
