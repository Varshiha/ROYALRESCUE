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
    private boolean isTroll = true;
    /**
     * Constructor for objects of class DarkForest.
     * 
     */ 
    public DarkForest()
    {    
        super(547, 554, 1);
        addObject(new Knight(), 350, 350);
        act();

        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));

    }

    public void act(){
        finalBoss();
        if(getObjects(FinalBoss.class).isEmpty()){
            saveKing();
        }
    }

    public boolean finalBoss(){
        if(getObjects(Troll.class).isEmpty()){
            isTroll = false;
        }
        return false;
    }

    public void saveKing(){

        if(getObjects(FinalBoss.class).isEmpty()){
            checkKnightExit();
            showText("K\n" + "I\n" + "N\n" + "G", 535, getHeight()/2);
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
