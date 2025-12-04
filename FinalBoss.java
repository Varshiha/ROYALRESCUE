import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    private GreenfootImage StandingRight = new GreenfootImage("FinalBoss1r.png");
    private GreenfootImage StandingLeft = new GreenfootImage("FinalBoss1l.png");
    private GreenfootImage AttackRight = new GreenfootImage("FinalBossAttackr.png");
    private GreenfootImage AttackLeft = new GreenfootImage("FinalBossAttackl.png");
    
    
    
    //Sword
    private boolean facingRight = true;
    private boolean swordFacingRight = true;
    
    //Speed of the final boss
    private int speed = 3;
    
    //Amount of lives
    private int lives = 5;
    
    public FinalBoss(){
        scaleImage(StandingLeft);
        scaleImage(StandingRight);
        scaleImage(AttackLeft);
        scaleImage(AttackRight);
        
        setImage(StandingLeft);
        
    }
    
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       attack();
    }
    
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }
    
    
    private void attack(){
        
            if(facingRight){
                setImage(AttackLeft);
            }else{
                setImage(AttackRight);
            }
        
            if(facingRight){
                setImage(StandingLeft);
            } else{
                setImage(StandingRight);
            }
        
    }
    
    
    
    
}
