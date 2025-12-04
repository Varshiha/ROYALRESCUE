import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    public Sword(){
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4);
    }
    
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        attackCheck();
    }
    
    public void attackCheck(){
        List<Knight> knights = getWorld().getObjects(Knight.class);
        if(!Greenfoot.isKeyDown("x")) {
            return;
        }
        if(getWorld() == null){
            return;
        }
        if(knights.isEmpty()){
            return;
        }
        Knight k = getWorld().getObjects(Knight.class).get(0);
        if(isTouching(Troll.class)){
            removeTouching(Troll.class);
        }
    }
    
}
