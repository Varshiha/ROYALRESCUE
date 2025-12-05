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
    private static boolean isPlaying = false;
    private static GreenfootSound bg = new GreenfootSound("WF.wav");

public static void startMusic(){
    if(!isPlaying){
        bg.playLoop();
        isPlaying = true;
    }
}

public static void stopMusic(){
    if(isPlaying){
        bg.stop();
        isPlaying = false;
    }
}
}
