
package game.objects;

import city.cs.engine.*;
import game.general.GameLevel;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;


public class Cartoon extends Walker {
    private static final Shape CartoonShape = new PolygonShape(
            -0.225f, 0.99f, -0.603f, 0.414f, -0.306f, -1.116f, 0.5f, -1.111f, 0.608f, 0.126f, 0.347f, 1.116f);


    private static final BodyImage image = new BodyImage("data/cartoon.png", 2.25f);
    public static int coinCount;
    public static int CrownCount;
    public static int liveCount;
    public static int JakeCount;
    public static int PrincessCount;
    private static String LevelName;


    public Cartoon(World world) {
        super(world, CartoonShape);
        addImage(image);
        liveCount = 1;
        coinCount = 0;
        CrownCount = 0;
        JakeCount = 0;
        PrincessCount = 0;
    }

    //picking up coins
    public static int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int cc){
        coinCount = cc;
    }


    public void incrementcoinCount() {
        coinCount++;
        System.out.println("Coins Collected = " + coinCount);
    }


    //jake pickup
    public static int getJakeCount() {
        return JakeCount;

    }

    public void setJakeCount(int c){
        JakeCount = c;
    }


    public void setPrincessCount(int c){
        PrincessCount = c;
    }

    public void incrementJakeCount() {
        JakeCount++;
        System.out.println("Jake Saved = " + JakeCount);
    }



    public void incrementPrincessCount() {
        PrincessCount++;
        System.out.println("Princess Saved = " + PrincessCount);
    }

    //princess pickup
    public static int getPrincessCount() {
        return PrincessCount;

    }

//live count
    public static int getLiveCount() {
        return liveCount;
    }

//losing lives

    public void decrementliveCount() {
        liveCount--;
        System.out.println("YOU DIED!!");
        System.out.println("lives left = " + liveCount);
        System.out.println("Restart");
        if (liveCount==0);
        liveCount=1;
        System.out.println("LiveCount = 1");


        

    }


    //picking up crown posts Crown collected in console
    public int getCrownCount() {
      System.out.println("Crown Collected");
        return CrownCount;
    }
    // delete if it does not work

   public int getcoinCount() {
        System.out.println("Crown Collected");
        return coinCount;
    }

    public int getprincessCount() {
        System.out.println("Crown Collected");
        return PrincessCount;
    }

    public int getjakeCount() {
        System.out.println("Crown Collected");
        return JakeCount;
    }
    public int getliveCount() {
        System.out.println("Crown Collected");
        return liveCount;
    }








    public void incrementCrownCount() {
        CrownCount++;
        System.out.println("Crown Count =1" );

    }

    public void setLevelName(String level) {
        LevelName= level;

}

    public String getLevelName() {
    return LevelName;
}}