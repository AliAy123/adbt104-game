package game.objects;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


//dog class
public class Dog extends DynamicBody {


    public Dog(World w) {
        super(w);

        Shape DogShape = new PolygonShape(-0.35f,0.91f, -0.415f,-0.08f, -0.425f,-1.07f, 1.145f,-1.07f, 1.19f,0.385f, 0.175f,1.165f);
        SolidFixture coinFixture = new SolidFixture(this, DogShape, 10);
        addImage(new BodyImage("data/Dog.png", 2.5f));

    }
//play dog sound when collision occurs

    private static SoundClip DogSound;
    static {

        //loads up dog sound file

        try {
            DogSound = new SoundClip("data/DogSound.wav");   // Open an audio input stream
            System.out.println("loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }

    }

    //destroys dog and plays sound

    @Override
    public void destroy()
    {
       //
         DogSound.play();
        super.destroy();
    }
}

