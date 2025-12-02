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
    private int attackCooldown = 0;//time before attacking again
    private int attackDuration = 0;// how long attack image stays
    private int attackTimer = 0;

    //Sword
    private Sword sword;
    private boolean facingRight = true;
    private boolean swordFacingRight = true;

    private int lives = 3;

    public boolean loseHeart = false;
    private Heart heart;

    private int score = 100;

    
    private int tollTouchCount = 0;
    
    

    private int initialScore = 100;

    private int trollTouchCount = 0;

    private boolean waitingToRestart = false;

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
        getWorld().showText("Troll Touch Count: " + trollTouchCount , 150, 530);
        handleControls();
        handleAttack();

        updateSwordPosition();
        //checkGameOver();
        gameOverWorld();
        restartLevel();
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

    private void handleAttack(){
        if(Greenfoot.isKeyDown("x") && attackCooldown == 0){
            if(facingRight){
                setImage(attackRight);
            }else{
                setImage(attackLeft);
            }
        } else{
            if(facingRight){
                setImage(rightHandDown);
            } else{
                setImage(leftHandDown);
            }
        }
    }

    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/5, img.getHeight()/5);
    }

    public void addedToWorld(World world){
        world.addObject(sword, getX(), getY());

    }

    public void updateSwordPosition(){
        if(Greenfoot.isKeyDown("x")){
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

    public void loseLife(){
        lives--;
        loseHeart = true;
    }

    public boolean loseHeart(){
        if(loseHeart == true){
            heart.emptyHeart();
        }
        return false;
    }

    public Potion touchPotion(){
        return (Potion)getOneIntersectingObject(Potion.class);
    }

    public MiniLibrary ifTouchBookCase(){
        return (MiniLibrary)getOneIntersectingObject(MiniLibrary.class);
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
        if(getLostPoints() >= 50 || trollTouchCount == 5){
            waitingToRestart = true;
            World current = getWorld();
            current.showText("Level Restart! Press R to restart again", current.getWidth()/2, current.getHeight()/2);
            Greenfoot.delay(80);
            if(waitingToRestart && Greenfoot.isKeyDown("r")){
                try{
                World reset = current.getClass().newInstance();
                Greenfoot.setWorld(reset);
            }catch(Exception e){
                Greenfoot.stop(); 
            }
            }
        }
    }

    public void increaseTrollTouchCount(){
        trollTouchCount ++;
    }

}
