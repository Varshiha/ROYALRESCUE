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
    private FinalBoss boss;
    /**
     * Constructor for objects of class Cave.
     * 
     */
    public Cave(int knightX, int knightY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1);
        
        addObject(new Knight(), knightX, knightY);
        addObject(new KingLocked(), 501, 59);
        addObject(new FinalBoss(), getWidth()/2, getHeight()/3);
        Knight knight = (Knight) getObjects(Knight.class).get(0);
        

    }
    

    
    
    public void showMessage(Knight k){
        showText("Hits: " + k.getHitsOnFinalBoss(), 200, 20);
        showText("Required: " + k.getHitsRequired(), 60, 40);
        showText("Boss Hits: " + k.getBossHits() + "/" + k.getMaxBossHits(), 200, 40);
    }

    
    public void act(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        
        showMessage(k);
        
    }
}
