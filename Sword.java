import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Sword extends Actor
{
    private boolean canDamage = false;
    private Knight knight;
    
    public Sword(){
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4);
    }

    public void act()
    {
        if(canDamage && knight != null){
            damageTrolls();
            damageFinalBoss();
        }
    }

    public void collision(boolean enable, Knight k){
        canDamage = enable;
        knight = k;
    }

    private void damageTrolls(){
        Troll t = (Troll) getOneIntersectingObject(Troll.class);
        if(t != null){
            t.die();
        }
    }
    
    private void damageFinalBoss(){
        FinalBoss fb = (FinalBoss)getOneIntersectingObject(FinalBoss.class);
        if (fb != null && !knight.getHitThisAttack()) {
            knight.hitFinalBoss(fb);
            knight.setHitThisAttack(true); 
        }
    }
    
}
