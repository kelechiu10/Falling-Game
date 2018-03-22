public class Player extends GameObject
{
    private final int GAME_WIDTH;
    public Player(int x, int y, String imageFile, int gameWidth)
    {
        super(x, y, imageFile);
        GAME_WIDTH = gameWidth;
    }
    /** @overrides image dimensions in game object */
    protected void getImageDimensions()
    {
        myWidth = image.getWidth();
        myHeight = image.getHeight();       
    }
    public void move(int deltaX)
    {
        //find next position
        //check if it goes out of left side of screen
        int nextX = getX() + deltaX;
        //if it touches right side of screen
        if (nextX + myWidth > GAME_WIDTH)
        {
            //dont let it move further
            nextX = 0;
            //nextX = GAME_WIDTH - getWidth(); 
        }
        else //if it touches left
            if (nextX  < 0)
            {
                nextX = GAME_WIDTH - myWidth;
            }
        
        //  Move the component
        setX(nextX);
    }
}
