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
        
        GreenfootImage line1 = new GreenfootImage(600, 100);
        line1.setFont(font);
        line1.setColor(Color.WHITE);
        line1.drawString("Team Members:", 20, 70);
        getBackground().drawImage(line1, 420, 400);
        
        GreenfootImage line2 = new GreenfootImage(600, 100);
        line2.setFont(font);
        line2.setColor(Color.WHITE);
        line2.drawString("Rend Abi Ouli - Varshiha Puvanarajah", 20, 70);
        getBackground().drawImage(line2, 320, 420);
        
        GreenfootImage line3 = new GreenfootImage(600, 100);
        line3.setFont(font);
        line3.setColor(Color.WHITE);
        line3.drawString("Alexandra Di Iorio - Ranier Tabing", 20, 70);
        getBackground().drawImage(line3, 320, 440);
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
