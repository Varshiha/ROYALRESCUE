import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KnightFace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KnightFace extends World
{
    private int timer = 120;
    /**
     * Constructor for objects of class KnightFace.
     * 
     */
    public KnightFace()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            Greenfoot.setWorld(new BlackScreen());
        }
    
    }
}
