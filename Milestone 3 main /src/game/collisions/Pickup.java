package game.collisions;

import city.cs.engine.*;
import game.levels.Level1;
import game.levels.Level2;
import game.levels.Level3;
import game.levels.Level4;
import game.objects.*;
import org.jbox2d.common.Vec2;

//override method allows the cartoon cahrcter to pickup coins and collide with crowns and snake

public class Pickup implements CollisionListener {
    public Cartoon cartoon;
    private World level;


    public Pickup(Cartoon cartoon) {
        this.cartoon = cartoon;

    }

    public Pickup(Cartoon cartoon,World level) {
        this.cartoon = cartoon;
        this.level = level;

    }

    //creates new objects destroys then respawns enemys and Cartoon when collision happens
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Coin && e.getOtherBody() == cartoon) {
            cartoon.incrementcoinCount();
            e.getReportingBody().destroy();


        } else if (e.getReportingBody() instanceof Dog && e.getOtherBody() == cartoon) {
            cartoon.incrementJakeCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Princess && e.getOtherBody() == cartoon) {
            cartoon.incrementPrincessCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Crown && e.getOtherBody() == cartoon) {
            cartoon.incrementCrownCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Mummy && e.getOtherBody() == cartoon) {
            cartoon.decrementliveCount();
            e.getReportingBody().destroy();
            e.getOtherBody().setPosition(new Vec2(-10.6f, -10));


            //if mummy is from level, revive that mummy
            if (level instanceof Level3) {
                Mummy mummy = new Mummy(level);
                mummy.setPosition(new Vec2(0.8f, -9));
                mummy.addCollisionListener(new Pickup(cartoon, level));

                //set mummy of level 3 to new mummy, as the previous mummy gets destroyed
                ((Level3) level).setMummy(mummy);
            }

        } else if (e.getReportingBody() instanceof Wizard && e.getOtherBody() == cartoon) {
            cartoon.decrementliveCount();
            e.getReportingBody().destroy();
            e.getOtherBody().setPosition(new Vec2(-10.6f, -10));


            //if wizard is from wizard, revive that snake
            if (level instanceof Level4) {
                Wizard wizard1 = new Wizard(level);
                wizard1.addCollisionListener(new Pickup(cartoon, level));

                //set the wizard of the level to the new 'wizard1', ast he previous gets destroyed
                if(e.getReportingBody() == ((Level4) level).getWizard1()) {
                    ((Level4) level).setWizard1(wizard1);
                    wizard1.setPosition(new Vec2(-2f, -9));
                }
                else if(e.getReportingBody() == ((Level4) level).getWizard2()) {
                    ((Level4) level).setWizard2(wizard1);
                    wizard1.setPosition(new Vec2(3.6f, -9));
                }

            }


        } else if (e.getReportingBody() instanceof Snake && e.getOtherBody() == cartoon) {
            cartoon.decrementliveCount();
            e.getReportingBody().destroy();
            e.getOtherBody().setPosition(new Vec2(-10, -10));


            //if snake is from level, revive that snake
            if (level instanceof Level1) {
                Snake snake1 = new Snake(level);
                snake1.setPosition(new Vec2(-1.5f, -10));
                snake1.addCollisionListener(new Pickup(cartoon, level));
            }

            // if snake is from level 2, only revive the snake that was destroyed
            if (level instanceof Level2) {
                Snake snake2 = new Snake(level);
                snake2.setPosition(new Vec2(e.getPosition().x, e.getPosition().y));
                snake2.addCollisionListener(new Pickup(cartoon, level));

            }
            if (level instanceof Level3) {
                Snake snake3 = new Snake(level);
                snake3.setPosition(new Vec2(e.getPosition().x, e.getPosition().y));
                snake3.addCollisionListener(new Pickup(cartoon, level));
            }

        }

    }
        public void setLevel (World level){
            this.level = level;
        }
    }