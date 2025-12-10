import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWin extends World
{
    private int timer =120;
    private Knight knight = new Knight();
    /**
     * Constructor for objects of class GameWin.
     * 
     */
    public GameWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        
        
        MusicManager.stopBgMusic();
        MusicManager.startWinMusic();
    }

    public void act(){
        timer--;
        if(timer <= 0){
            Greenfoot.setWorld(new KnightFace());
        }

    }
}