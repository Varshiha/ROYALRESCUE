import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends Actor
{
    private GreenfootImage image1;
    
    public King(){
        image1 = new GreenfootImage("KingFront.png");
        setImage(image1);
        GreenfootImage King = getImage();
        image1.scale(King.getWidth()/5, King.getHeight()/5);
        setImage(King);
        
    }
    
    /**
     * Act - do whatever the King wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(Knight.class)){

                Greenfoot.setWorld(new GameWin());
            }// Add your action code here.
    }
}
