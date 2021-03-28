
package game.objects;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


//coin class
public class Coin extends DynamicBody {


    public Coin(World w) {
        super(w);

        Shape coinShape = new PolygonShape(-0.27f,0.406f, -0.456f,0.012f, -0.376f,-0.45f, 0.322f,-0.444f, 0.392f,0.108f, 0.02f,0.496f);
        SolidFixture coinFixture = new SolidFixture(this, coinShape, 10);
        addImage(new BodyImage("data/coin.png", 1f));

    }

    //plays coin sound when Cartoon collides with coin

    private static SoundClip coinSound;
    static {

        try {
            coinSound = new SoundClip("data/coinSound.wav");   // Open an audio input stream
           System.out.println("loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }

    }
    //destroys coin plays music
        @Override
                public void destroy()
        {
        coinSound.play();
        super.destroy();
    }
}

