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
        if(canDamage){
            attackCheck();
        }
    }

    public void collision(boolean enable, Knight k){
        canDamage = enable;
        knight = k;
    }

    private void attackCheck(){
        World w = getWorld();
        if(w == null) return;

        List<Knight> knights = w.getObjects(Knight.class);
        if(knights.isEmpty()) return;

        Knight k = knights.get(0);

        // Damage trolls
        Troll t = (Troll) getOneIntersectingObject(Troll.class);
        if(t != null){
            w.removeObject(t);
            k.increaseScore();
           
        }
        if (!canDamage || knight == null) return;

        FinalBoss fb = (FinalBoss)getOneIntersectingObject(FinalBoss.class);
        if (fb != null && !knight.getHitThisAttack()) {
            knight.hitFinalBoss(fb);
            
            knight.setHitThisAttack(true); 
        }
    }
    }
