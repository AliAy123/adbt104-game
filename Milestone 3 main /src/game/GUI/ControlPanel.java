package game.GUI;

import game.general.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class ControlPanel {

        private Game game;
        public JPanel mainPanel;
        private JButton pauseButton;
        private JButton restartButton;
        private JButton quitButton;
        private JButton resumeButton;
        private JButton saveButton;
        private JButton loadButton;

        public ControlPanel(Game game) {
            this.game= game;

            mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS)) ;

            pauseButton = new JButton("pause");
            resumeButton = new JButton("resume");
            quitButton = new JButton("quit");
            restartButton = new JButton("restart");
            saveButton = new JButton("save");
            loadButton = new JButton("load");

           pauseButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   game.pause();
               }
           });

           restartButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   game.restart();
               }
           });
         quitButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         });

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.save();
                }
            });
            loadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.load();
                }
            });


            mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
            mainPanel.add(saveButton);
            mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
            mainPanel.add(loadButton);
            mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
         mainPanel.add(pauseButton);
            mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
            mainPanel.add(resumeButton);
         mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
         mainPanel.add(restartButton);
            mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
         mainPanel.add(quitButton);



            resumeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                game.resume();
                }
            });

            pauseButton.setFocusable(false);
            resumeButton.setFocusable(false);
            restartButton.setFocusable(false);
            quitButton.setFocusable(false);
            saveButton.setFocusable(false);
            loadButton.setFocusable(false);
        }
        public JPanel getMainPanel(){
            return mainPanel;
        }
    }
