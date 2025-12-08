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
    private int trollsToSpawn = Greenfoot.getRandomNumber(5) + 3;
    //spawn between 3 and 7 trolls
    private boolean finishedSpawning = false;
    private int maxDifficulty = 4; //amount of trolls that spawn
    private int trollsStart = 2; //easier
    private int knightStartX;
    private int knightStartY;

    public Grass2(int knightX, int knightY) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1);
        
        knightStartX = knightX;
        knightStartY = knightY;

        setBackground(new GreenfootImage("Grass2.png"));
        prepare();
    }
    
    public Grass2(){
        this(350,350);
    }

    private void prepare(){
        addObject(new Knight(), knightStartX, knightStartY);
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
            Greenfoot.setWorld(new Castle(newX, newY));
            
        }
    }
}

