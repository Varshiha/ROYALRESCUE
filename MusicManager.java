import greenfoot.*;
/**
 * Write a description of class MusicManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicManager  
{
    // instance variables - replace the example below with your own
    private static boolean musicStarted = false;

    /**
     * Constructor for objects of class MusicManager
     */
    public MusicManager()
    {
    }
public static void playBackGroundMusic(String soundFile){
    if(!musicStarted){
        Greenfoot.playSound(soundFile);
        musicStarted = true;
    }
}
}
