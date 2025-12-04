import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeartFull here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    private GreenfootImage HeartFull;
    private GreenfootImage HeartEmpty;
    
    
    public Heart(){
        HeartFull = new GreenfootImage("HeartFull.png");
        
        HeartEmpty = new GreenfootImage("HeartEmpty.png");
        
        //Scale images
        scaleImage(HeartFull);
        scaleImage(HeartEmpty);
        
        setImage(HeartFull);
    }
    
    /**
     * Act - do whatever the HeartFull wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/2, img.getHeight()/2);
    }
    
    public void emptyHeart(){
        
        setImage(HeartEmpty);
    }
}

