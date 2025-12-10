import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Actor
{
    //Knight images
    private GreenfootImage rightHandDown = new GreenfootImage("KnightFace1.png");
    private GreenfootImage leftHandDown= new GreenfootImage("KnightFace1l.png");
    private GreenfootImage attackRight = new GreenfootImage("KnightFace3.png");
    private GreenfootImage attackLeft = new GreenfootImage("KnightFace3l.png");
    //Movement/Attack Speed
    public int speed = 4;

    //Sword Attack
    private int attackCooldown = 0;//prevent spamming attack
    private int attackDuration = 0;//how long the sword stays after pressing attack
    private final int ATTACK_COOLDOWN_MAX = 25;
    private final int ATTACK_DURATION_MAX =8;
    private Sword sword;
    private boolean facingRight = true;//Knight direction
    private boolean swordFacingRight = true;//Sword direction

    //Prevents the Knight from hitting the final boss multiple times in one animation
    private boolean hitThisAttack = false;

    //Scoring System
    public static int score = 0;
    
    //Final Boss hit tracker
    public int hitsOnFinalBoss = 0;//how many time Knight hit the boss
    public final int hitsRequired = 15; // hits needed to kill boss(game won)
    public int hitsByFinalBoss = 0;//how many times the boss hits you
    public final int maxBossHits = 20;//Knight loses after 20 hits(game over)
    
    //Troll Tracking
    public int trollHits = 0;//Amount of times the trols hit Knight

    //Restart Control
    public static boolean waitingToRestart = false;
    private boolean waitingForRestart = false;
    private GreenfootImage restartOverlay;
    
    //Sword Sound
    private GreenfootSound slash = new GreenfootSound("slash.wav");

    /**
     * Constructor
     */
    public Knight(){
        scaleImage(rightHandDown);
        scaleImage(leftHandDown);
        scaleImage(attackRight);
        scaleImage(attackLeft);

        setImage(rightHandDown);

        sword = new Sword();
    }

    /**
     * Act - do whatever the Knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(!waitingToRestart){
            handleControls();
            handleAttackTiming();  
        }

        updateSwordPosition();
        showStats();

        checkPowerUp();
        checkRestartInput();
    }

    /**
     * Movement
     */
    public void handleControls(){
        //Left & Right
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            facingRight = false;
            if(attackDuration == 0)setImage(leftHandDown);
            move(-speed);
        }else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            facingRight = true;
            if(attackDuration == 0)setImage(rightHandDown);
            move(speed);
        }
        //Up & Down
        if(Greenfoot.isKeyDown("up")|| Greenfoot.isKeyDown("w")){ 
            setLocation(getX(), getY() -speed);
        }else if(Greenfoot.isKeyDown("down")|| Greenfoot.isKeyDown("s")){ 
            setLocation(getX(), getY()+speed);
        }
    }

    /**
     * Attack
     */
    private void handleAttackTiming(){
        if(attackCooldown > 0) attackCooldown--;
        if(attackDuration > 0) attackDuration--;

        if(Greenfoot.isKeyDown("x") && attackCooldown == 0){
            startAttack();
            slash.play();
            hitThisAttack= false;
        } 

        if(attackDuration > 0){
            setImage(facingRight ? attackRight : attackLeft);
            //Sword collision happens when attack
            sword.collision(true, this);
        } else{
            setImage(facingRight ? rightHandDown : leftHandDown);
            sword.collision(false, null);
        }
    }

    /**
     * Attack
     */
    private void startAttack(){
        attackDuration = ATTACK_DURATION_MAX;
        attackCooldown = ATTACK_COOLDOWN_MAX;
    }

    /**
     * Scale image
     */
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/5, img.getHeight()/5);
    }

    /**
     * Sword goes where Knight goes
     */
    public void addedToWorld(World world){
        if(sword.getWorld() == null){
            world.addObject(sword, getX(), getY());
        }
    }

    /**
     * Sword position
     */
    public void updateSwordPosition(){
        if(sword == null) return;

        int swordX;
        int swordY;
        if(attackDuration > 0) {
            swordX = facingRight ? 40 : -40;
            swordY = -40;
        }
        else {
            swordX = facingRight ? 10 : -10;
            swordY = 0;
        }

        sword.setLocation(getX() + swordX, getY() + swordY);

        //Mirror sword
        if(facingRight != swordFacingRight) {
            sword.getImage().mirrorHorizontally();
            swordFacingRight = facingRight;
        }
    }

    /**
     * Text on screen
     */
    public void showStats(){
        getWorld().showText("Score: " + score, 150, 510);
        getWorld().showText("Troll Hits: " + trollHits, 150, 530);
    }

    /**
     * Restar level
     */
    private void restartCurrentWorld(){
        World currentWorld = getWorld();
        try {
            World newWorld = currentWorld.getClass().getDeclaredConstructor(int.class, int.class).newInstance(getX(), getY());
            Greenfoot.setWorld(newWorld);
        } catch (Exception e) {
            e.printStackTrace();
        }

        trollHits = 0;
        waitingForRestart = false;
        Knight.waitingToRestart = false;
    }

    /**
     * Why restart happens
     */
    public void onHitByTroll(){
        if(waitingForRestart) {
            return;
        }
        trollHits++;
        if(trollHits >= 20){
            trollHits = 0;
            waitingForRestart = true;
            Knight.waitingToRestart = true;
            showRestartMessage();
        }
    }

    /**
     * Restart message
     */
    private void showRestartMessage() {
        World world = getWorld();
        if(world == null) {
            return;
        }
        GreenfootImage overlay = new GreenfootImage(world.getWidth(), world.getHeight());
        overlay.setColor(new Color(0, 0, 0, 180)); // semi-transparent black
        overlay.fill();

        overlay.setColor(Color.WHITE);
        overlay.setFont(new Font("Arial", 24));
        overlay.drawString("Restart Level!\nTroll Hits: 20\nPress R to continue",
            world.getWidth()/4, world.getHeight()/2);

        world.getBackground().drawImage(overlay, 0, 0);

        waitingToRestart = true;
        waitingForRestart = true;
    }

    /**
     * Press R to to call restartCurrentWorld method
     */
    public void checkRestartInput(){
        if(waitingForRestart && Greenfoot.isKeyDown("r")){
            restartCurrentWorld();
        }
    }

    /**
     * Power Up
     */
    public void checkPowerUp(){
        PowerUp p = (PowerUp)getOneIntersectingObject(PowerUp.class);
        if(p != null){
            World currentWorld = getWorld();
            if(currentWorld instanceof Castle){
                ((Castle)currentWorld).potionFound(this, p);
            }
        }
    }
    
    /**
     * Potion
     */
    public Potion touchPotion(){
        return (Potion)getOneIntersectingObject(Potion.class);
    }

    /**
     * Library interaction
     */
    public MiniLibrary ifTouchBookCase(){
        return (MiniLibrary)getOneIntersectingObject(MiniLibrary.class);
    }
    
    /**
     * Score
     */
    public static void increaseScore(){
        score ++;
    }

    /**
     * Score
     */
    public static void decreaseScore(){
        score --;
    }

    /**
     * Score
     */
    public static int getScore(){
        return score;
    }

    /**
     * Final Battle
     */
    public void hitFinalBoss(FinalBoss boss){
        hitsOnFinalBoss++;
        score += 10;
        
        if(hitsOnFinalBoss >= hitsRequired){
            getWorld().removeObject(boss);
            saveking();
        }
    }

    /**
     * Final Battle
     */
    public void hitByFinalBoss(){
        score-=5;
        hitsByFinalBoss++;
        if(hitsByFinalBoss >= maxBossHits){
            gameOver();
        }
    }

    /**
     * Final Battle
     */
    public void gameOver(){
        Greenfoot.setWorld(new GameOver());
    }

    /**
     * Final Battle
     */
    public void gameWon(){
        Greenfoot.setWorld(new GameWin());
    }

    /**
     * Final Battle
     */
    public int getHitsRequired() {
        return hitsRequired; 
    }

    /**
     * Final Battle
     */
    public int getHitsOnFinalBoss() {
        return hitsOnFinalBoss; 
    }

    /**
     * Final Battle
     */
    public void saveking(){
        List<KingLocked> kg = getWorld().getObjects(KingLocked.class);
        if(!kg.isEmpty()){
            KingLocked locked = kg.get(0);
            getWorld().removeObject(locked);
            King newKing = new King();
            getWorld().addObject(newKing, 520, 59);
        }
    }
    
    /**
     * Final Battle
     */
    public boolean getHitThisAttack() {
        return hitThisAttack;
    }

    /**
     * Final Battle
     */
    public void setHitThisAttack(boolean value) {
        hitThisAttack = value;
    }

    /**
     * Final Battle
     */
    public int getBossHits(){
        return hitsByFinalBoss;
    }

    /**
     * Final Battle
     */
    public int getMaxBossHits(){
        return maxBossHits;
    }

}