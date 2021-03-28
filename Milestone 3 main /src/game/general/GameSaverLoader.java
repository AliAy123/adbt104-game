package game.general;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import game.collisions.CrownEncounter;
import game.collisions.Pickup;
import game.levels.Level1;
import game.levels.Level2;
import game.levels.Level3;
import game.levels.Level4;
import game.objects.*;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class GameSaverLoader {


    public static void save(GameLevel level, String fileName)
            throws IOException
    {


        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName()  + "\n");

            for(StaticBody body : level.getStaticBodies()){
                //dont have any worth saving
            }

            //write cartoon first
            writer.write("Cartoon,"+ level.getCartoon().getPosition().x + "," + level.getCartoon().getPosition().y + "," + level.getCartoon().getcoinCount() + "," +
                    level.getCartoon().getjakeCount()+ "," + level.getCartoon().getprincessCount()+ "," + level.getCartoon().getliveCount()+ "\n");

            for(DynamicBody body : level.getDynamicBodies()) {

                if (body instanceof Cartoon) {
    //skip, cartoon already written

                } else if (body instanceof Crown) {
                    writer.write("Crown,"+body.getPosition().x + "," + body.getPosition().y + "\n");
                } else if (body instanceof Coin) {
                    writer.write("Coin,"+body.getPosition().x + "," + body.getPosition().y + "\n");
                } else if (body instanceof Princess) {
                    writer.write("Princess,"+body.getPosition().x + "," + body.getPosition().y + "\n");
                } else if (body instanceof Dog) {
                    writer.write("Jake,"+ body.getPosition().x + "," + body.getPosition().y + "\n");
                }

            }

        } finally {
            if (writer != null) {
                writer.close();
            }
        }



    }
    public static GameLevel load(Game game, String fileName)
    throws IOException {

        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            GameLevel level = null;
            if (line.equals("level1"))
                level = new Level1(game);
            else if (line.equals("level2"))
                level =  new Level2(game);
            else if (line.equals("level3"))
                level = new Level3(game);
            else if (line.equals("level4"))
                level = new Level4(game);

           // System.out.println(line);

            line = reader.readLine();
            while(line != null){


                String[] tokens = line.split(",");

                if (tokens[0].equals("Cartoon")){
                 Cartoon c = new Cartoon(level);
                 float x = Float.parseFloat(tokens[1]);
                 float y = Float.parseFloat(tokens[2]);
                 c.setPosition(new Vec2(x,y));
                    int coinCount = Integer.parseInt(tokens[3]);
                    c.setCoinCount(coinCount);
                    int jakeCount = Integer.parseInt(tokens[4]);
                    c.setJakeCount(jakeCount);
                    int princessCount = Integer.parseInt(tokens[5]);
                    c.setPrincessCount(princessCount);
                    level.setCartoon(c);

                    //update collision listeners for the objects
                    if(level instanceof Level1)
                        ((Level1)level).getSnake1().addCollisionListener(new Pickup(level.getCartoon(),level));
                    else if(level instanceof Level2){
                        ((Level2)level).getSnake2().addCollisionListener(new Pickup(level.getCartoon(), level));
                        ((Level2)level).getSnake3().addCollisionListener(new Pickup(level.getCartoon(), level));
                    }else if(level instanceof Level3){
                        ((Level3)level). getMummy().addCollisionListener(new Pickup(level.getCartoon(), level));
                    }else if(level instanceof Level4){
                        ((Level4)level).  getWizard1().addCollisionListener(new Pickup(level.getCartoon(), level));
                        ((Level4)level). getWizard2().addCollisionListener(new Pickup(level.getCartoon(), level));
                    }

                }else if (tokens[0].equals("Crown")) {
                 Crown cr = new Crown(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    cr.setPosition(new Vec2(x,y));
                    level.setCrown(cr);

                    //add crown collisoin listner
                    CrownEncounter encounter = new CrownEncounter(level, game);
                    level.getCartoon().addCollisionListener(encounter);



                }else if (tokens[0].equals("Coin")) {
                    Coin co = new Coin(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    co.setPosition(new Vec2(x,y));

                    ///add coin listener
                    co.addCollisionListener(new Pickup(level.getCartoon()));

                }else if (tokens[0].equals("Princess")) {
                    Princess p = new Princess(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    p.setPosition(new Vec2(x,y));
                    p.addCollisionListener(new Pickup(level.getCartoon()));

                }else if (tokens[0].equals("Jake")) {
                    Dog d = new Dog(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    d.setPosition(new Vec2(x, y));
                    d.addCollisionListener(new Pickup(level.getCartoon()));
                }

                    line = reader.readLine();

            }


            return level;


        } finally{
                if (reader != null) {
                    reader.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        }
    }


