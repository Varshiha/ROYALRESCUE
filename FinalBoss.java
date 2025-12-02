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
    
    private Actor target;
    
    //Sword
    private EvilSword eSword;
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
        
        eSword = new EvilSword();
    }
    
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       updateSwordPosition();
       attack();
    }
    
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }
    
    public void updateSwordPosition(){
       if(Greenfoot.isKeyDown("g")){
           int swordXAttackDistance = facingRight ? 40 : -40;
           int yPosition = -40;
           eSword.setLocation(getX() + swordXAttackDistance, getY() + yPosition);
       }else {
           int swordXDistance = facingRight ? 10 : -10;
           eSword.setLocation(getX() + swordXDistance, getY());
        }
       
       if(facingRight != swordFacingRight) {
           eSword.getImage().mirrorHorizontally();
           swordFacingRight = facingRight;
       }
    }
    
    private void attack(){
        if(Greenfoot.isKeyDown("g")){
            if(facingRight){
                setImage(AttackLeft);
            }else{
                setImage(AttackRight);
            }
        } else{
            if(facingRight){
                setImage(StandingLeft);
            } else{
                setImage(StandingRight);
            }
        }
    }
    
    public void moveTowardsPlayer(){
        Knight k = (Knight)getWorld().getObjects(Knight.class).get(0);
        if(k.getX() < getX()){
            attack();
            setLocation(getX() - speed, getY());
        }else{
            attack();
            setLocation(getX() + speed, getY());
        }

        if(k.getY() < getY()){
            setLocation(getX(), getY() - speed);
        }else{
            setLocation(getX(), getY() + speed);
        }

        if(isTouching(Knight.class)){
            k.loseLife();
            int pushDistance = 50;
            if(getX() > k.getX()){
                setLocation(getX() + pushDistance, getY()); 
            }else{
                setLocation(getX() - pushDistance, getY());
            }
        }
    }
    
    public void loseLife(){
        lives--;
        speed--;
    }
    
    public void setTarget(Actor a){
        target = a;
    }
}
