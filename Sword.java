import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{

    public Sword(){
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4);
    }

    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        attackCheck();
    }

    public void attackCheck(){
        if(!Greenfoot.isKeyDown("x")) {
            return;
        }
        World w = getWorld();
        if(w == null) return;
        List<Knight> knights = w.getObjects(Knight.class);
        if(knights.isEmpty()) return;
        Knight k = knights.get(0);
        
        if(isTouching(Troll.class)){
            removeTouching(Troll.class);
            k.increaseScore();
        }
        
        List<FinalBoss> bosses = w.getObjects(FinalBoss.class);
        if(!bosses.isEmpty()){
            FinalBoss fb = bosses.get(0);
            if(isTouching(FinalBoss.class)){
                fb.loseLife();
                k.increaseScore(7);
                if(fb.isDead()){
                    w.removeObject(fb);
                    
                    List<EvilSword> swords = w.getObjects(EvilSword.class);
                    for(EvilSword es : swords){
                        if(es.getX() >= fb.getX()- 50 && es.getX() <= fb.getX() + 50){
                            w.removeObject(es);
                        }
                    }
                }
            }
        }
        
        
    }

    public void killFinalBoss(){
        List<FinalBoss> bosses = getWorld().getObjects(FinalBoss.class);
        if(bosses.isEmpty()) return;
        FinalBoss fb = bosses.get(0);
        if(isTouching(FinalBoss.class)){
            fb.loseLife();
        }
        
    }
}
