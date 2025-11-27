import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplashWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SplashWorld extends World
{
    private int timer = 180;
    /**
     * Constructor for objects of class SplashWorld.
     * 
     */
    public SplashWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    public void prepare(){
        showText("420-141-VA Game Programming 1", 400 , 200);
        showText("Team Members: Rend Abi Ouli, Varshiha Puvanarajah, Alexandra Di Iorio & Rainier Tabing", 400, 260);
        GreenfootImage logo = new GreenfootImage("Vanier_Logo.png");
        getBackground().drawImage(logo, 300, 350);
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
