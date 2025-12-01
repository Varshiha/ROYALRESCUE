import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Outside here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Outside extends World
{
    private int trollSpawnTimer = 150;
    private int trollsToSpawn = Greenfoot.getRandomNumber(5) + 3;
    //spawn between 3 and 7 trolls
    private boolean finishedSpawning = false;
    /**
     * Constructor for objects of class Outside.
     * 
     */
    public Outside()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        addObject(new Knight(), 100, 350);
        addObject(new DialogBox(), getWidth()/2, 100);
        addObject(new MaidHead(), 112, 100); 
        addObject(new Maid(), 300, 350);
        showText("Help me! I am scared!\nSave me!", 340, 100);
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
        }
    }

    public void spawnAttackingTroll(){
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());

        Troll t = new Troll();
        addObject(t, x, y);
        t.setTarget(getObjects(Maid.class).get(0));
    }
}
