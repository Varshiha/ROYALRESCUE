import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private int timer = 120;
    private GreenfootImage imageBackground; 
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        super(547, 554, 1); 
        GreenfootImage bg = new GreenfootImage("GameLogo.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        imageBackground = new GreenfootImage("BackgroundLogo.png");
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            setBackground(imageBackground);
            showText("Welcome to Royal Rescue! \n"+ "The purpose of this game is to defeat \n" + 
            "all the trolls and save the king. \n " + 
            "You will have to face challenges such as \n" +
            "solving riddles and killing mean guys. \n" + 
            "Press ENTER to go to the tutorial",
            getWidth()/2, getHeight()/2);
            if(Greenfoot.isKeyDown("enter")){
                Greenfoot.setWorld(new TrainingGrounds());
            }
        }
    }
}
