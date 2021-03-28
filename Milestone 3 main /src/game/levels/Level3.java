package game.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.collisions.Pickup;
import game.general.Game;
import game.general.GameLevel;
import game.objects.Cartoon;
import game.objects.Coin;
import game.objects.Dog;
import game.objects.Mummy;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class Level3 extends GameLevel {

    private Mummy mummy;

    public Level3(Game game) {

        //object
        super(game);
        mummy = new Mummy(this);

// all platforms in the level3
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12f));
        ground.setFillColor(Color.orange.darker());


        Shape platform1Shape = new BoxShape(2, 0.3f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-6, -10f));
        platform1.setFillColor(Color.orange.darker());

        Shape platform2Shape = new BoxShape(0.5f, 0.3f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-1.5f, -8.5f));
        platform2.setFillColor(Color.orange.darker());

        Shape platform3Shape = new BoxShape(0.5f, 0.3f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(3f, -8.5f));
        platform3.setFillColor(Color.orange.darker());

        Shape platform4Shape = new BoxShape(2.8f, 0.3f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(8.5f, -7f));
        platform4.setAngleDegrees(20);
        platform4.setFillColor(Color.orange.darker());

        Shape platform5Shape = new BoxShape(0.5f, 0.3f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(7.5f, -4f));
        platform5.setFillColor(Color.orange.darker());

        Shape platform6Shape = new BoxShape(1.5f, 0.3f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(2.3f, -3f));
        platform6.setFillColor(Color.orange.darker());

        Shape platform7Shape = new BoxShape(0.5f, 0.3f);
        Body platform7 = new StaticBody(this, platform7Shape);
        platform7.setPosition(new Vec2(-3f, -2.3f));
        platform7.setFillColor(Color.orange.darker());

        Shape platform8Shape = new BoxShape(2f, 0.3f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(-7f, -4.5f));
        platform8.setFillColor(Color.orange.darker());

        Shape platform9Shape = new BoxShape(0.5f, 0.3f);
        Body platform9 = new StaticBody(this, platform9Shape);
        platform9.setPosition(new Vec2(-6.6f, -1f));
        platform9.setFillColor(Color.orange.darker());

        Shape platform10Shape = new BoxShape(1.2f, 0.3f);
        Body platform10 = new StaticBody(this, platform10Shape);
        platform10.setPosition(new Vec2(-9.8f, 0f));
        platform10.setFillColor(Color.orange.darker());

        Shape platform11Shape = new BoxShape(0.3f, 0.2f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(-10.5f, 1.2f));
        platform11.setFillColor(Color.orange.darker());

        Shape platform12Shape = new BoxShape(0.7f, 0.2f);
        Body platform12 = new StaticBody(this, platform12Shape);
        platform12.setPosition(new Vec2(-7f, 3.5f));
        platform12.setFillColor(Color.orange.darker());

        Shape platform13Shape = new BoxShape(0.7f, 0.2f);
        Body platform13 = new StaticBody(this, platform13Shape);
        platform13.setPosition(new Vec2(-2f, 3.5f));
        platform13.setFillColor(Color.orange.darker());

        Shape platform14Shape = new BoxShape(0.7f, 0.2f);
        Body platform14 = new StaticBody(this, platform14Shape);
        platform14.setPosition(new Vec2(2.8f, 3.5f));
        platform14.setFillColor(Color.orange.darker());

        Shape platform15Shape = new BoxShape(0.7f, 0.2f);
        Body platform15 = new StaticBody(this, platform15Shape);
        platform15.setPosition(new Vec2(8f, 3.5f));
        platform15.setFillColor(Color.orange.darker());

        Shape platform16Shape = new BoxShape(1, 0.3f);
        Body platform16 = new StaticBody(this, platform16Shape);
        platform16.setAngleDegrees(90);
        platform16.setPosition(new Vec2(12.7f, 6f));
        platform13.setFillColor(Color.orange.darker());

        Shape platform17Shape = new BoxShape(0.5f, 0.2f);
        Body platform17 = new StaticBody(this, platform17Shape);
        platform17.setPosition(new Vec2(12.5f, 4.8f));
        platform17.setFillColor(Color.orange.darker());


        Shape wallShape = new BoxShape(0.5f, 11);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(11.5f, -6));
        rightWall.setFillColor(Color.orange.darker());
        leftWall.setFillColor(Color.orange.darker());

        //spawns mummy

        getMummy().setPosition(new Vec2(+0.8f, -9));
        getMummy().addCollisionListener(new Pickup(getCartoon(), this));

    }

//loop spawns 3 coins at the position given
//loop spawns 1 crown at the position given
//spawns cartoon
    @Override
    public void populate(Game game){
        super.populate(game);

        getCartoon().setPosition(new Vec2(-10, -10));
        getCrown().setPosition(new Vec2(11.69f, 10));
        getMummy().addCollisionListener(new Pickup(getCartoon(), this));

        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 +2f, -3));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }
        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 + -1.9f, 4));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }
        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 - 1.5f, -8.5f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }

        for (int i = 0; i < 1; i++) {
            Body Jake = new Dog(this);
            Jake.setPosition(new Vec2(i * 1 - 7.3f, -2.3f));
            Jake.addCollisionListener(new Pickup(getCartoon()));
        }

        }

    // once all objects are collected allows collision with crown

    @Override
    public boolean isComplete() {
        if (getCartoon().getCoinCount() >= 3 && getCartoon().getJakeCount()>=1)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "level3";
    }


    @Override
    public void postStep(StepEvent stepEvent) {
        getMummy().jump(5);
    }

    public Cartoon getPlayer () {
        return getCartoon();


    }

    public void setMummy(Mummy mummy){
        this.mummy = mummy;
    }
    public Mummy getMummy(){
        return mummy;
    }

}


