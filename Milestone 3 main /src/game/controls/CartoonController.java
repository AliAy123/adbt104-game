package game.controls;

import city.cs.engine.*;
import game.general.Game;
import game.general.GameLevel;
import game.general.GameSaverLoader;
import game.objects.Cartoon;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyListener;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.*;
import java.io.IOException;


public class CartoonController implements KeyListener {

//setting the jumping and walking speed

    private static final float JUMPING_SPEED = 7;
    private static final float WALKING_SPEED = 3;
    private static SoundClip jumpSound;

    private Cartoon cartoon;
    private GameLevel level;



    private boolean paused;
    private Game game;

    public CartoonController(Cartoon c,GameLevel l, Game g){
        this(c,l);
        game = g;
    }

    public CartoonController(Cartoon c, GameLevel l) {
        cartoon = c;
        level = l;
    }


//allows the character to jump using space key

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(paused)return;
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) {// space = jump
            Vec2 v = cartoon.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                cartoon.jump(JUMPING_SPEED);
            }

            try {
                jumpSound = new SoundClip("data/jumpsound.wav");   // Open an audio input stream
                jumpSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exc) {
                System.out.println(e);
            }


//allows the character to move left and right using left/right arrow keys
        } else if (code == KeyEvent.VK_LEFT) {
            cartoon.startWalking(-WALKING_SPEED);//  = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            cartoon.startWalking(WALKING_SPEED);//  = wak right
        }
        else if (code == KeyEvent.VK_S){
            try {
                GameSaverLoader.save(level,"data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    //allows the character to stop walking when left/right keys are released
    @Override
    public void keyReleased(KeyEvent e) {
        if(paused)return;
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            cartoon.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            cartoon.stopWalking();
        } else if (code == KeyEvent.VK_SPACE) {
        }
    }
    public void updateCartoon(Cartoon cartoon){
        this.cartoon = cartoon;
    }



public void pause(){
    paused = true;
}



public void setLevel(GameLevel lvl){
        level = lvl;
}

public void resume(){
    paused = false;
}
}