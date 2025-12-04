import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Actor
{
    //Different images of the Knight
    private GreenfootImage rightHandDown = new GreenfootImage("KnightFace1.png");
    private GreenfootImage rightHandMiddle = new GreenfootImage("KnightFace2.png");
    private GreenfootImage leftHandDown= new GreenfootImage("KnightFace1l.png");
    private GreenfootImage leftHandMiddle = new GreenfootImage("KnightFace2l.png");

    //Attack images of the Knight
    private GreenfootImage attackRight = new GreenfootImage("KnightFace3.png");
    private GreenfootImage attackLeft = new GreenfootImage("KnightFace3l.png");

    //How fast the Knight moves
    private int speed = 3;

    //Attack cooldown
    private int attackCooldown = 0;
    private int attackTimer = 0;
    private final int ATTACK_COOLDOWN_MAX = 25;
    private final int ATTACK_TIMER_MAX = 8;

    //Sword
    private Sword sword;
    private boolean facingRight = true;
    private boolean swordFacingRight = true;

    public boolean loseHeart = false;
    private Heart heart;

    public static int score = 100;
    public static int initialScore = 100;

    public static boolean waitingToRestart = false;
    public int consecutiveTrollHits = 0;

    public Knight(){
        //Scale images
        scaleImage(rightHandDown);
        scaleImage(rightHandMiddle);
        scaleImage(leftHandDown);
        scaleImage(leftHandMiddle);
        scaleImage(attackRight);
        scaleImage(attackLeft);

        //Start with Knight facing right
        setImage(rightHandDown);

        sword = new Sword();
    }

    /**
     * Act - do whatever the Knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().showText("Score: " + score , 80, 510);
        getWorld().showText("Troll Consecutive Hits: " + consecutiveTrollHits , 150, 530);
        handleControls();
        handleAttackTiming();

        updateSwordPosition();
        //checkGameOver();
        gameOverWorld();
        
        if(consecutiveTrollHits == 10){
            restartLevel();
        }
    }

    public void handleControls(){
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            facingRight = false;
            setImage(leftHandDown);
            move(-speed);
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            facingRight = true;
            setImage(rightHandDown);
            move(speed);
        }

        if(Greenfoot.isKeyDown("up")|| Greenfoot.isKeyDown("w")){ 
            setLocation(getX(), getY() -speed);
        }
        if(Greenfoot.isKeyDown("down")|| Greenfoot.isKeyDown("s")){ 
            setLocation(getX(), getY()+speed);
        }
    }

    private void handleAttackTiming(){
        if(attackCooldown > 0){
            attackCooldown--;
        }

        if(attackTimer > 0){
            attackTimer--;
        }

        if(Greenfoot.isKeyDown("x") && attackCooldown == 0){
            startAttack();
        }

        if(attackTimer > 0){
            if(facingRight){
                setImage(attackRight);
            }else{
                setImage(attackLeft);
            }
        }else{
            if(facingRight){
                setImage(rightHandDown);
            } else{
                setImage(leftHandDown);
            }
        }
    }

    private void startAttack(){
        attackTimer = ATTACK_TIMER_MAX;
        attackCooldown = ATTACK_COOLDOWN_MAX;
    }

    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/5, img.getHeight()/5);
    }

    public void addedToWorld(World world){
        if(sword.getWorld() == null){
            world.addObject(sword, getX(), getY());
        }
    }

    public void updateSwordPosition(){
        if(sword == null){
            return;
        }
        if(attackTimer > 0){
            int swordXAttackDistance = facingRight ? 40 : -40;
            int yPosition = -40;
            sword.setLocation(getX() + swordXAttackDistance, getY() + yPosition);
        }else {
            int swordXDistance = facingRight ? 10 : -10;
            sword.setLocation(getX() + swordXDistance, getY());
        }

        if(facingRight != swordFacingRight) {
            sword.getImage().mirrorHorizontally();
            swordFacingRight = facingRight;
        }
    }

    public void increaseScore(){
        score += 5;
    }

    public void decreaseScore(int amount){
        score -=amount;
    }

    public int getScore(){
        return score;
    }

    public int getLostPoints(){
        return initialScore - score;
    }

    public void gameOverWorld(){
        if(score <= 0){
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void restartLevel(){
        World current = getWorld();
        World newWorld = null;
        
        try{
            newWorld = current.getClass().getDeclaredConstructor().newInstance();
        }
        catch(Exception e){
            System.out.println("Could not restart world: " + e);
            return;
        }
        
        Greenfoot.setWorld(newWorld);
    }
    
    public void consecutiveTrollHits(){
        consecutiveTrollHits++;
    }

    public PowerUp touchPowerUp(){
        return (PowerUp)getOneIntersectingObject(PowerUp.class);
    }

    public MiniLibrary ifTouchBookCase(){
        return (MiniLibrary)getOneIntersectingObject(MiniLibrary.class);
    }

}
