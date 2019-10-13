/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class Start extends JPanel{
    private jPanelGame1 jPanelG1;
    private jPanelGame2 jPanelG2;
    private jPanelGame3 jPanelG3;
    public JLabel jTitle;
    
    public Start(){
        setLayout(new BorderLayout());
        jPanelG1 = new jPanelGame1();
        add(jPanelG1,BorderLayout.NORTH);
        jPanelG1.setPreferredSize(new Dimension(1180,360));
        jPanelG1.setBackground(Color.gray);
        
        jPanelG2 = new jPanelGame2();
        add(jPanelG2,BorderLayout.WEST);
        jPanelG2.setPreferredSize(new Dimension(590,360));
        jPanelG2.setBackground(Color.LIGHT_GRAY);
        
        jPanelG3 = new jPanelGame3();
        add(jPanelG3,BorderLayout.EAST);
        jPanelG3.setPreferredSize(new Dimension(590,360));
        jPanelG3.setBackground(Color.WHITE);
        
        
        add(new StopWatchPane(), BorderLayout.SOUTH);

    }
    
    public class StopWatchPane extends JPanel {
        
        private JLabel label;
        private long lastTickTime;
        private Timer timer;

        public StopWatchPane() {
            setLayout(new GridBagLayout());
            label = new JLabel(String.format("%04d:%02d:%02d.%03d", 0, 0, 0, 0));

            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long runningTime = System.currentTimeMillis() - lastTickTime;
                    Duration duration = Duration.ofMillis(runningTime);
                    long hours = duration.toHours();
                    duration = duration.minusHours(hours);
                    long minutes = duration.toMinutes();
                    duration = duration.minusMinutes(minutes);
                    long millis = duration.toMillis();
                    long seconds = millis / 1000;
                    millis -= (seconds * 1000);
                    label.setText(String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis));
                }
            });

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(4, 4, 4, 4);
            add(label, gbc);
            
            JButton start = new JButton("START GAME");
            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!timer.isRunning()) {
                        lastTickTime = System.currentTimeMillis();
                        timer.start();
                    }
                }
            });
            JButton stop = new JButton("END GAME");
            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                }
            });
            
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.weightx = 0;
            gbc.gridwidth = 1;
            add(start, gbc);
            gbc.gridx++;
            add(stop, gbc);
        }

    }    
    
    
    
    
    class jPanelGame1 extends JPanel{

        
        
        jPanelGame1 (){
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 1", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);
    }
    
    }
    
    class jPanelGame2 extends JPanel{

        public jPanelGame2() {
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 2", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);    
            
        }
    }

    class jPanelGame3 extends JPanel{

        public jPanelGame3() {
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 3", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);    
        }
    }
    
}
