import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrainingGrounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainingGrounds extends World
{

    /**
     * Constructor for objects of class TrainingGrounds.
     * 
     */
    public TrainingGrounds()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(547, 554, 1); 
        super(600, 400, 1);
        addObject(new Knight(), 100, 350);
        addObject(new Trolls(), 450, 350)
    }
}
