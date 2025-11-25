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
    private GreenfootImage imageRight5;
    private GreenfootImage imageLeft6;
    //Attack images of the Knight
    private GreenfootImage attackRight;
    private GreenfootImage attackLeft;
    //How fast the Knight moves
    private int speed = 3;
    //Jumping
    private int yVelocity = 0;//How fast Knight moving vertically
    private int gravity = 1;//To pull the Knight down
    private int jumpStrength = -12;//To push upward
    private boolean canDoubleJump = true;
    //Attack cooldown
    private int attackCooldown = 0;//time before attacking again
    private int attackDuration = 0;// how long attack image stays
    public Knight(){
        //images
        imageRight1 = new GreenfootImage("KnightFace1.png");
        imageRight2 = new GreenfootImage("KnightFace2.png");
        imageLeft3 = new GreenfootImage("KnightFace1l.png");
        imageLeft4 = new GreenfootImage("KnightFace2l.png");
        imageRight5 = new GreenfootImage("KnightFace3.png");
        imageLeft6 = new GreenfootImage("KnightFace3l.png");
        
        
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
        //applyGravity();
        handleJump();
        handleAttack();
        //Cooldown timer reduces every frame
        //0 means attack again
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
        
         if(Greenfoot.isKeyDown("up")){ 
             setLocation(getX(), getY()-5);
        }
        if(Greenfoot.isKeyDown("down")){ 
            setLocation(getX(), getY()+5);
        }
    }
    
    //private void applyGravity(){
        //yVelocity += gravity; //Apply gravity every frame
        //Get current y and Velocity, + = down, - = up
       // setLocation(getX(), getY() + yVelocity);
        
       // if(getY() >= 380){//passed floor
           // setLocation(getX(), 380);//bring to ground
            //yVelocity = 0;
        //}
     // }
    
    private boolean isOnGround(){
        return getY() >= 380;//floor height = true
    }
    
    private void handleJump(){
        if(Greenfoot.isKeyDown("space")){
            //First Jump
            if(isOnGround()){
               yVelocity = jumpStrength;//up
               canDoubleJump = true; //reset
            }
            //Second jump
            else if(canDoubleJump){//not on ground
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
