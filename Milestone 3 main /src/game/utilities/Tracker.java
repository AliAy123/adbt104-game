package game.utilities;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.general.GameView;
import game.objects.Cartoon;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Cartoon cartoon;
    public Tracker(GameView view, Cartoon cartoon) {
        this.view = view;
        this.cartoon = cartoon;

    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(cartoon.getPosition()));
    }
}