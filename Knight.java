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
    private int attackTimer = 0;
    public Knight(){
        //images
        imageRight1 = new GreenfootImage("KnightFace1.png");
        //imageRight2 = new GreenfootImage("KnightFace2.png");
        imageLeft3 = new GreenfootImage("KnightFace1l.png");
        //imageLeft4 = new GreenfootImage("KnightFace2l.png");
        
        attackRight = new GreenfootImage("KnightFace3.png");
        attackLeft = new GreenfootImage("KnightFace3l.png");
        
        
        //Scale images
        scaleImage(imageRight1);
        //scaleImage(imageRight2);
        scaleImage(imageLeft3);
<<<<<<< Updated upstream
        //scaleImage(imageLeft4);
        scaleImage(attackRight);
        scaleImage(attackLeft);

=======
        scaleImage(imageLeft4);
        scaleImage(imageRight5);
        scaleImage(imageLeft6);
>>>>>>> Stashed changes
        
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
        handleJump();
        applyGravity();
        handleAttack();
        //Cooldown timer reduces every frame
        //0 means attack again
        if(attackCooldown > 0){
           attackCooldown--; 
        }
        
        if(attackTimer > 0){
           attackTimer--; 
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
        
         if(Greenfoot.isKeyDown("up")|| Greenfoot.isKeyDown("w")){ 
             setLocation(getX(), getY()-speed);
             yVelocity = 0;
             return;
        }
        if(Greenfoot.isKeyDown("down")|| Greenfoot.isKeyDown("s")){ 
            setLocation(getX(), getY()+speed);
            yVelocity = 0;
            return;
        }
    }
    
    private void applyGravity(){
        yVelocity += gravity; //Apply gravity every frame
        //Get current y and Velocity, + = down, - = up
       setLocation(getX(), getY() + yVelocity);
        
       if(getY() >= 380){//passed floor
         setLocation(getX(), 380);//bring to ground
            yVelocity = 0;
        }
     }
    
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
            //reset to normal
            if(attackCooldown == 1){
                if(getImage() == attackLeft){
<<<<<<< Updated upstream
                    setImage(attackLeft);
                }else{
                    setImage(attackRight);;
=======
                    setImage(imageLeft6);
                }else{
                    setImage(imageRight5);
>>>>>>> Stashed changes
                }
            }
            //add sword swing animation
            hitEnemies();//Damage enemies
            attackCooldown = attackDuration;
        }
    }
    
    private void hitEnemies(){
       Actor enemy = getOneIntersectingObject(Troll.class);
       if(enemy != null){
           getWorld().removeObject(enemy);
       }
    }

    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/5, img.getHeight()/5);
    }
}
