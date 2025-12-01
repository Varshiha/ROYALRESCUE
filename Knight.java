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
        
        handleControls();
        handleAttack();
        //Cooldown timer reduces every frame
        //0 means attack again
        if(attackCooldown > 0){
           attackCooldown--; 
        }
        
        if(attackTimer > 0){
           attackTimer--; 
        }
        
        updateSwordPosition();
        checkGameOver();
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
        getWorld().showText("Lives: " + lives , 100, 510);
        loseHeart = true;
    }
    
    public boolean loseHeart(){
        if(loseHeart == true){
            heart.emptyHeart();
        }
        return false;
    }
    
    public void checkGameOver(){
        if(lives <= 0){
            World current = getWorld();
            current.showText("Game Over : Restart Level", current.getWidth()/2, current.getHeight()/2);
            Greenfoot.delay(80);
            try{
                World reset = current.getClass().newInstance();
                Greenfoot.setWorld(reset);
            }catch(Exception e){
               Greenfoot.stop(); 
            }
        }
    }
}
