import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingRoom extends World
{
    private int knightStartX;
    private int knightStartY;

    public KingRoom(int knightX, int knightY) {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(547, 554, 1); 

        addObject( new MiniLibrary(), 60, 130); 

        addObject(new DialogBox(), getWidth()/2, 455);
        addObject(new General(), 112, 455);

        showText("Hint: Look at the books...", 340, 455);
        knightStartX = knightX;
        knightStartY = knightY;

        setBackground(new GreenfootImage("King'sRoom.png"));

        prepare();
    }

    public KingRoom(){
        this(350,350);
    }

    private void prepare(){
        addObject(new Knight(), knightStartX, knightStartY);
    }

    public void act(){
        findBookCase();
    }

    public void findBookCase(){
        Knight k = (Knight)getObjects(Knight.class).get(0);
        MiniLibrary ml = k.ifTouchBookCase();
        if(ml != null){
            removeObject(ml);

            Greenfoot.setWorld(new Library());
        }

    }
}
