import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Actor
{
    private GreenfootImage image1;
    
    public Knight(){
        image1 = new GreenfootImage("KnightFace1.png");
        setImage(image1);
        GreenfootImage Knight = getImage();
        image1.scale(Knight.getWidth()/5, Knight.getHeight()/5);
        setImage(Knight);
        
    }
    /**
     * Act - do whatever the Knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleControls();
    }
    
    public void handleControls(){
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            move(3);
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            move(-3);
        }
    }
}
