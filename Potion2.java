import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion2 extends Actor
{
    private GreenfootImage potion = new GreenfootImage("KingHead.png");
    private BookOpen2 bo = new BookOpen2();
    public Potion2(){
        setImage(potion);
        scaleImage(potion);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
           String playerAnswer = Greenfoot.ask("What is your answer?");
            if (playerAnswer.equalsIgnoreCase("Guacamole")) {
                // Do something if the answer is correct
                Greenfoot.setWorld(new DarkForest());
            } else {
                // Do something if the answer is incorrect
                Greenfoot.setWorld(new BookOpen2());
                
            }
        }
        
    }
    
    public void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }
}
