import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Castle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle extends World
{

    /**
     * Constructor for objects of class Castle.
     * 
     */
    public Castle()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        GreenfootImage bg = new GreenfootImage("Castle.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
}
