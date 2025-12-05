import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Outside here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass1 extends World
{
    private int trollSpawnTimer = 150;
    private int trollsToSpawn = Greenfoot.getRandomNumber(5) + 3;
    //spawn between 3 and 7 trolls
    private boolean finishedSpawning = false;private int knightStartX;
    private int knightStartY;

    public Grass1(int knightX, int knightY) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        
        showText("Help me! I am scared!\n" +"Save me!", 340, 100);
        knightStartX = knightX;
        knightStartY = knightY;

        setBackground(new GreenfootImage("Grass1.png"));

        prepare();
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
            showText("Thank you for saving me!\n" 
                + "You have to save the King.\n" 
                + "HE'S ALL ALONE!", 340, 100);
            checkKnightExit();
            showText("E\n" + "X\n" + "I\n" + "T", 535, getHeight()/2);
        }

    }

    public void spawnAttackingTroll(){
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());

        Troll t = new Troll();
        addObject(t, x, y);
    }

    private void checkKnightExit(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        if(k.getX() >=getWidth() - 5){
            int newX = k.getX();
            int newY = k.getY();
            Greenfoot.setWorld(new Grass2(newX, newY));

        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {addObject(new Knight(), 100, 350);
        addObject(new DialogBox(), getWidth()/2, 100);
        addObject(new MaidHead(), 112, 100); 
        addObject(new Maid(), 300, 350);
    }
}
