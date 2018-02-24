import java.awt.Rectangle;
public class Obstacle extends GameObject
{
    private int mySpeed = 1;
    public Obstacle(int x, int y, String imageFile, int gameWidth)
    {
        super(x, y, imageFile, gameWidth);
    }
    public void updateSpeed(int speed)
    {
        mySpeed = speed;
    }
    public void move()
    {
        myY += mySpeed;
    }
}
