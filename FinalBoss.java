import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private EvilSword eSword;
    private boolean facingRight = true;
    private boolean swordFacingRight = true;

    //Speed of the final boss
    private int speed = 2;
    private int attackCooldown = 0;
    private int attackTime = 0;
    private final int ATTACK_COOLDOWN_MAX = 80;
    private final int ATTACK_TIME_MAX =20;

    //Amount of lives
    private int lives = 5;
    private boolean dead = false;

    public FinalBoss(){
        scaleImage(StandingLeft);
        scaleImage(StandingRight);
        scaleImage(AttackLeft);
        scaleImage(AttackRight);

        setImage(StandingLeft);

        eSword = new EvilSword();
    }

    public void addedToWorld(World w){
        if(eSword.getWorld() == null)
            w.addObject(eSword, getX(), getY());
    }

    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        List<Knight> knights = getWorld().getObjects(Knight.class);
        if(knights.isEmpty()) return;
        Knight k = knights.get(0);
        if(dead) return;
        update(k);
        updateSwordPosition();

        if(isTouching(Knight.class) && attackTime > 0){
            k.onHitByTroll(12);
            attackTime = 0;
            attackCooldown = 40;
        }
    }

    private void update(Knight k){
        if(attackCooldown > 0){
            attackCooldown--;
        }
        if(attackTime > 0){
            attackTime--;
        }

        if(isNear(k, 120) && attackCooldown == 0){
            startAttack();
            return;
        }

        if(attackTime > 0){
            return;
        }

        moveToward(k);
    }

    private boolean isNear(Actor a, int distance){
        return Math.abs(getX()- a.getX()) < distance && Math.abs(getY()- a.getY()) < distance;
    }

    private void moveToward(Knight k){
        if(k.getX() < getX()){
            facingRight = false;
            setImage(StandingLeft);
            setLocation(getX() - speed, getY());
        }else{
            facingRight = true;
            setImage(StandingRight);
            setLocation(getX() + speed, getY());
        }

        if(k.getY() < getY()){
            setLocation(getX() - speed, getY());
        }else{
            setLocation(getX() + speed, getY());
        }
    }

    private void startAttack(){
        attackTime = ATTACK_TIME_MAX;
        attackCooldown = ATTACK_COOLDOWN_MAX;
        if(facingRight){
            setImage(AttackRight);
        }else{
            setImage(AttackLeft);
        }
    }

    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }

    public void updateSwordPosition(){
        if(eSword == null) return;
        if(attackTime > 0){
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

    public void loseLife(){
        lives--;
        if(lives<0){
            dead = true;
        }else{
            if(speed<6) speed++;
        }
    }

    public boolean isDead(){
        return dead;
    }

    public void setTarget(Actor a){
        
    }
}
