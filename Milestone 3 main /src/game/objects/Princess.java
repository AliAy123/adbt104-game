package game.objects;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


//dog class
public class Princess extends DynamicBody {


    public Princess(World w) {
        super(w);

        Shape PrincessShape = new PolygonShape(-0.41f,1.02f, -0.71f,-1.46f, 0.88f,-1.41f, 0.28f,1.01f, -0.09f,1.46f);
        SolidFixture coinFixture = new SolidFixture(this, PrincessShape, 10);
        addImage(new BodyImage("data/princess.png", 3.5f));

    }
//play dog sound when collision occurs

    private static SoundClip PrincessSound;
    static {

        //loads princess sound file

        try {
            PrincessSound = new SoundClip("data/PrincessSound.wav");   // Open an audio input stream
            System.out.println("loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }

    }

    //destroys princess and plays the princess sound

    @Override
    public void destroy()
    {
        //
        PrincessSound.play();
        super.destroy();
    }
}
