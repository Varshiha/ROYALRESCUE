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
    
    private Actor target;
    private GreenfootImage rightSide = new GreenfootImage("Trollside2.png");
    private GreenfootImage leftSide = new GreenfootImage("Trollside1.png");
    public Troll(){
        rightSide.scale(rightSide.getWidth()/3, rightSide.getHeight()/3);
        leftSide.scale(leftSide.getWidth()/3, leftSide.getHeight()/3);
        setImage(leftSide);
    }

    /**
     * Act - do whatever the Trolls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveTowardsPlayer();
        if(target!= null){
            turnTowards(target.getX(), target.getY());
            move(1);
        }
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

        if(isTouching(Knight.class)){
            k.loseLife();
            int pushDistance = 50;
            if(getX() > k.getX()){
                setLocation(getX() + pushDistance, getY()); 
            }else{
                setLocation(getX() - pushDistance, getY());
            }
        }
    }

    
    
    public void setTarget(Actor a){
        target = a;
    }
}
