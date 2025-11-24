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
        super(547, 554, 1); 
        //super(600, 400, 1);
        addObject(new Knight(), 100, 350);
        addObject(new Troll(), 450, 350);
        
        //Instructions
        showText("Use A & D or ,<- -> to move left and right", 300, 50);
        showText("Press SPACE  to jump", 300, 80);
        showText("Press X to attack", 300, 110);
        showText("Defeat the dummy to continue!", 300, 160);
        
    }
}
