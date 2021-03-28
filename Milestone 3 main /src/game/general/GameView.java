package game.general;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.objects.Cartoon;


import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    //adds a background
    private Image background;
    private GameLevel w, level;


    public GameView(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/background.jpeg").getImage();
    }

//sets background image size

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 500, 500, this);

    }
    //adding the scores to the game screen
    @Override
    protected void paintForeground(Graphics2D g) {
        w = (GameLevel) this.getWorld();
        g.setColor(Color.WHITE);
        g.drawString("Coin Count :" + Cartoon.getCoinCount(), 10, 40);
        g.drawString("Live Count :" + Cartoon.getLiveCount(), 130, 40);
        g.drawString("Jake Count :" + Cartoon.getJakeCount(), 250, 40);
        g.drawString("Princess Count :" + Cartoon.getPrincessCount(), 370, 40);

    }


    //method for set background
    public void setBackground(Image image){
        this.background = image;
    }

}