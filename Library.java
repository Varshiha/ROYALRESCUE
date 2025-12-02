import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Library here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Library extends World
{

    /**
     * Constructor for objects of class Library.
     * 
     */
    public Library()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        addObject(new BookClosed(), 378, 114);
    }
    
    
}
