public class Player extends GameObject
{
    private final int GAME_WIDTH;
    public Player(int x, int y, String imageFile, int gameWidth)
    {
        super(x, y, imageFile);
        GAME_WIDTH = gameWidth;
    }
    public void move(int deltaX)
    {
        //find next position
        //check if it goes out of left side of screen
        int nextX = Math.max(getX() + deltaX, 0);
        //if it touches right side of screen
        if (nextX + getWidth() > GAME_WIDTH)
        {
            //dont let it move further
            nextX = GAME_WIDTH - getWidth(); 
        }
        
        //  Move the component
        setX(nextX);
    }
}
