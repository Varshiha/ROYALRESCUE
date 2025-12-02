import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BookOpen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookOpen extends World
{
    private Potion p = new Potion();
    /**
     * Constructor for objects of class BookOpen.
     * 
     */
    public BookOpen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 500, 1);
        addObject(new Potion(), 165, 375);
        instruction();
    }
    
    public void instruction(){
        Font font = new Font("Times New Roman", 25);
        
        GreenfootImage line0 = new GreenfootImage(600, 100);
        line0.setFont(font);
        line0.setColor(Color.BLACK);
        line0.drawString("This Riddle Will", 20, 70);
        getBackground().drawImage(line0, 50, 50);
        
        GreenfootImage line1 = new GreenfootImage(600, 100);
        line1.setFont(font);
        line1.setColor(Color.BLACK);
        line1.drawString("take you to", 20, 70);
        getBackground().drawImage(line1, 50, 90);
        
        GreenfootImage line2 = new GreenfootImage(600, 100);
        line2.setFont(font);
        line2.setColor(Color.BLACK);
        line2.drawString("the one you're", 20, 70);
        getBackground().drawImage(line2, 50, 130);
        
        GreenfootImage line4 = new GreenfootImage(600, 100);
        line4.setFont(font);
        line4.setColor(Color.BLACK);
        line4.drawString("looking for.", 20, 70);
        getBackground().drawImage(line4, 50, 170);
        
        GreenfootImage line5 = new GreenfootImage(600, 100);
        line5.setFont(font);
        line5.setColor(Color.BLACK);
        line5.drawString("Click on the king.", 20, 70);
        getBackground().drawImage(line5, 50, 250);
        
    }
    
    
    
}
