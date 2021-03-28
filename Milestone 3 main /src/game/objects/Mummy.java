
package game.objects;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for mummy enemy
public class Mummy extends Walker {

    //plays deathsound when Cartoon collides with mummy

    private static SoundClip deathSound;
    static {

        try {
            deathSound = new SoundClip("data/deathSound.wav");   // Open an audio input stream
            System.out.println("loading death sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }
    }

    private static final Shape Shape = new PolygonShape(
            -0.18f,1.6f, -1.24f,0.46f, -0.48f,-1.73f, 1.02f,-1.73f, 1.24f,0.3f, 0.33f,1.71f);
    private static final BodyImage image =
            new BodyImage("data/mummy.png", 3.5f);
    public Mummy(World world) {
        super(world, Shape);
        addImage(image);




    }

    //destroys mummy

    @Override
    public void destroy()
    {
        deathSound.play();
        super.destroy();
    }

}
