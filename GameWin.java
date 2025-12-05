import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWin extends World
{
    private int timer =300;
    private Knight knight = new Knight();
    /**
     * Constructor for objects of class GameWin.
     * 
     */
    public GameWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 
        
        Greenfoot.playSound("win.wav");
    }
    
    public void act(){
        timer--;
        Font font = new Font("Times New Roman", 30);
        Font font2 = new Font("Times New Roman",50);
        Font font3 = new Font("Times New Roman", 90);
        if(timer >= 200){  

            GreenfootImage line6 = new GreenfootImage(600, 100);
            line6.setFont(font3);
            line6.setColor(Color.BLACK);
            line6.drawString("A", 20, 70);
            getBackground().drawImage(line6, 10, 30);

            GreenfootImage line0 = new GreenfootImage(600, 100);
            line0.setFont(font);
            line0.setColor(Color.BLACK);
            line0.drawString("fter the Knight's win, the King", 20, 70);
            getBackground().drawImage(line0, 70, 30);

            GreenfootImage line1 = new GreenfootImage(600, 100);
            line1.setFont(font);
            line1.setColor(Color.BLACK);
            line1.drawString("rewared the Knight", 20, 70);
            getBackground().drawImage(line1, 70, 80);

            GreenfootImage line2 = new GreenfootImage(600, 100);
            line2.setFont(font);
            line2.setColor(Color.BLACK);
            line2.drawString("with some good old guacamole.", 20, 70);
            getBackground().drawImage(line2, 70, 130);

        }
        if(timer<200){        

            GreenfootImage line4 = new GreenfootImage(600, 100);
            line4.setFont(font2);
            line4.setColor(Color.BLACK);
            line4.drawString("Good Job", 20, 70);
            getBackground().drawImage(line4, 140, 210);

        }
        if(timer < 100){
            GreenfootImage line5 = new GreenfootImage(600, 100);
            line5.setFont(font);
            line5.setColor(Color.BLACK);
            line5.drawString("Press 'space' to play again.", 20, 70);
            getBackground().drawImage(line5, 140, 250);
            restart();
        }
    }
    
    public void restart(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new SplashWorld());
        }
    }
}