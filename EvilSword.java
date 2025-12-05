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

    private FinalBoss owner;

    public FinalBoss getOwner() {
        return owner;
    }

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
        // Damage knight if touched
        Knight k = (Knight)getOneIntersectingObject(Knight.class);
        if (k != null) {
            damageKnight(k);
        }

        updateDirection();

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

    private void damageKnight(Knight k) {
        k.score -= 10; // or whatever penalty you want

        if (k.score < 0) k.score = 0;

        if (k.hitsByFinalBoss >= k.maxBossHits) {
            k.gameOver();
        }
    }

    public void flip(){
        getImage().mirrorHorizontally();
        facingRight = !facingRight;
    }
}
