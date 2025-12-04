import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EvilSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EvilSword extends Actor
{
    private GreenfootImage evilSword = new GreenfootImage("EvilSword.png");
    private GreenfootImage evilSwordl = new GreenfootImage("EvilSwordl.png");
    
    
    
    public EvilSword(){
        scaleImage(evilSword);
        scaleImage(evilSwordl);
        
        setImage(evilSword);
    }
    
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }
    
    /**
     * Act - do whatever the EvilSword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        List<Knight> knights = getWorld().getObjects(Knight.class);
        if(knights.isEmpty()) return;
        Knight k = knights.get(0);
        if(isTouching(Knight.class)){
            k.onHitByTroll(12);
            int push = 30;
            if(getX() > k.getX()){
                setLocation(getX() + push, getY());
            }else{
                setLocation(getX() - push, getY());
            }
        }
        
        
    }
    
    public void attackCheck(){
        if(!Greenfoot.isKeyDown("g")) {
            return;
        }
        if(isTouching(Knight.class)){
            
        }
    }
}
