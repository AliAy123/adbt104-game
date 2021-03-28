package game.general;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;
import game.objects.Cartoon;
import game.objects.Crown;
import game.collisions.CrownEncounter;

public abstract class GameLevel extends World implements StepListener {

    private Cartoon cartoon;

    private Crown crown;


    public GameLevel(Game game) {



        addStepListener(this);
    }

    public void populate(Game game) {


        //all levels have a Cartoon, a Crown
        //and the Cartoon needs to reach the Crown
        //to complete the game (hence a CrownEncounter)
        cartoon = new Cartoon(this);
        crown = new Crown(this);


        CrownEncounter encounter = new CrownEncounter(this, game);
        cartoon.addCollisionListener(encounter);


        addStepListener(this);
    }


    public void setCrown(Crown cr) {
        crown = cr;
    }

    public Cartoon getCartoon() {
        return cartoon;
    }

    public Crown getCrown() {
        return crown;
    }
    public void setCartoon(Cartoon cartoon){
        this.cartoon = cartoon;
    }


    public abstract boolean isComplete();

    public abstract String getLevelName();

    @Override
    public void preStep(StepEvent stepEvent) { }

    @Override
    public void postStep(StepEvent stepEvent) {}

}
