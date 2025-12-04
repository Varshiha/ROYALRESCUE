import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import java.util.List;

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

        List<Knight> knights = getWorld().getObjects(Knight.class);
        if(knights.isEmpty()){
            return;
        }
        Knight k = knights.get(0);
        
        if(Knight.waitingToRestart){
            return;
        }
        moveTowardsPlayer(k);
    }
        
    

    public void moveTowardsPlayer(Knight k){
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
            k.onHitByTroll(10);
            int pushDistance = 20;
            if(getX() > k.getX()){
                setLocation(getX() + pushDistance, getY()); 
            }else{
                setLocation(getX() - pushDistance, getY());
            }
        }
    }

}
