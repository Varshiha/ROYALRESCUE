import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cave extends World
{
    private GreenfootImage lockedKing = new GreenfootImage("KingLocked.png");
    /**
     * Constructor for objects of class Cave.
     * 
     */
    public Cave()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        addObject(new FinalBoss(), 450, 400);

        addObject(new KingLocked(), 501, 59);
        addObject(new Heart(), 385, 24);
        addObject(new Heart(), 440, 24);
        addObject(new Heart(), 495, 24);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
