import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrainingGrounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainingGrounds extends World
{
    //private DialogBox dialog;
    private int step = 0; 
    /**
     * Constructor for objects of class TrainingGrounds.
     * 
     */
    public TrainingGrounds()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(730, 738, 1);  
        addObject(new Knight(), 100, 350);
        addObject(new Troll(), 450, 350);
        addObject(new DialogBox(), getWidth()/2, 100);
        addObject(new General(), 205, 100);
        }
    public void act(){
        addInsstructions();
    }

    public void addInsstructions(){
        //Instructions
        showText("Hello, I will be your instructor throughout this game.\n" + "Time to test your fighting skills", 420, 100);
        if(step == 0){
            showText("Use A/D or <--> to  \n" + "move left/right", 420, 100);
            if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left") ||Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                showText("Use W/S or Up/Down keys \n" + "to move up and down", 420, 100);
                step = 1;
            }
        }else if(step == 1){
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
                showText("Press X to kill the enemies", 420, 100);
                step = 2;
            }
        }else{
            if(Greenfoot.isKeyDown("x")){
                showText("Defeat all the enemies \n" + "to continue!", 420, 100);
            }
        }
        
        if(getObjects(Troll.class).isEmpty()){
            Greenfoot.setWorld(new Castle());
        }
    }
    
    
}