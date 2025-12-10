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
    private Knight k = new Knight();
    /**
     * Constructor for objects of class SplashWorld.
     * 
     */
    public SplashWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.WHITE);
        bg.fill();
        setBackground(bg);
        addObject(new VanierLogo(), getWidth()/2, getHeight()/2);
        k.score = 0;
        prepare();
        
    }

    private void prepare(){
        Font font = new Font("Comic Sans MS", 20);

        GreenfootImage courseTitle = new GreenfootImage(600, 100);
        courseTitle.setFont(font);
        courseTitle.setColor(Color.BLACK);
        courseTitle.drawString("420-141-VA Game Programming 1", 20, 70);
        getBackground().drawImage(courseTitle, 100, 70);

        GreenfootImage line1 = new GreenfootImage(600, 100);
        line1.setFont(font);
        line1.setColor(Color.BLACK);
        line1.drawString("Rend Abi Ouli - Varshiha Puvanarajah", 20, 70);
        getBackground().drawImage(line1, 100, 370);

        GreenfootImage line2 = new GreenfootImage(600, 100);
        line2.setFont(font);
        line2.setColor(Color.BLACK);
        line2.drawString("Alexandra Di Iorio",20, 70);
        getBackground().drawImage(line2, 180, 400);
    }

    public void act(){
        timer--;
        if(timer <= 0){
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
