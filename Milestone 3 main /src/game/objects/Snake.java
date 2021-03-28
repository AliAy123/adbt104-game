
package game.objects;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for snake enemy
public class Snake extends Walker {

//plays deathsound when Cartoon collides with snake

    private static SoundClip deathSound;
    static {

        //loads the death sound

        try {
            deathSound = new SoundClip("data/deathSound.wav");   // Open an audio input stream
            System.out.println("loading death sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }
    }

        private static final Shape Shape = new PolygonShape(
                -1.093f,1.0f, -1.133f,0.19f, -0.873f,-1.18f, 1.127f,-1.165f, 0.402f,0.85f, -0.228f,1.235f);
    private static final BodyImage image =
            new BodyImage("data/snake.png", 2.5f);
    public Snake(World world) {
        super(world, Shape);
        addImage(image);




        }

        //destroys snake and plays the death sound

       @Override
    public void destroy()
        {
            deathSound.play();
            super.destroy();
       }

    }
