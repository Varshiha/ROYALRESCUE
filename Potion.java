import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends Actor
{
    private GreenfootImage potion = new GreenfootImage(".png");
    public Potion(){
        setImage(potion);
        scaleImage(potion);
    }
    
    public void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/3, img.getHeight()/3);
    }
}
