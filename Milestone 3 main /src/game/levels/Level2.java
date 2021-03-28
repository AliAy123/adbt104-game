package game.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.collisions.Pickup;
import game.general.Game;
import game.general.GameLevel;
import game.objects.Cartoon;
import game.objects.Coin;
import game.objects.Dog;
import game.objects.Snake;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class Level2 extends GameLevel {
    public Cartoon cartoon;
    public Snake snake3;
    public Snake snake2;

    public Level2(Game game) {

        super(game);
        snake2 = new Snake(this);

        snake3 = new Snake(this);

// all platforms in the level2
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12f));
        ground.setFillColor(Color.darkGray);


        Shape platform1Shape = new BoxShape(2, 0.3f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-6, -11f));
        platform1.setFillColor(Color.darkGray);


        Shape platform2Shape = new BoxShape(1, 0.3f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-3.2f, -9.5f));
        platform2.setFillColor(Color.darkGray);

        Shape platform3Shape = new BoxShape(1, 0.3f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(2f, -9.36f));
        platform3.setFillColor(Color.darkGray);

        Shape platform4Shape = new BoxShape(2.4f, 0.3f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(8.6f, -9.35f));
        platform4.setFillColor(Color.darkGray);

        Shape platform15Shape = new BoxShape(0.5f, 0.3f);
        Body platform15 = new StaticBody(this, platform15Shape);
        platform15.setPosition(new Vec2(-10.5f, -5.3f));
        platform15.setFillColor(Color.darkGray);


        Shape platform5Shape = new BoxShape(2f, 0.3f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-5, -4f));
        platform5.setFillColor(Color.darkGray);

        Shape platform6Shape = new BoxShape(1.6f, 0.3f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(1.7f, -3.59f));
        platform6.setFillColor(Color.darkGray);


        Shape platform8Shape = new BoxShape(2.5f, 0.3f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(-8.5f, -7.4f));
        platform8.setFillColor(Color.darkGray);

        Shape platform9Shape = new BoxShape(2f, 0.2f);
        Body platform9 = new StaticBody(this, platform9Shape);
        platform9.setPosition(new Vec2(2.3f, 1.5f));
        platform9.setFillColor(Color.darkGray);

        Shape platform10Shape = new BoxShape(1f, 0.2f);
        Body platform10 = new StaticBody(this, platform10Shape);
        platform10.setPosition(new Vec2(6.5f, -2f));
        platform10.setFillColor(Color.darkGray);

        Shape platform11Shape = new BoxShape(0.5f, 0.2f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(7.3f, -0.5f));
        platform11.setFillColor(Color.darkGray);

        Shape platform12Shape = new BoxShape(2f, 0.2f);
        Body platform12 = new StaticBody(this, platform12Shape);
        platform12.setPosition(new Vec2(-5f, 1.5f));
        platform12.setFillColor(Color.darkGray);

        Shape platform13Shape = new BoxShape(1, 0.3f);
        Body platform13 = new StaticBody(this, platform13Shape);
        platform13.setPosition(new Vec2(-13, 1.68f));
        platform13.setFillColor(Color.darkGray);

        Shape platform14Shape = new BoxShape(1, 0.3f);
        Body platform14 = new StaticBody(this, platform14Shape);
        platform14.setAngleDegrees(90);
        platform14.setPosition(new Vec2(-12.7f, 3f));
        platform13.setFillColor(Color.darkGray);

        Shape wallShape = new BoxShape(0.5f, 8);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(11.5f, -6));
        rightWall.setFillColor(Color.darkGray);
        leftWall.setFillColor(Color.darkGray);


        //spawn snake 2 and 3

        getSnake2().setPosition(new Vec2(-0.3f, -10));
        getSnake2().addCollisionListener(new Pickup(getCartoon(), this));

        getSnake3().setPosition(new Vec2(5.1f, -10));
        getSnake3().addCollisionListener(new Pickup(getCartoon(), this));
    }

        //spawns jake
    //spawns character & crown at the position given
    //loop spawns 2 coins at the position given

    @Override
    public void populate(Game game){
        super.populate(game);
        getSnake2().addCollisionListener(new Pickup(getCartoon(), this));
        getSnake3().addCollisionListener(new Pickup(getCartoon(), this));

        getCartoon().setPosition(new Vec2(-10, -10));

        getCrown().setPosition(new Vec2(-11.55f, 10));


        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 - 8.5f, -7.4f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }
        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 -5f, 1.5f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }
        for (int i = 0; i < 1; i++) {
            Body Jake = new Dog(this);
            Jake.setPosition(new Vec2(i * 1 + 8.5f, -9.35f));
            Jake.addCollisionListener(new Pickup(getCartoon()));

        }
    }



    // once all objects are collected allows collision with crown

    @Override
    public boolean isComplete() {
        if (getCartoon().getCoinCount() >= 2 && getCartoon().getJakeCount() >= 1)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "level2";
    }


    public Cartoon getPlayer() {
        return cartoon;


    }

    public Snake getSnake3() { return snake3;

    }

    public Snake getSnake2() {
        return snake2;
    }
}


