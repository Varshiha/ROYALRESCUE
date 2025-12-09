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
    private static GreenfootSound win = new GreenfootSound("win.wav");
    private static GreenfootSound over = new GreenfootSound("Game Over.wav");

public static void startBgMusic(){
    if(!isPlaying){
        bg.playLoop();
        isPlaying = true;
    }
}

public static void stopBgMusic(){
    if(isPlaying){
        bg.stop();
        isPlaying = false;
    }
}

public static void startWinMusic(){
    if(!isPlaying){
        win.playLoop();
        isPlaying = true;
    }
}

public static void stopWinMusic(){
    if(isPlaying){
        win.stop();
        isPlaying = false;
    }
}

public static void startOverMusic(){
    if(!isPlaying){
        over.playLoop();
        isPlaying = true;
    }
}

public static void stopOverMusic(){
    if(isPlaying){
        over.stop();
        isPlaying = false;
    }
}
}
