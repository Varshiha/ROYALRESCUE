import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    private GreenfootImage potion = new GreenfootImage("PowerUp.png");
    public PowerUp(){
        setImage(potion);
        scaleImage(potion);
    }
    
    public void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/6, img.getHeight()/6);
    }
}
