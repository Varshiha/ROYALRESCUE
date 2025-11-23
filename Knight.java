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
    private GreenfootImage imageRight1;
    private GreenfootImage imageRight2;
    private GreenfootImage imageLeft3;
    private GreenfootImage imageLeft4;
    //Attack images
    private GreenfootImage attackRight;
    private GreenfootImage attackLeft;
    //Movement
    private int speed = 3;
    //Jumping
    private int yVelocity = 0;
    private int gravity = 1;
    private int jumpStrength = -12;
    private boolean canDoubleJump = true;
    //Attack cooldown
    private int attackCooldown = 0;
    private int attackDuration = 0;// how long attack image stays
    public Knight(){
        //images
        imageRight1 = new GreenfootImage("KnightFace1.png");
        imageRight2 = new GreenfootImage("KnightFace2.png");
        imageLeft3 = new GreenfootImage("KnightFace1left.png");
        imageLeft4 = new GreenfootImage("KnightFace2left.png");
        
        
        //Scale images
        scaleImage(imageRight1);
        scaleImage(imageRight2);
        scaleImage(imageLeft3);
        scaleImage(imageLeft4);
        
        //Start with Knight facing right
        setImage(imageRight1);
        
        
    }
    /**
     * Act - do whatever the Knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleControls();
        applyGravity();
        handleJump();
        handleAttack();
        //Cooldown timer reduces every frame
        if(attackCooldown > 0){
           attackCooldown--; 
        }
    }
    
    public void handleControls(){
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(imageLeft3);
            move(-speed);
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            setImage(imageRight1);
            move(speed);
        }
    }
    
    private void applyGravity(){
        yVelocity += gravity; //Apply gravity every frame
        setLocation(getX(), getY() + yVelocity);
        
        if(getY() >= 380){
            setLocation(getX(), 380);
            yVelocity = 0;
        }
    }
    
    private boolean isOnGround(){
        return getY() >= 380;
    }
    
    private void handleJump(){
        if(Greenfoot.isKeyDown("space")){
            //First Jump
            if(isOnGround()){
               yVelocity = jumpStrength;
               canDoubleJump = true; //reset
            }
            //Second jump
            else if(canDoubleJump){
                yVelocity = jumpStrength;
                canDoubleJump = false;
            }
        }
    }
    
    private void handleAttack(){
        if(Greenfoot.isKeyDown("x") && attackCooldown == 0){
            //add sword swing animation
            hitEnemies();//Damage enemies
            attackCooldown = attackDuration;//Reset cooldown
            //reset to normal
            if(attackCooldown == 1){
                if(getImage() == attackLeft){
                    setImage(imageLeft3);
                }else{
                    setImage(imageRight1);
                }
            }
        }
    }
    
    private void hitEnemies(){
       //sword class, if touching...etc
       //Create enemy class(trolls and  goblins)
    }

    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/5, img.getHeight()/5);
    }
}
