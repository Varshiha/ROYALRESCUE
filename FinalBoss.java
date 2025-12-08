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
    //Final Boss images
    private GreenfootImage standingRight = new GreenfootImage("FinalBoss1r.png");
    private GreenfootImage standingLeft = new GreenfootImage("FinalBoss1l.png");
    private GreenfootImage attackRight = new GreenfootImage("FinalBossAttackr.png");
    private GreenfootImage attackLeft = new GreenfootImage("FinalBossAttackl.png");

    //Sword & Direction
    private EvilSword eSword;
    private boolean facingRight = true;
    private boolean swordFacingRight = true;

    //Movement & Attack Timing
    private int speed = 1;
    private int attackCooldown = 0;//how long until next attack
    private int attackTime = 0;//how long stays in attack mode
    private final int ATTACK_COOLDOWN_MAX = 80;//delay between attacks
    private final int ATTACK_TIME_MAX =20;//duration of attack naimation

    //Dead or Alive
    private boolean dead = false;

    public FinalBoss(){
        scaleImage(standingLeft);
        scaleImage(standingRight);
        scaleImage(attackLeft);
        scaleImage(attackRight);

        setImage(standingLeft);

        eSword = new EvilSword();
    }

    /**
     * Evil Sword gets added wherever the Final Boss is
    */
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
        moveToward(k);
        update(k);
        updateSwordPosition();

        if(eSword != null) eSword.setAttacking(false);

        if(isTouching(Knight.class) && attackTime > 0){
            k.hitByFinalBoss();
            int pushDistance = 150;
            if(getX() > k.getX()){
                setLocation(getX() + pushDistance, getY()); 
            }else{
                setLocation(getX() - pushDistance, getY());
            }
        }
    }

    /**
     * Manages time for attacks & moving
    */
    private void update(Knight k){
        if(attackCooldown > 0){
            attackCooldown--;
        }
        if(attackTime > 0){
            attackTime--;
        }
        //Start attack
        if(isNear(k, 120) && attackCooldown == 0){
            startAttack();
            return;
        }

        if(attackTime > 0){
            return;
        }

        moveToward(k);
    }

    /**
     * Checks if Knight can be attacked
    */
    private boolean isNear(Actor a, int distance){
        return Math.abs(getX()- a.getX()) < distance && Math.abs(getY()- a.getY()) < distance;
    }

    /**
     * Makes boss walk towards the knight until minimum
    */
    private void moveToward(Knight k){
        int minDistance = 120;
        int dx = k.getX() - getX();
        int dy = k.getY() - getY();
        int distanceSquare = dx* dx + dy*dy;
        int minDisSquare = minDistance * minDistance;
        if(distanceSquare > minDisSquare){
            //Horizontal
            if(dx < 0){
                facingRight = false;
                setImage(standingLeft);
                setLocation(getX() - speed, getY());
            }else{
                facingRight = true;
                setImage(standingRight);
                setLocation(getX() + speed, getY());
            }
            //Vertical
            if(dy < 0){
                setLocation(getX(), getY() - speed);
            }else{
                setLocation(getX(), getY() + speed);
            }
        }
    }

    /**
     * Attack animation
    */
    private void startAttack(){
        attackTime = ATTACK_TIME_MAX;
        attackCooldown = ATTACK_COOLDOWN_MAX;
        if(facingRight){
            setImage(attackRight);
        }else{
            setImage(attackLeft);
        }
        if(eSword != null) eSword.setAttacking(false);
    }

    /**
     * Scale image
    */
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/4, img.getHeight()/4);
    }

    /**
     * Moves the sword & makes sure the sword moves with the boss
    */
    public void updateSwordPosition(){
        if(eSword == null) return;
        if(attackTime > 0){
            int swordX = facingRight ? 40 : -40;
            eSword.setLocation(getX() + swordX, getY() - 40);
        }else {
            int swordX = facingRight ? 10 : -10;
            eSword.setLocation(getX() + swordX, getY());
        }

        //Flip sword 
        if(facingRight != swordFacingRight) {
            eSword.setFacingRight(facingRight);
            swordFacingRight = facingRight;
        }

        if(attackTime == 0 && eSword != null){
            eSword.setAttacking(false);
        }
    }

    /**
     * Life Status
    */
    public boolean isDead(){
        return dead;
    }

    /**
     * Kill boss my removing it from world
    */
    public void takeDamage(){
        if (getWorld()!= null){
            getWorld().removeObject(this);
        }
    }

}
