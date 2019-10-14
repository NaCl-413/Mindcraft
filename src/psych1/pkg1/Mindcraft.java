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

    private Game game = new Game();
    
    private JPanel titlePanel = new JPanel();
    private JPanel mainMenu = new JPanel();
    private JPanel about = new JPanel();
    private JPanel instructions = new JPanel();
    private JPanel reviewer = new JPanel();
    private JPanel rightPanel = new JPanel();

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

        //Panel init
        //Title Panel
        titlePanel.setPreferredSize(new Dimension(300, 300));
        titlePanel.setBackground(Color.cyan);
        titlePanel.setLayout(new BorderLayout());

        titlePanel.add(mainTitle, BorderLayout.CENTER);

        //Main Menu Panel
        mainMenu.setPreferredSize(new Dimension(300, 300));
        mainMenu.setBackground(Color.gray);
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));

        mainMenu.add(toGame);
        mainMenu.add(toAbout);
        mainMenu.add(toInstructions);
        mainMenu.add(toReviewer);

        //About Panel
        about.setPreferredSize(new Dimension(300, 300));
        about.setBackground(Color.gray);
        about.setLayout(new BorderLayout());
        
        about.add(aboutTitle, BorderLayout.NORTH);
        about.add(toMainMenu, BorderLayout.CENTER);
        
        //Instructions Panel
        instructions.setPreferredSize(new Dimension(300, 300));
        instructions.setBackground(Color.gray);
        instructions.setLayout(new BorderLayout());
        
        instructions.add(instructionsTitle, BorderLayout.NORTH);
        instructions.add(toMainMenu, BorderLayout.CENTER);

        //Reviewer Panel
        reviewer.setPreferredSize(new Dimension(300, 300));
        reviewer.setBackground(Color.gray);
        reviewer.setLayout(new BorderLayout());
        
        reviewer.add(reviewerTitle, BorderLayout.NORTH);
        reviewer.add(toMainMenu, BorderLayout.CENTER);

        //Game Proper Panels
        game.setPreferredSize(new Dimension(300, 300));
        game.setBackground(Color.gray);

        //Button init
        toMainMenu.addActionListener(this);
        toGame.addActionListener(this);
        toAbout.addActionListener(this);
        toInstructions.addActionListener(this);
        toReviewer.addActionListener(this);

        rightPanel = mainMenu;
        add(titlePanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        JButton clicked = (JButton)a.getSource();
        remove(rightPanel);
        if(clicked == toMainMenu){
            titlePanel.setPreferredSize(new Dimension(300, 300));
            rightPanel = mainMenu;
        }else{
            titlePanel.setPreferredSize(new Dimension(100, 300));
            if(clicked == toAbout){
                rightPanel = about;
            }else if(clicked == toInstructions){
                rightPanel = instructions;
            }else if(clicked == toReviewer){
                rightPanel = reviewer;
            }else if(clicked == toGame){
                rightPanel = game;
            }
        }
        add(rightPanel);
        repaint();
        revalidate();
    }
}
