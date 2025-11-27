import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrainingGrounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainingGrounds extends World
{
    private DialogBox dialog;
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
        addObject(new Troll(), 200, 200);
        dialog = new DialogBox();
        addObject(dialog, getWidth()/2, 100);
        showText("Use A or <- to move left", 420, 100);
        
    }
    public void act(){
        addInsstructions();
    }

    public void addInsstructions(){
        //Instructions
        if(step == 0){
            showText("Use A or <- to move left", 420, 100);
            if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
                showText("Use D or -> to move right", 420, 100);
                step = 1;
            }
        }else if(step == 1){
            if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                showText("Use W or  Up key to move up", 420, 100);
                step = 2;
            }
        }else if(step == 2){
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){

                showText("Use S or  Down key to move down", 420, 100);
                step = 3;
            }
        }  else if(step == 3){
            if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
                showText("Press SPACE to jump", 420, 100);
                step = 4;
            }
        }else if(step == 4){
            if(Greenfoot.isKeyDown("space") ){
                showText("Press X to attack", 420, 100);
                step = 5;
            }
        }else{
            if(Greenfoot.isKeyDown("x")){
                showText("Defeat the dummy to continue!", 420, 100);
            }
        }
    }
}