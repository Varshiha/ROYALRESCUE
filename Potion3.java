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
        if (answer.equals("Guacamole")) // Compare the entered string
        {
            Greenfoot.setWorld(new DarkForest());
        }
        else
        {
            Greenfoot.setWorld(new BookOpen2());
        }
    }// Add your action code here.
    }
    
    public void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }

}
