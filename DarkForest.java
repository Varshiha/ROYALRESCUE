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
    /**
     * Constructor for objects of class DarkForest.
     * 
     */ 
    public DarkForest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.        
        super(547, 554, 1);
        addObject(new Knight(), 350, 350);
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));

    }
    
    public void act(){
        finalTrolls();
        finalFight();
    }
    
    public void finalTrolls(){
        if(getObjects(Troll.class).isEmpty()){
            
            addObject(new FinalBoss(), 490, 242);
        }
        
    }

    public void finalFight(){
        if(getObjects(FinalBoss.class).isEmpty()){
            checkKnightExit();
            showText("E\n" + "X\n" + "I\n" + "T", 535, getHeight()/2);
        }
        
    }
    
    private void checkKnightExit(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        if(k.getX() >=getWidth() - 5){
            int newX = k.getX();
            int newY = k.getY();
            Greenfoot.setWorld(new Cave());

        }
    }
}
