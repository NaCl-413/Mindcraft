package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mindcraft extends JFrame implements ActionListener{

    private Game gamePanel = new Game();
    
    private JPanel titlePanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel mainMenuPanel = new JPanel();
    private JPanel aboutPanel = new JPanel();
    private JPanel instructionsPanel = new JPanel();
    private JPanel reviewerPanel = new JPanel();

    private JButton toMainMenu = new JButton("MAIN MENU");
    private JButton toGame = new JButton("START");
    private JButton toAbout = new JButton("ABOUT");
    private JButton toInstructions = new JButton("INSTRUCTIONS");
    private JButton toReviewer = new JButton("REVIEWER");

    private JLabel mainTitle = new JLabel("MindCraft", JLabel.CENTER);
    private JLabel aboutTitle = new JLabel("ABOUT", JLabel.CENTER);
    private JLabel instructionsTitle = new JLabel("INSTRUCTIONS", JLabel.CENTER);
    private JLabel reviewerTitle = new JLabel("REVIEWER", JLabel.CENTER);
    

    public Mindcraft(){
        super("MINDCRAFT");
        setLayout(new BorderLayout());

        //Panel Initializations(Init)
        //Title Panel
        titlePanel.setPreferredSize(new Dimension(590, 720));
        titlePanel.setBackground(Color.cyan);
        titlePanel.setLayout(new BorderLayout());

        titlePanel.add(mainTitle, BorderLayout.CENTER);

        //Main Menu Panel
        mainMenuPanel.setPreferredSize(new Dimension(590, 720));
        mainMenuPanel.setBackground(Color.gray);
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        mainMenuPanel.add(toGame);
        mainMenuPanel.add(toAbout);
        mainMenuPanel.add(toInstructions);
        mainMenuPanel.add(toReviewer);

        //About Panel
        aboutPanel.setPreferredSize(new Dimension(780, 720));
        aboutPanel.setBackground(Color.gray);
        aboutPanel.setLayout(new BorderLayout());
        
        aboutPanel.add(aboutTitle, BorderLayout.NORTH);
        aboutPanel.add(toMainMenu, BorderLayout.CENTER);
        
        //Instructions Panel
        instructionsPanel.setPreferredSize(new Dimension(780, 720));
        instructionsPanel.setBackground(Color.gray);
        instructionsPanel.setLayout(new BorderLayout());
        
        instructionsPanel.add(instructionsTitle, BorderLayout.NORTH);
        instructionsPanel.add(toMainMenu, BorderLayout.CENTER);

        //Reviewer Panel
        reviewerPanel.setPreferredSize(new Dimension(780, 720));
        reviewerPanel.setBackground(Color.gray);
        reviewerPanel.setLayout(new BorderLayout());
        
        reviewerPanel.add(reviewerTitle, BorderLayout.NORTH);
        reviewerPanel.add(toMainMenu, BorderLayout.CENTER);

        //Game Proper Panels
        gamePanel.setPreferredSize(new Dimension(780, 720));
        gamePanel.setBackground(Color.gray);

        //Button init
        toMainMenu.addActionListener(this);
        toGame.addActionListener(this);
        toAbout.addActionListener(this);
        toInstructions.addActionListener(this);
        toReviewer.addActionListener(this);

        //Addition of Components
        //separates titlePanel(Left) and main content called rightPanel(Right)
        rightPanel = mainMenuPanel;
        add(titlePanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        JButton clicked = (JButton)a.getSource();
        remove(rightPanel);
        
        if(clicked == toGame){
            gamePanel.resetGame();
        }else{
            //replaces rightPanel components to clicked button while titlePanel is the same
            if(clicked == toMainMenu){
                titlePanel.setPreferredSize(new Dimension(590, 300));
                rightPanel = mainMenuPanel;
            }else{
                titlePanel.setPreferredSize(new Dimension(400, 300));
                if(clicked == toAbout){
                    rightPanel = aboutPanel;
                }else if(clicked == toInstructions){
                    rightPanel = instructionsPanel;
                }else if(clicked == toReviewer){
                    rightPanel = reviewerPanel;
                }
            }
            add(rightPanel);
        }
        
        repaint();
        revalidate();
    }
}
