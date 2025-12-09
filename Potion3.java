import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion3 extends Actor
{
    private GreenfootImage potion = new GreenfootImage("KingHead.png");

    public Potion3(){
        scaleImage(potion);
        setImage(potion);
    }

    /**
     * Act - do whatever the Potion3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            String answer = Greenfoot.ask("What dip is made using avocados?");
            if (answer.equals("Guacamole") || answer.equals("guacamole")) 
            {
                int startX = 50;  
                int startY = 50;  
                Greenfoot.setWorld(new DarkForest(startX, startY));
            }
        }
    }

    public void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }

}
