
package game.objects;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for Wizard enemy
public class Wizard extends Walker {

    //loads deathsound when Cartoon collides with mummy

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
            -0.24f,1.1f, -1.23f,0.14f, -0.67f,-1.36f, 1.0f,-1.36f, 1.16f,0.21f, 0.17f,1.44f);
    private static final BodyImage image =
            new BodyImage("data/wizard.png", 3f);
    public Wizard(World world) {
        super(world, Shape);
        addImage(image);




    }

    //destroys Wizard and plays death sound

    @Override
    public void destroy()
    {
        deathSound.play();
        super.destroy();
    }

}
