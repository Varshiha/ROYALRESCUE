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

    //Attack timing
    private int attackCooldown = 0;//time before attacking again
    private int attackDuration = 0;// how long attack image stays
    private final int ATTACK_COOLDOWN_MAX = 25;
    private final int ATTACK_DURATION_MAX =8;

    //Sword
    private Sword sword;
    private boolean facingRight = true;
    private boolean swordFacingRight = true;

    public static int lives = 3;
    public static int score = 100;
    public static int initialScore = 100;

    public boolean loseHeart = false;
    private Heart heart;

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
        getWorld().showText("Lives: " + lives , 80, 510);
        getWorld().showText("Score: " + score , 200, 510);
        getWorld().showText("Consec Hits: " + consecutiveTrollHits , 150, 530);

        handleControls();
        handleAttackTiming();
        updateSwordPosition();

        gameOverWorld();
        restartLevel();
    }

    public void handleControls(){
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            facingRight = false;
            setImage(leftHandDown);
            move(-speed);
        }else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            facingRight = true;
            setImage(rightHandDown);
            move(speed);
        }

        if(Greenfoot.isKeyDown("up")|| Greenfoot.isKeyDown("w")){ 
            setLocation(getX(), getY() -speed);
        }else if(Greenfoot.isKeyDown("down")|| Greenfoot.isKeyDown("s")){ 
            setLocation(getX(), getY()+speed);
        }
    }

    private void handleAttackTiming(){
        if(attackCooldown > 0) attackCooldown--;
        if(attackDuration > 0) attackDuration--;

        if(Greenfoot.isKeyDown("x") && attackCooldown == 0){
            startAttack();
        } 

        if(attackDuration > 0){
            if(facingRight)setImage(attackRight);
            else setImage(attackLeft);
        } else{
            if(facingRight)setImage(rightHandDown);
            else setImage(leftHandDown);
        }
    }

    private void startAttack(){
        attackDuration = ATTACK_DURATION_MAX;
        attackCooldown = ATTACK_COOLDOWN_MAX;
        
        consecutiveTrollHits = 0;
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
        if(sword == null) return;
        if(attackDuration > 0) {
            int swordXAttackDistance = facingRight ? 40 : -40;
            int yPosition = -40;
            sword.setLocation(getX() + swordXAttackDistance, getY() + yPosition);
        }
        else {
            int swordXDistance = facingRight ? 10 : -10;
            sword.setLocation(getX() + swordXDistance, getY());
        }

        if(facingRight != swordFacingRight) {
            sword.getImage().mirrorHorizontally();
            swordFacingRight = facingRight;
        }
    }

    public void loseLife(){
        lives--;
        consecutiveTrollHits = 0;
        
    }

    public boolean loseHeart(){
        if(loseHeart == true){
            heart.emptyHeart();
        }
        return false;
    }

    public PowerUp touchPowerUp(){
        return (PowerUp)getOneIntersectingObject(PowerUp.class);
    }

    public Potion touchPotion(){
        return (Potion)getOneIntersectingObject(Potion.class);

    }

    public MiniLibrary ifTouchBookCase(){
        return (MiniLibrary)getOneIntersectingObject(MiniLibrary.class);
    }

    public void increaseScore(){
        score += 7;
        consecutiveTrollHits = 0;
    }
    
    public void increaseScore(int amount){
        score += amount;
        if(score < 0) {
            score = 0;
        }
    }

    public void decreaseScore(int amount){
        score -=amount;
        if(score < 0) score = 0;
    }

    public int getScore(){
        return score;
    }

    public int getLostPoints(){
        return initialScore - score;
    }

    public void onHitByTroll(int damage){
        decreaseScore(damage);
        consecutiveTrollHits++;
        if(consecutiveTrollHits >= 5){
            loseLife();
            consecutiveTrollHits = 0;
        }
    }
    
    public void gameOverWorld(){
        if(score <= 0){
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void restartLevel(){
        if(!waitingToRestart && (getLostPoints() >= 50 ||consecutiveTrollHits >= 5)){
            waitingToRestart = true;
            getWorld().showText("Level Restart! Press SPACE to try again", getWorld().getWidth()/2, getWorld().getHeight()/2);
            return;
        }

        if(waitingToRestart && Greenfoot.isKeyDown("SPACE")){
            try{
                World reset = getWorld().getClass().newInstance();
                Greenfoot.setWorld(reset);

                lives = 3;
                score = 100;
                initialScore = 100;
                consecutiveTrollHits = 0;
                waitingToRestart = false;
            } catch(Exception e){
                Greenfoot.stop();
            }
        }
    }

    public void increaseTrollTouchCount(){
        
    }

}
