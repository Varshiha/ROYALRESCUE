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
    private int step = -1; 
    private int timer = 240;
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
        
        
        if(timer > 0){
            showText(" Hello, I will be your instructor \n " +"throughout this game.\n" + "Tutorial Time!", 420, 100);
            timer--;
            return;
        }
        if(step == -1){
            showText("", 420, 100);
            step = 0;
            return;
        }
        
        if(step == 0 ){
            showText("Use A/D or <--> to  \n" + "move left/right", 420, 100);
            if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left") ||Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                showText("Use W/S or Up/Down keys \n" + "to move up and down", 420, 100);
                step = 1;
            }
            return;
        }
        
        if(step == 1){
            
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
                showText("Press X to kill the enemies", 420, 100);
                step = 2;
            }
            return;
        }
        
        if(step == 2){
            if(Greenfoot.isKeyDown("x")){
                showText("Defeat all the enemies \n" + "to continue!", 420, 100);
            }
            return;
        }
        
        if(getObjects(Troll.class).isEmpty()){
            Greenfoot.setWorld(new Castle());
        }
    
}
    
    
}