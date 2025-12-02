import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingRoom extends World
{

    /**
     * Constructor for objects of class KingRoom.
     * 
     */
    public KingRoom(int knightX, int knightY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        addObject( new MiniLibrary(), 60, 130); 
        prepare(knightX, knightY);
    }
    
    public KingRoom(){
        this(350,350);
    }

    private void prepare(int knightX, int knightY){
        addObject(new Knight(), knightX, knightY);
    }
    
    public void act(){
        findBookCase();
    }
    
    public void findBookCase(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        MiniLibrary ml = k.ifTouchBookCase();
        if(ml != null){
            removeObject(ml);
            
            Greenfoot.setWorld(new Library());
        }

    }
}
