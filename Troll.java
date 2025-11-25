import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trolls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Actor
{   private int health = 2;
    
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
       if(isTouching(Sword.class)){
           health--;
           
           if(health<= 0){
               getWorld().removeObject(this);
               Greenfoot.delay(80);
               getWorld().showText("Traning Complete! Game Time!", 300, 200);
               Greenfoot.setWorld(new Castle());
           }
       }
    }
}
