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
    private GreenfootImage swordRight = new GreenfootImage("EvilSword.png");
    private GreenfootImage swordLeft = new GreenfootImage("EvilSwordl.png");
    private boolean facingRight = true;
    private boolean attacking = false;
    public EvilSword(){
        scaleImage(swordRight);
        scaleImage(swordLeft);

        setImage(swordRight);
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
    
        updateDirection();
        damageKnight();

    }
    
    public void setFacingRight(boolean value){
        facingRight = value;
        updateDirection();
    }
    
    public void setAttacking(boolean value){
        attacking = value;
    }

    public void updateDirection(){
        if(facingRight){
            setImage(swordRight);
        }else{
            setImage(swordLeft);
        }
    }

    public void damageKnight(){
        if(!attacking){
            return;
        }

        Knight k = (Knight) getOneIntersectingObject(Knight.class);
        if(k != null){
            k.onHitByTroll();

            int push = facingRight ? 20 : -20;
            k.setLocation(k.getX() + push, k.getY());
        }
    }
    
    public void flip(){
        getImage().mirrorHorizontally();
        facingRight = !facingRight;
    }
}
