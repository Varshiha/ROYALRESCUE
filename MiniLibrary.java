import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniLibrary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniLibrary extends Actor
{
    private GreenfootImage miniLibrary = new GreenfootImage("libraryMini.png");
    public MiniLibrary(){
        setImage(miniLibrary);
        scaleImage(miniLibrary);
    }
    
    /**
     * Act - do whatever the MiniLibrary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    private void scaleImage(GreenfootImage img){
        img.scale(img.getWidth()/2, img.getHeight()/2);
    }
}
