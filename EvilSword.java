import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        attackCheck();
    }
    
    public void attackCheck(){
        if(!Greenfoot.isKeyDown("g")) {
            return;
        }
        if(isTouching(Knight.class)){
            removeTouching(Knight.class);
        }
    }
}
