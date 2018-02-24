
public class Player extends GameObject
{
    private final int GAME_WIDTH;
    public Player(int x, int y, String imageFile, int windowWidth)
    {
        super(x, y, imageFile);
        GAME_WIDTH = windowWidth;
    }
    public void move(int deltaX)
    {
        int newX = myX + deltaX;
        //if out of game window
        if(newX + myWidth > GAME_WIDTH)
            newX = GAME_WIDTH - myWidth;
            
    }
}
