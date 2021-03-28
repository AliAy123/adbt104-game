package game.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.collisions.Pickup;
import game.general.Game;
import game.general.GameLevel;
import game.objects.*;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class Level4 extends GameLevel {

   public Wizard wizard1;
    public Wizard wizard2;

    public Level4(Game game) {

        //object
        super(game);
        wizard1 = new Wizard(this);
        wizard2 = new Wizard(this);

// all platforms in the level4
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12f));
        ground.setFillColor(Color.cyan);


        Shape platform1Shape = new BoxShape(1, 0.3f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-7.5f, -10f));
        platform1.setFillColor(Color.cyan);

        Shape platform2Shape = new BoxShape(0.5f, 0.3f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-4f, -8.5f));
        platform2.setFillColor(Color.cyan);

        Shape platform3Shape = new BoxShape(0.5f, 0.3f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(1f, -8.5f));
        platform3.setFillColor(Color.cyan);

        Shape platform4Shape = new BoxShape(0.5f, 0.3f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(6f, -8.5f));
        platform4.setFillColor(Color.cyan);

        Shape platform5Shape = new BoxShape(1f, 0.3f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(10f, -7f));
        platform5.setFillColor(Color.cyan);

        Shape platform6Shape = new BoxShape(0.3f, 0.2f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(10.7f, -4.7f));
        platform6.setFillColor(Color.cyan);

        Shape platform7Shape = new BoxShape(0.5f, 0.3f);
        Body platform7 = new StaticBody(this, platform7Shape);
        platform7.setPosition(new Vec2(7f, -3));
        platform7.setFillColor(Color.cyan);

        Shape platform8Shape = new BoxShape(0.5f, 0.3f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(3.3f, -3f));
        platform8.setFillColor(Color.cyan);

        Shape platform9Shape = new BoxShape(0.5f, 0.3f);
        Body platform9 = new StaticBody(this, platform9Shape);
        platform9.setPosition(new Vec2(-4.5f, -3f));
        platform9.setFillColor(Color.cyan);

        Shape platform10Shape = new BoxShape(0.5f, 0.3f);
        Body platform10 = new StaticBody(this, platform10Shape);
        platform10.setPosition(new Vec2(-0.5f, -3f));
        platform10.setFillColor(Color.cyan);

        Shape platform11Shape = new BoxShape(1.5f, 0.2f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(-9f, -1.5f));
        platform11.setFillColor(Color.cyan);

        Shape platform12Shape = new BoxShape(0.3f, 0.2f);
        Body platform12 = new StaticBody(this, platform12Shape);
        platform12.setPosition(new Vec2(-9.8f, 0.5f));
        platform12.setFillColor(Color.cyan);

        Shape platform13Shape = new BoxShape(1f, 0.2f);
        Body platform13 = new StaticBody(this, platform13Shape);
        platform13.setAngle(-15);
        platform13.setPosition(new Vec2(-7f, 3f));
        platform13.setFillColor(Color.cyan);

        Shape platform14Shape = new BoxShape(0.5f, 0.2f);
        Body platform14 = new StaticBody(this, platform14Shape);
        platform14.setPosition(new Vec2(-4f, 2.5f));
        platform14.setFillColor(Color.cyan);

        Shape platform15Shape = new BoxShape(0.5f, 0.2f);
        Body platform15 = new StaticBody(this, platform15Shape);
        platform15.setPosition(new Vec2(0f, 3f));
        platform15.setFillColor(Color.cyan);

        Shape platform16Shape = new BoxShape(0.5f, 0.2f);
        Body platform16 = new StaticBody(this, platform16Shape);
        platform16.setPosition(new Vec2(4f, 4f));
        platform16.setFillColor(Color.cyan);

        Shape platform17Shape = new BoxShape(0.5f, 0.2f);
        Body platform17 = new StaticBody(this, platform17Shape);
        platform17.setPosition(new Vec2(8f, 5f));
        platform17.setFillColor(Color.cyan);

        Shape platform18Shape = new BoxShape(0.3f, 0.2f);
        Body platform18 = new StaticBody(this, platform18Shape);
        platform18.setPosition(new Vec2(8f, -10.5f));
        platform18.setFillColor(Color.cyan);

        Shape platform19Shape = new BoxShape(1f, 0.3f);
        Body platform19 = new StaticBody(this, platform19Shape);
        platform19.setAngleDegrees(90);
        platform19.setPosition(new Vec2(12.7f, 8f));
        platform19.setFillColor(Color.cyan);

        Shape platform20Shape = new BoxShape(0.5f, 0.2f);
        Body platform20 = new StaticBody(this, platform20Shape);
        platform20.setPosition(new Vec2(12.5f, 6.8f));
        platform20.setFillColor(Color.cyan);


        Shape wallShape = new BoxShape(0.5f, 13);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(11.5f, -6));
        rightWall.setFillColor(Color.cyan);
        leftWall.setFillColor(Color.cyan);

        //spawns wizard


        getWizard1().setPosition(new Vec2(-2f, -9));
        getWizard1().addCollisionListener(new Pickup(getCartoon(), this));

        getWizard2().setPosition(new Vec2(3.6f, -9));
        getWizard2().addCollisionListener(new Pickup(getCartoon(), this));
    }

    //spawns cartoon, jake and princess
//loop spawns 3 coins at the position given
//loop spawns 1 crown at the position given

    @Override
    public void populate(Game game) {
        super.populate(game);
        getWizard1().addCollisionListener(new Pickup(getCartoon(), this));
        getWizard2().addCollisionListener(new Pickup(getCartoon(), this));
        getCartoon().setPosition(new Vec2(-10, -10));
        getCrown().setPosition(new Vec2(11.69f, 10));

        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 + 3.3f, -3f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }
        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 + -4f, -8.5f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }
        for (int i = 0; i < 1; i++) {

            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 1 + 8f, 5f));
            coin.addCollisionListener(new Pickup(getCartoon()));
        }

        //spawns jake

        for (int i = 0; i < 1; i++) {
            Body Jake = new Dog(this);
            Jake.setPosition(new Vec2(i * 1 + 10f, -11f));
            Jake.addCollisionListener(new Pickup(getCartoon()));
        }

        //spawns princess

        for (int i = 0; i < 1; i++) {
            Body Princess = new Princess(this);
            Princess.setPosition(new Vec2(i * 1 + 0f, 4f));
            Princess.addCollisionListener(new Pickup(getCartoon()));
        }
    }

// once all objects are collected allows collision with crown

    @Override
    public boolean isComplete() {
        if (getCartoon().getCoinCount() >= 3 && getCartoon().getJakeCount()>=1 && getCartoon().getPrincessCount()>=1)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "level4";
    }

    //makes wizrads jump
    @Override
    public void postStep(StepEvent stepEvent) {
        getWizard1().jump(5);
        getWizard2().jump(5);
    }


    public Cartoon getPlayer () {
        return getCartoon();


    }

    public void setWizard1(Wizard wizard){
        wizard1 = wizard;
    }

    public void setWizard2(Wizard wizard){
        wizard2 = wizard;
    }

    public Wizard getWizard1(){
        return wizard1;
    }

   public Wizard getWizard2(){
        return wizard2;
    }

}


