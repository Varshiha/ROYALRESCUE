import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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

    private int speed = 4;
    
    private int attackCooldown = 0;
    private int attackDuration = 0;
    private final int ATTACK_COOLDOWN_MAX = 25;
    private final int ATTACK_DURATION_MAX =8;

    private Sword sword;
    private boolean facingRight = true;
    private boolean swordFacingRight = true;

    private boolean hitThisAttack = false;

    public static int score = 0;
    public int hitsOnFinalBoss = 0;
    public final int hitsRequired = 10; 

    public static int initialScore = 100;
    public int consecutiveTrollHits = 0;

    public static boolean waitingToRestart = false;
    private boolean waitingForRestart = false;
    private GreenfootImage restartOverlay;
    public int hitsByFinalBoss = 0;
    public final int maxBossHits = 20; 

    public boolean getHitThisAttack() {
        return hitThisAttack;
    }

    public void setHitThisAttack(boolean value) {
        hitThisAttack = value;
    }

    public int getBossHits(){
        return hitsByFinalBoss;
    }

    public int getMaxBossHits(){
        return maxBossHits;
    }

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
saveking();
        checkRestartInput();
    }

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

    private void startAttack(){
        attackDuration = ATTACK_DURATION_MAX;
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

    private void showStats(){
        getWorld().showText("Score: " + score, 200, 510);
        getWorld().showText("Consecutive Hits: " + consecutiveTrollHits, 150, 530);
    }

    private void restartCurrentWorld(){
        World currentWorld = getWorld();
        try {
            World newWorld = currentWorld.getClass()
                .getDeclaredConstructor(int.class, int.class)
                .newInstance(getX(), getY());
            Greenfoot.setWorld(newWorld);
        } catch (Exception e) {
            e.printStackTrace();
        }

        consecutiveTrollHits = 0;
        waitingForRestart = false;
        Knight.waitingToRestart = false;
    }

    public void onHitByTroll(){
        if(waitingForRestart) return;

        consecutiveTrollHits++;
        if(consecutiveTrollHits >= 20){
            consecutiveTrollHits = 0;
            waitingForRestart = true;
            Knight.waitingToRestart = true;
            showRestartMessage();
        }
    }

    private void showRestartMessage() {
        World world = getWorld();
        if(world == null) return;

        GreenfootImage overlay = new GreenfootImage(world.getWidth(), world.getHeight());
        overlay.setColor(new Color(0, 0, 0, 180)); // semi-transparent black
        overlay.fill();

        overlay.setColor(Color.WHITE);
        overlay.setFont(new Font("Arial", 24));
        overlay.drawString("Restart Level!\nConsecutive Hits: 20\nPress R to continue",
            world.getWidth()/4, world.getHeight()/2);

        world.getBackground().drawImage(overlay, 0, 0);

        waitingToRestart = true;
        waitingForRestart = true;
    }

    public void checkRestartInput(){
        if(waitingForRestart && Greenfoot.isKeyDown("r")){
            restartCurrentWorld();
        }
    }

    public Potion touchPotion(){
        return (Potion)getOneIntersectingObject(Potion.class);

    }

    public MiniLibrary ifTouchBookCase(){
        return (MiniLibrary)getOneIntersectingObject(MiniLibrary.class);
    }

    public void hitFinalBoss(FinalBoss boss){
        hitsOnFinalBoss++;
        score += 5;
        if(hitsOnFinalBoss >= hitsRequired){
            getWorld().removeObject(boss);
            saveking();
        }else{
            getWorld().showText("Hits: " + hitsOnFinalBoss + " / " + hitsRequired, 200, 20);
        }
    }

    public void hitByFinalBoss(){
        score-=10;
        if(score<0){
            score = 0;
        }

        hitsByFinalBoss++;
        if(hitsByFinalBoss >= maxBossHits){
            gameOver();
        }
    }

    public void gameOver(){
        MusicManager.stopMusic();
        Greenfoot.setWorld(new GameOver());
    }

    public void gameWon(){
        MusicManager.stopMusic();
        Greenfoot.setWorld(new GameWin());
    }

    public void increaseScore(){
        score ++;

    }

    public void decreaseScore(){
        score --;
        if(score < 0) score = 0;
    }

    public int getScore(){
        return score;
    }

    public int getHitsRequired() {
        return hitsRequired; 
    }

    public int getHitsOnFinalBoss() {
        return hitsOnFinalBoss; 
    }

    public void saveking(){
        Actor kg = getOneIntersectingObject(KingLocked.class);
        if(kg != null){
            getWorld().removeObject(kg);
            getWorld().addObject(new King(), 520, 59);
            Actor k = getOneIntersectingObject(King.class);
            if(isTouching(King.class)){
                
                Greenfoot.setWorld(new GameWin());
            }
        }
    }

}