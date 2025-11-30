import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trolls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Actor
{   
    
    public Troll(){
        setImage("Trollside1.png");
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        setImage("Trollside2.png");
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
    /**
     * Act - do whatever the Trolls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       
    }
}
