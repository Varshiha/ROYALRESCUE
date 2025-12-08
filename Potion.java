import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Potion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potion extends Actor
{
    private GreenfootImage potion = new GreenfootImage("KingHead.png");
    public Potion(){
        setImage(potion);
        scaleImage(potion);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new BookOpen2());
        }
    }

    public void question(){
        if(Greenfoot.mouseClicked(this)){
            String playerAnswer = Greenfoot.ask("What is your answer?");
            if (playerAnswer.equalsIgnoreCase("correct")) {
                int startX = 50;  // choose a default starting X
                int startY = 50;  // choose a default starting Y
                Greenfoot.setWorld(new Cave(startX, startY));

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
