import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Trolls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Actor
{   
    private int speed = 1;
    private GreenfootImage rightSide = new GreenfootImage("Trollside2.png");
    private GreenfootImage leftSide = new GreenfootImage("Trollside1.png");
    public Troll(){
        rightSide.scale(rightSide.getWidth()/2, rightSide.getHeight()/2);
        leftSide.scale(leftSide.getWidth()/2, leftSide.getHeight()/2);
        setImage(leftSide);
    }
    /**
     * Act - do whatever the Trolls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       moveTowardsPlayer();
    }
    
    public void moveTowardsPlayer(){
        Knight k = (Knight)getWorld().getObjects(Knight.class).get(0);
        if(k.getX() < getX()){
           setImage(leftSide);
           setLocation(getX() - speed, getY());
        }else{
           setImage(rightSide);
           setLocation(getX() + speed, getY());
        }
        
        if(k.getY() < getY()){
           setLocation(getX(), getY() - speed);
        }else{
           setLocation(getX(), getY() + speed);
        }
    }
    
    
}
