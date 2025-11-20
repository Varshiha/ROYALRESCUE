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
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    
    public Knight(){
        image1 = new GreenfootImage("KnightFace1.png");
        setImage(image1);
        GreenfootImage Knight = getImage();
        image1.scale(Knight.getWidth()/5, Knight.getHeight()/5);
        setImage(Knight);
        
        image2 = new GreenfootImage("KnightFace2.png");
        setImage(image1);
        GreenfootImage Knight2 = getImage();
        image1.scale(Knight.getWidth()/5, Knight.getHeight()/5);
        setImage(Knight);
        
        image3 = new GreenfootImage("KnightFace1left.png");
        setImage(image1);
        GreenfootImage Knight3 = getImage();
        image1.scale(Knight.getWidth()/5, Knight.getHeight()/5);
        setImage(Knight);
        
        image4 = new GreenfootImage("KnightFace2left.png");
        setImage(image1);
        GreenfootImage Knight4 = getImage();
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
