import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grass2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass2 extends World
{
    private int trollSpawnTimer = 150;
    private int trollsToSpawn = Greenfoot.getRandomNumber(5) + 6;
    //spawn between 6 and 10 trolls
    private boolean finishedSpawning = false;
    /**
     * Constructor for objects of class Grass2.
     * 
     */
    public Grass2(int knightX, int knightY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1);
        prepare(knightX, knightY);
    }

    private void prepare(int knightX, int knightY){
        addObject(new Knight(), knightX, knightY);
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
    }

    public void act(){
        trollSpawnTimer--;
        if(trollSpawnTimer<= 0 && trollsToSpawn > 0){
            spawnAttackingTroll();
            trollsToSpawn--;
            trollSpawnTimer = 150;
            if(trollsToSpawn == 0 ){
                finishedSpawning = true;
            }
        }
        if(finishedSpawning && getObjects(Troll.class).isEmpty()){
            checkKnightExit();
            showText("E\n" + "X\n" + "I\n" + "T", 535, getHeight()/2);
        }

    }
    
    public void spawnAttackingTroll(){
        
        for(int i=0; i<4; i++){
            addObject(new Troll(), 
            Greenfoot.getRandomNumber(500), 
            Greenfoot.getRandomNumber(500));
        }
        
    }
    
    private void checkKnightExit(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        if(k.getX() >=getWidth() - 5){
            int newX = k.getX();
            int newY = k.getY();
            Greenfoot.setWorld(new Castle(newX, newY));
            
        }
    }
}

