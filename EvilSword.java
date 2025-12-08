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
    //Images
    private GreenfootImage swordRight = new GreenfootImage("EvilSword.png");
    private GreenfootImage swordLeft = new GreenfootImage("EvilSwordl.png");
    
    //Which way the sword is pointing
    private boolean facingRight = true;
    //if sword is in attack mode
    private boolean attacking = false;
    
    //link to final boss
    private FinalBoss owner;

    
    /**
     * Constructor
     */
    public EvilSword(){
        scaleImage(swordRight);
        scaleImage(swordLeft);

        setImage(swordRight);
    }

    /**
     * Scale image
     */
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }

    /**
     * Act - do whatever the EvilSword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Damage knight if touched
        Knight k = (Knight)getOneIntersectingObject(Knight.class);
        if (k != null) {
            damageKnight(k);
        }

        updateDirection();

    }

    /**
     * Final boss uses it to tell the sword which direction to face
     */
    public void setFacingRight(boolean value){
        facingRight = value;
        updateDirection();
    }

    /**
     * Attack animation
     */
    public void setAttacking(boolean value){
        attacking = value;
    }

    /**
     * Sword direction image
     */
    public void updateDirection(){
        if(facingRight){
            setImage(swordRight);
        }else{
            setImage(swordLeft);
        }
    }

    /**
     * Calls gameOver world
     */
    private void damageKnight(Knight k) {
        if (k.hitsByFinalBoss >= k.maxBossHits) {
            k.gameOver();
        }
    }
    
    public FinalBoss getOwner() {
        return owner;
    }

    /**
     * Mirrors the Sword image
     */
    public void flip(){
        getImage().mirrorHorizontally();
        facingRight = !facingRight;
    }
}
