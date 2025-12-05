import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BookOpen2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookOpen2 extends World
{
    private Potion p = new Potion();
    
    private int timer = 120;
    /**
     * Constructor for objects of class BookOpen2.
     * 
     */
    public BookOpen2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 500, 1);
        MusicManager.playBackGroundMusic("WF.wav");
        riddle();
        addObject(new Potion3(), 165, 375);
        
    }
    
    
    
    public void riddle(){
    

        
            Font font = new Font("Times New Roman", 25);

            GreenfootImage line0 = new GreenfootImage(600, 100);
            line0.setFont(font);
            line0.setColor(Color.BLACK);
            line0.drawString("RIDDLE:", 20, 70);
            getBackground().drawImage(line0, 50, 30);

            GreenfootImage line1 = new GreenfootImage(600, 100);
            line1.setFont(font);
            line1.setColor(Color.BLACK);
            line1.drawString("WHAT DIP", 20, 70);
            getBackground().drawImage(line1, 50, 90);

            GreenfootImage line2 = new GreenfootImage(600, 100);
            line2.setFont(font);
            line2.setColor(Color.BLACK);
            line2.drawString("CAN YOU MAKE", 20, 70);
            getBackground().drawImage(line2, 50, 130);

            GreenfootImage line3 = new GreenfootImage(600, 100);
            line3.setFont(font);
            line3.setColor(Color.BLACK);
            line3.drawString("MAKE USING", 20, 70);
            getBackground().drawImage(line3, 50, 170);

            GreenfootImage line4 = new GreenfootImage(600, 100);
            line4.setFont(font);
            line4.setColor(Color.BLACK);
            line4.drawString("AVOCADOS?", 20, 70);
            getBackground().drawImage(line4, 50, 210);
            
            GreenfootImage line5 = new GreenfootImage(600, 100);
        line5.setFont(font);
        line5.setColor(Color.BLACK);
        line5.drawString("Press 'ENTER'", 20, 70);
        getBackground().drawImage(line5, 50, 250);
        
        
        
    }
        

    }


