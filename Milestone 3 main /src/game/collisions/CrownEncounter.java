package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.objects.Crown;
import game.levels.Level4;
import game.general.Game;
import game.general.GameLevel;

import javax.swing.*;

public class CrownEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;

    public CrownEncounter(GameLevel level, Game game) {
        this.level = level;
        this.game = game;


    }


    @Override
    public void collide(CollisionEvent e) {
        //if Cartoon collided with Crown and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Crown && level.isComplete()) {
            e.getOtherBody().destroy();
            if(level instanceof Level4)
                JOptionPane.showMessageDialog(null, "Well done game completed Press any button to restart the Game");
            else
                JOptionPane.showMessageDialog(null, "Level complete move onto the next level");

            game.goToNextLevel();



        }

    }

}