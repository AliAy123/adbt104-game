
package game.objects;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for crown
public class Crown extends DynamicBody {
public SoundClip crownSound;


    public Crown(World w) {
        super(w);

        Shape CrownShape = new PolygonShape(-0.642f, 0.264f, -0.582f, -0.305f, 0.574f, -0.297f, 0.639f, 0.256f, 0.003f, 0.347f);
        SolidFixture CrownFixture = new SolidFixture(this, CrownShape, 10);
        addImage(new BodyImage("data/crown.png", 0.7f));

        //play crown sound when collision occurs

        try {
            crownSound = new SoundClip("data/crownSound.wav");   // Open an audio input stream
            // System.out.println("loading crown sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException et) {
            System.out.println(et);

        }
    }
        @Override
        public void destroy() {
            crownSound.play();
            super.destroy();
        }

    }



