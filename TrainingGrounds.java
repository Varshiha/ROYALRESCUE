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
    private Troll troll;
    
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
        dialog = new DialogBox();
        addObject(dialog, getWidth()/2, 100);
        //showText("Use A or <- to move left", 320, 100);
        troll = new Troll();
        addObject(new Troll(), 450, 350);
        addObject(new Troll(), 200, 200);
    }
    public void act(){
        addInsstructions();
    }

    public void addInsstructions(){
        //Instructions
        if(step == 0){
            showText("Use A or <- to move left", 320, 100);
            if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
                
                showText("Use D or -> to move right", 320, 100);
                step = 1;
            }
        }else if(step == 1){
            if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                showText("Press SPACE  to jump", 320, 100);
                step = 2;
            }
        }else if(step == 2){
            if(Greenfoot.isKeyDown("space") ){

                showText("Press X to attack", 320, 100);
                step = 3;
            }
        }else{
            if(Greenfoot.isKeyDown("x")){
                showText("Defeat the dummy to continue!", 320, 100);
                
            }
        }
    }
    public void method(){
        troll.act();
    }
}