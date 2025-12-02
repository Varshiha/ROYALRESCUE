import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    private FinalBoss fB;
    
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
        if(!Greenfoot.isKeyDown("x")) {
            return;
        }
        if(isTouching(Troll.class)){
            removeTouching(Troll.class);
        }
    }
    
    public void killFinalBoss(){
        if(isTouching(FinalBoss.class)){
            fB.loseLife();
        }
        if(fB == null){
            
        }
    }
}
