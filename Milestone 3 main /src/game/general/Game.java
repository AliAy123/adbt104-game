package game.general;

import javax.swing.*;

import city.cs.engine.*;
import game.GUI.ControlPanel;
import game.controls.CartoonController;
import game.controls.GiveFocus;
import game.levels.Level1;
import game.levels.Level2;
import game.levels.Level3;
import game.levels.Level4;

import java.awt.*;
import java.io.IOException;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import javax.swing.JFrame;




public class Game {

    public SoundClip gameMusic;

    public SoundClip game2Music;

    public SoundClip game3Music;

    public SoundClip game4Music;

    private GameLevel level;

    private GameView view;


    private CartoonController controller;

    public Game() {


        level = new Level1(this);
        level.populate(this);

        view = new GameView(level, 500, 500);
        view.setZoom(20);


//cartoon controller gets set to level

        controller = new CartoonController(level.getCartoon(), level,this);
        //view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        final JFrame frame = new JFrame("Basic world");
        frame.add(view);
        frame.addKeyListener(controller);


        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);


        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);

        frame.requestFocus();



       //JFrame debugView = new DebugViewer(level, 500, 500);

// background music for the levels

        try {
            gameMusic = new SoundClip("data/theme.wav");   // Open an audio input stream
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        try {
            game2Music = new SoundClip("data/level2music.wav");   // Open an audio input stream

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            game3Music = new SoundClip("data/level3music.wav");   // Open an audio input stream

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            game4Music = new SoundClip("data/level4music.wav");   // Open an audio input stream

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        System.out.println("LiveCount = 1");

        level.start();

    }
// sets level
    public void setLevel(GameLevel level){

            if (level instanceof Level1) {
                //stop the current level
                this.level.stop();

                //create the new (appropriate) level
                //level now refers to new level
                this.level = level;

                //sets new background
                view.setBackground(new ImageIcon("data/background.jpeg").getImage());
                //change the view to look into new level
                view.setWorld(this.level);


                //change the controller to control the
                //Cartoon in the new world
                controller.updateCartoon(this.level.getCartoon());
                controller.setLevel(level);

                 //JFrame debugView = new DebugViewer(level, 500, 500);

                //start the simulation in the new level stops old music and plays new music

                this.level.start();
                stopAllMusic();
                gameMusic.loop();
                //game2Music.loop();

            } else if (level instanceof Level2) {
                //stop the current level
                this.level.stop();

                //create the new (appropriate) level
                //level now refers to new level
                this.level = level;

                //sets new background
                view.setBackground(new ImageIcon("data/level2background.jpg").getImage());
                //change the view to look into new level
                view.setWorld(this.level);


                //change the controller to control the
                //Cartoon in the new world
                controller.updateCartoon(this.level.getCartoon());
                controller.setLevel(level);

                //JFrame debugView = new DebugViewer(level, 500, 500);

                //start the simulation in the new level stops old music and plays new music
                stopAllMusic();
                game2Music.loop();
                this.level.start();


            } else if (level instanceof Level3) {
                //stop the current level
                this.level.stop();

                //create the new (appropriate) level
                //level now refers to new level
                this.level = level;

                //sets new background
                view.setBackground(new ImageIcon("data/level3background.jpg").getImage());
                //change the view to look into new level
                view.setWorld(this.level);


                //change the controller to control the
                //Cartoon in the new world
                controller.updateCartoon(level.getCartoon());
                controller.setLevel(level);

                //JFrame debugView = new DebugViewer(level, 500, 500);

                //start the simulation in the new level stops old music and plays new music
                stopAllMusic();
                game3Music.loop();
                this.level.start();

            } else if (level instanceof Level4) {

                //stop the current level
                this.level.stop();

                //reference to new level
                this.level = level;

                //sets new background
                view.setBackground(new ImageIcon("data/frozen.jpg").getImage());
                //change the view to look into new level
                view.setWorld(this.level);


                //change the controller to control the
                //Cartoon in the new world
                controller.updateCartoon(this.level.getCartoon());
                controller.setLevel(level);

                //JFrame debugView = new DebugViewer(level, 500, 500);

                //start the simulation in the new level stops old music and plays new music
                stopAllMusic();
                game4Music.loop();
                this.level.start();
            }
        }
public void stopAllMusic(){
    gameMusic.stop();
    game2Music.stop();
    game3Music.stop();
    game4Music.stop();
}



// method to switch levels

    public void goToNextLevel() {

        if (level instanceof Level1) {
            //stop the current level
            level.stop();

            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            level.populate(this);

            //sets new background
            view.setBackground(new ImageIcon("data/level2background.jpg").getImage());
            //change the view to look into new level
            view.setWorld(level);


            //change the controller to control the
            //Cartoon in the new world
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);

           //JFrame debugView = new DebugViewer(level, 500, 500);

            //start the simulation in the new level stops old music and plays new music

            level.start();
            gameMusic.stop();
            game2Music.loop();

        } else if (level instanceof Level2) {
            //stop the current level
            level.stop();

            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            level.populate(this);

            //sets new background
            view.setBackground(new ImageIcon("data/level3background.jpg").getImage());
            //change the view to look into new level
            view.setWorld(level);


            //change the controller to control the
            //Cartoon in the new world
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);

           // JFrame debugView = new DebugViewer(level, 500, 500);

            //start the simulation in the new level stops old music and plays new music
            game2Music.stop();
            game3Music.loop();
            level.start();


        } else if (level instanceof Level3) {
            //stop the current level
            level.stop();

            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            level.populate(this);

            //sets new background
            view.setBackground(new ImageIcon("data/frozen.jpg").getImage());
            //change the view to look into new level
            view.setWorld(level);


            //change the controller to control the
            //Cartoon in the new world
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);

          //JFrame debugView = new DebugViewer(level, 500, 500);

            //start the simulation in the new level stops old music and plays new music

            game3Music.stop();
            game4Music.loop();
            level.start();
        } else if (level instanceof Level4) {
            System.out.println("Well done! level complete.");
            System.out.println("Game Restarted");

            //stop the current level
            level.stop();

            //reference to new level
            level = new Level1(this);
            level.populate(this);
            //sets new background
            view.setBackground(new ImageIcon("data/background.jpeg").getImage());
            //change the view to look into new level
            view.setWorld(level);


            //change the controller to control the
            //Cartoon in the new world
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);

            //JFrame debugView = new DebugViewer(level, 500, 500);

            //start the simulation in the new level stops old music and plays new music
            game4Music.stop();
            gameMusic.loop();
            level.start();
        }
    }








    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }


    public void pause () {
        level.stop();
        controller.pause();
    }

    public void restart () {
        if(level instanceof Level1) {
            level.stop();
            level = new Level1(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setBackground(new ImageIcon("data/background.jpeg").getImage());
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);
            level.start();

        }else  if(level instanceof Level2) {
            level.stop();
            level = new Level2(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setBackground(new ImageIcon("data/level2background.jpg").getImage());
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);
            level.start();

        }else  if(level instanceof Level3) {
            level.stop();
            level = new Level3(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setBackground(new ImageIcon("data/level3background.jpg").getImage());
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);
            level.start();

        }else  if(level instanceof Level4) {
            level.stop();
            level = new Level4(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setBackground(new ImageIcon("data/frozen.jpg").getImage());
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);
            level.start();

        }else  if(level instanceof Level4) {
            level.stop();
            level = new Level1(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setBackground(new ImageIcon("data/background.jpeg").getImage());
            controller.updateCartoon(level.getCartoon());
            controller.setLevel(level);
            level.start();

        }
    }

    public void resume(){
        level.start();
        controller.resume();
    }
    public GameLevel getLevel() {
        return level;
    }

    public void save() {
        try {
            GameSaverLoader.save(level,"data/save.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void load() {
        try {
            GameLevel level = GameSaverLoader.load(this, "data/save.txt");
            this.setLevel(level);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }}