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
    private boolean canDamage = false;

    public Sword(){
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4);
        //Greenfoot.playSound("sfx.wav");
    }

    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(canDamage){
            attackCheck();
        }
    }

    public void collision(boolean enable){
        canDamage = enable;
    }

    public void attackCheck(){
        World w = getWorld();
        if(w == null) return;

        List<Knight> knights = w.getObjects(Knight.class);
        Knight k = null;
        if(!knights.isEmpty()){
            k = knights.get(0);
        }
        //Damage trolls
        Troll t = (Troll) getOneIntersectingObject(Troll.class);
        if(t != null){
            getWorld().removeObject(t);
            if(k != null) k.increaseScore();
        }

        //Damage final boss
        if(isTouching(FinalBoss.class)){
            List<FinalBoss> b = w.getObjects(FinalBoss.class);
            for(FinalBoss f : b){
                f.takeDamage();
                if(k != null) k.increaseScore();
            }

            List<FinalBoss> fb = w.getObjects(FinalBoss.class);
            if(fb.isEmpty()){
                List<EvilSword> es = w.getObjects(EvilSword.class);
                for(EvilSword e : es){
                    w.removeObject(e);
                }
            }
        }
    }
}
