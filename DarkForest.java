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
    private int trollSpawnTimer = 150;
    private int trollsToSpawn = Greenfoot.getRandomNumber(5) + 3;
    //spawn between 6 and 10 trolls
    private int maxDifficulty = 4; //amount of trolls that spawn
    private int trollsStart = 2; //easier
    
    /**
     * Constructor for objects of class DarkForest.
     * 
     */ 
    public DarkForest(int knightX, int knightY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.        
        super(547, 554, 1);
        addObject(new Knight(), knightX, knightY);
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
        addObject(new Troll(), Greenfoot.getRandomNumber(500), Greenfoot.getRandomNumber(500));
    }
    
    public void act(){
        if (Knight.waitingToRestart) return;
        trollSpawnTimer--;
        if(trollSpawnTimer<= 0 && trollsToSpawn > 0){
            spawnAttackingTroll();
            trollsToSpawn--;
            trollSpawnTimer = 150;
            
            if(trollsStart < maxDifficulty){
                trollsStart++;
            }
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
        
        for(int i=0; i<trollsStart; i++){
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
            Greenfoot.setWorld(new Cave(newX, newY));

        }
    }
}
