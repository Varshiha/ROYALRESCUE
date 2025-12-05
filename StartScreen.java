import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends World
{
    private int timer = 120;
    private GreenfootImage imageBackground; 
    
    public StartScreen()
    {    
        super(547, 554, 1); 
        GreenfootImage bg = new GreenfootImage("GameLogo.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        imageBackground = new GreenfootImage("BackgroundLogo.png");
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            setBackground(imageBackground);
            showText("Welcome to Royal Rescue! \n" + 
                     "The purpose of this game is to defeat \n" + 
                     "all the trolls and save the king. \n" + 
                     "You will have to face challenges such as \n" +
                     "solving riddles and killing mean guys. \n" + 
                     "Press ENTER to go to the tutorial",
                     getWidth()/2, getHeight()/2);
            
            if(Greenfoot.isKeyDown("enter")){
    int startX = 50;  // choose a default starting X
    int startY = 50;  // choose a default starting Y
    Greenfoot.setWorld(new TrainingGrounds(startX, startY));
}
        }
    }
}
