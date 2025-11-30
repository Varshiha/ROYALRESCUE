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
        super(1107, 820, 1);
        imageBackground = new GreenfootImage("BackgroundLogo.png");
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            setBackground(imageBackground);
            showText("Welcome to Royal Rescue! \n"+ "The purpose of this game is to defeat all the trolls and save the king. \n" + 
            "You will have to face challenges like solving riddles and killing mean guys. \n" + "Press ENTER to go to the tutorial", getWidth()/2, getHeight()/2);
            if(Greenfoot.isKeyDown("ENTER")){
                Greenfoot.setWorld(new TrainingGrounds());
            }
        }
    }
}
