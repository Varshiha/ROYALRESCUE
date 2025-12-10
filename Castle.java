import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Castle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle extends World
{
    private int trollSpawnTimer = 150;
    private int trollsToSpawn = Greenfoot.getRandomNumber(5) + 3;
    //spawn between 6 and 10 trolls
    private boolean finishedSpawning = false;
    private int maxDifficulty = 4; //amount of trolls that spawn
    private int trollsStart = 2; 
    private boolean powerUpAdded = false;

    /**
     * Constructor for objects of class Castle.
     * 
     */
    public Castle(int knightX, int knightY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 

        GreenfootImage bg = new GreenfootImage("Castle.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        prepare(knightX, knightY);
    }

    public Castle(){
        this(350, 350);
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

            if(trollsStart < maxDifficulty){
                trollsStart++;
            }

            if(trollsToSpawn == 0 ){
                finishedSpawning = true;
            }

        }
        if(finishedSpawning){
            addObject(new PowerUp(), 200, 500);
            
        }
    }

    public void spawnAttackingTroll(){
        for(int i=0; i<trollsStart; i++){
            addObject(new Troll(), 
                Greenfoot.getRandomNumber(getWidth()), 
                Greenfoot.getRandomNumber(getHeight()));
        }

    }

    public void potionFound(Knight k, PowerUp p){
        if(p != null){
            removeObject(p);
            int newX = k.getX();
            int newY = k.getY();

            Greenfoot.setWorld(new KingRoom(newX, newY));
        }

    }

}
