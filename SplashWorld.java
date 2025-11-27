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
        super(1000, 672, 1); 
        prepare();
    }
    
    public void prepare(){
        Font font = new Font("Comic Sans MS", 20);
        
        GreenfootImage courseTitle = new GreenfootImage(600, 100);
        courseTitle.setFont(font);
        courseTitle.setColor(Color.WHITE);
        courseTitle.drawString("420-141-VA Game Programming 1", 20, 70);
        getBackground().drawImage(courseTitle, 320, 100);
        
        GreenfootImage memberNames = new GreenfootImage(600, 100);
        memberNames.setFont(font);
        memberNames.setColor(Color.WHITE);
        memberNames.drawString("             Team Members: \n" + "Rend Abi Ouli, Varshiha Puvanarajah, Alexandra Di Iorio & Rainier Tabing", 20, 70);
        getBackground().drawImage(memberNames, 240, 400);
        
        
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
