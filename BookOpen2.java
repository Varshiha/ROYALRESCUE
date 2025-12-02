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
        riddle();
        addObject(new Potion2(), 165, 375);
        
    }
    
    public void showText(){
        timer--;
        if(timer> 0){
            showText("Try again", 300 , 100);
        }
    }
    
    
    
    public void riddle(){
        


        // Before having the guac riddle pop, we should add a message that says
        //Solving this riddle will bring you to the owner of this book, the one whom you are looking for 
        //and then player presses enter and the riddle in the book pops up like what we have now and then 
        //they solve it and it brings them to the wherever the King  is which is the cave where 
        //he is tied up on a chair guarded by trolls  who wont be moving
        //then we have big bad troll that says fight me you little coward and then the 
        //battle starts in the the darkforest
        //The knight starts fighting THE troll and its a hard fight because the one hit wont kill him 
        //because the Troll has ten lives so everyhit will weaken him but if the Troll is able 
        //to touch the knight with his sword then the Troll's health goes up by 2 points and knight point goes down 1 
        //making it harder for knight

        
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
        line5.drawString("Click on the king.", 20, 70);
        getBackground().drawImage(line5, 50, 250);
        
        
        
    }
        

    }


