package game.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.collisions.Pickup;
import game.general.Game;
import game.general.GameLevel;
import game.objects.Cartoon;
import game.objects.Coin;
import game.objects.Snake;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class Level1 extends GameLevel {

    private Snake snake1;

    public Level1(Game game) {

        super(game);
        snake1  = new Snake(this);

// all platforms in the level
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12f));
        ground.setFillColor(Color.white);


        Shape platform1Shape = new BoxShape(2, 0.3f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-6, -10f));
        platform1.setFillColor(Color.white);

        Shape platform2Shape = new BoxShape(1, 0.3f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(1, -9f));
        platform2.setFillColor(Color.white);

        Shape platform3Shape = new BoxShape(0.6f, 0.3f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(5.4f, -8f));
        platform3.setFillColor(Color.white);

        Shape platform4Shape = new BoxShape(2, 0.3f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(9, -7f));
        platform4.setFillColor(Color.white);


        Shape platform5Shape = new BoxShape(5, 0.3f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(3, -2f));
        platform5.setAngleDegrees(-20);
        platform5.setFillColor(Color.white);

        Shape platform6Shape = new BoxShape(1, 0.3f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(-3, -1f));
        platform6.setFillColor(Color.white);

        Shape platform8Shape = new BoxShape(0.5f, 0.3f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(10.5f, -6f));
        platform8.setFillColor(Color.white);

        Shape platform9Shape = new BoxShape(1, 0.3f);
        Body platform9 = new StaticBody(this, platform9Shape);
        platform9.setPosition(new Vec2(-7, 0f));
        platform9.setFillColor(Color.white);

        Shape platform10Shape = new BoxShape(1, 0.2f);
        Body platform10 = new StaticBody(this, platform10Shape);
        platform10.setPosition(new Vec2(-5, -9f));
        platform10.setFillColor(Color.white);

        Shape platform11Shape = new BoxShape(1, 0.3f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(-13, 0.7f));
        platform11.setFillColor(Color.white);

        Shape platform12Shape = new BoxShape(1, 0.3f);
        Body platform12 = new StaticBody(this, platform12Shape);
        platform12.setAngleDegrees(90);
        platform12.setPosition(new Vec2(-12.75f, 2f));

        Shape wallShape = new BoxShape(0.5f, 7);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(11.5f, -6));
        rightWall.setFillColor(Color.white);
        leftWall.setFillColor(Color.white);

        //spawns snake

        getSnake1().setPosition(new Vec2(-1.5f, -10));
        getSnake1().addCollisionListener(new Pickup(getCartoon(),this));


    }
    //loop spawns 2 coins at the position given
    //spawns cartoon and crown at the position given
    @Override
     public void populate(Game game){
        super.populate(game);
        getCartoon().setPosition(new Vec2(-10, -10));
        getCrown().setPosition(new Vec2(- 11.69f, 10));
        getSnake1().addCollisionListener(new Pickup(getCartoon(),this));

        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 + 10.5f, -5.25f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }

            for (int i = 0; i < 1; i++) {

                Body coin = new Coin(this);
                coin.setPosition(new Vec2(i * 1 - 6.9f, 0.7f));
                coin.addCollisionListener(new Pickup(getCartoon()));
            }

     }





// once all objects are collected allows collision with crown

    @Override
    public boolean isComplete() {
        if (getCartoon().getCoinCount() >= 2)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "level1";
    }


    public Cartoon getPlayer () {
        return getCartoon();


    }
    public Snake getSnake1(){
        return snake1;
    }

}


