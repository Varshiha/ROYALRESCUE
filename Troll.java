import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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

    public void act()
    {
        if(Knight.waitingToRestart){
            return;//stop the trols when restart sceen shows up 
        }

        List<Knight> knights = getWorld().getObjects(Knight.class);
        Knight k = knights.get(0);

        if(!knights.isEmpty()){
            moveTowardsPlayer(k);
        }
        
        if(isTouching(Knight.class)){
            k.onHitByTroll();
            pushBack(k);
        }
        
        
    }

    // always looking for the knight
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

    }

    public void pushBack(Knight k){
        int pushDistance = 100;
        if(getX() > k.getX()){
            setLocation(getX() + pushDistance, getY()); 
        }else{
            setLocation(getX() - pushDistance, getY());
        }
    }

    public void die(){
        if(getWorld() != null){
            getWorld().removeObject(this);
            Knight.increaseScore();
        }
    }
    
}
