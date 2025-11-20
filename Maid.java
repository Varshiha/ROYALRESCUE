import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maid extends Actor
{
    private GreenfootImage image1;
    
    public Maid(){
        image1 = new GreenfootImage("Maid1.png");
        setImage(image1);
        GreenfootImage Maid = getImage();
        image1.scale(Maid.getWidth()/3, Maid.getHeight()/3);
        setImage(Maid);
        
    }
    
    /**
     * Act - do whatever the Maid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
