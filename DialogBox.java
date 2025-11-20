import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogBox extends Actor
{
    private GreenfootImage image1;
    
    public DialogBox(){
        image1 = new GreenfootImage("DialogBox.png");
        setImage(image1);
        GreenfootImage DialogBox = getImage();
        image1.scale(DialogBox.getWidth()/2, DialogBox.getHeight()/2);
        setImage(DialogBox);
        
    }
    
    /**
     * Act - do whatever the DialogBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
