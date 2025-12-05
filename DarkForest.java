import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DarkForest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkForest extends World
{
    private boolean finishedSpawning = false;
    private Knight knight = new Knight();
    /**
     * Constructor for objects of class DarkForest.
     * 
     */ 
    public DarkForest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.        
        super(547, 554, 1);
        addObject(new Knight(), 350, 350);
        
        
    }
    
    public void act(){
        if(finishedSpawning && getObjects(Troll.class).isEmpty()){
            checkKnightExit();
            showText("E\n" + "X\n" + "I\n" + "T", 535, getHeight()/2);
        }
        
    }
    
    private void prepare(int knightX, int knightY){
        addObject(new Knight(), knightX, knightY);
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
    }
    
    private void checkKnightExit(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        if(k.getX() >=getWidth() - 5){
            int newX = k.getX();
            int newY = k.getY();
            Greenfoot.setWorld(new Grass2(newX, newY));

        }
    }
}
