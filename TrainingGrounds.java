import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrainingGrounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainingGrounds extends World
{
    private int timer = 1200;
    private boolean trollSpawned = false;
    private int count = 12;
    private int knightStartX;
    private int knightStartY; 
    private GreenfootImage imageBackground = new GreenfootImage("BackgroundLogo.png");

    public TrainingGrounds(int knightX, int knightY) {  
        
        super(547, 554, 1); 

        knightStartX = knightX;
        knightStartY = knightY;
        setBackground(new GreenfootImage("TrainingGround.png"));

        prepare();

    }

    public void act(){
        addInsstructions();  
    }

    public void addInsstructions(){
        //Instructions
        timer--;
        if(timer > 1010 ){
            showText(" Hello, I will be your instructor \n " +"throughout this game.\n" + "Tutorial Time!", 340, 100);
        }else if(timer > 840 ){
            showText("Use A/D or <--> to  \n" + "move left/right", 340, 100);
        } else if(timer > 660){
            showText("Use W/S or Up/Down keys \n" + "to move up and down", 340, 100);
        } else if(timer > 480){
            showText("Press X to kill the enemies", 340, 100);
        } else if(timer > 300){
            showText("Defeat this troll\n" + "to continue!", 340, 100);
        }else{
            if(!trollSpawned){
                addObject(new Troll(), 100, 450);
                trollSpawned = true;
            } 

            if(trollSpawned && getObjects(Troll.class).isEmpty()){
                count--;
                if(count <= 0){
                    setBackground(imageBackground);
                    showText("Good Job! You passed the tutorial level \n" + 
                        "You will have to restart the level if the\n" + 
                        "trolls touch you 20 times.\n" +
                        "If your score is 80 and over, you will move faster\n" +
                        "You will restart the whole game if you lose the final battle.\n" +
                        "Press ENTER to continue!",
                        getWidth()/2, getHeight()/2);
                    if(Greenfoot.isKeyDown("enter")){
                        int newX = 50;
                        int newY = 50;
                        Greenfoot.setWorld(new Grass1(newX, newY));

                    }

                }
            }
        }
    }

    public void prepare(){
        addObject(new Knight(), 100, 350);
        addObject(new DialogBox(), getWidth()/2, 100);
        addObject(new General(), 112, 100);
    }
}