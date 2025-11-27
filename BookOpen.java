import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BookOpen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookOpen extends World
{

    /**
     * Constructor for objects of class BookOpen.
     * 
     */
    public BookOpen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(560, 500, 1);
         prepare();
    }
    
    public void prepare(){
        Font font = new Font("Comic Sans MS", 25);
        
        GreenfootImage courseTitle = new GreenfootImage(600, 100);
        courseTitle.setFont(font);
        courseTitle.setColor(Color.WHITE);
        courseTitle.drawString("RIDDLE:", 20, 70);
        getBackground().drawImage(courseTitle, 50, 30);
        
        GreenfootImage line1 = new GreenfootImage(600, 100);
        line1.setFont(font);
        line1.setColor(Color.WHITE);
        line1.drawString("WHAT DIP", 20, 70);
        getBackground().drawImage(line1, 50, 90);
        
        GreenfootImage line2 = new GreenfootImage(600, 100);
        line2.setFont(font);
        line2.setColor(Color.WHITE);
        line2.drawString("CAN YOU MAKE", 20, 70);
        getBackground().drawImage(line2, 50, 130);
        
        GreenfootImage line3 = new GreenfootImage(600, 100);
        line3.setFont(font);
        line3.setColor(Color.WHITE);
        line3.drawString("MAKE USING", 20, 70);
        getBackground().drawImage(line3, 50, 170);
        
        GreenfootImage line4 = new GreenfootImage(600, 100);
        line4.setFont(font);
        line4.setColor(Color.WHITE);
        line4.drawString("AVOCADOS?", 20, 70);
        getBackground().drawImage(line4, 50, 210);
    }
}
