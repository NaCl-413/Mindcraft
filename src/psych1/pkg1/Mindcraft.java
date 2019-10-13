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

    private JPanel titlePanel;
    private JPanel mainMenu;
    private JPanel game;
    private JPanel about;
    private JPanel instructions;
    private JPanel reviewer;
    private JPanel rightPanel;

    private JButton toMainMenu = new JButton("MAIN MENU");
    private JButton toGame = new JButton("START");
    private JButton toAbout = new JButton("ABOUT");
    private JButton toInstructions = new JButton("INSTRUCTION");
    private JButton toReviewer = new JButton("REVIEWER");

    private JLabel title = new JLabel("MindCraft", JLabel.CENTER);;

    public Mindcraft(){
        super("MINDCRAFT");
        setLayout(new BorderLayout());

        //Panel init
        //Title Panel
        titlePanel.setPreferredSize(new Dimension(300, 300));
        titlePanel.setBackground(Color.cyan);
        titlePanel.setLayout(new BorderLayout());

        titlePanel.add(title, BorderLayout.CENTER);

        //Main Menu Panel
        mainMenu.setPreferredSize(new Dimension(300, 300));
        mainMenu.setBackground(Color.gray);
        mainMenu.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        mainMenu.add(toGame);
        mainMenu.add(toAbout);
        mainMenu.add(toInstructions);
        mainMenu.add(toReviewer);

        //About Panel
        about.setPreferredSize(new Dimension(300, 300));
        about.setBackground(Color.gray);

        //Instructions Panel
        instructions.setPreferredSize(new Dimension(300, 300));
        instructions.setBackground(Color.gray);

        //Reviewer Panel
        reviewer.setPreferredSize(new Dimension(300, 300));
        reviewer.setBackground(Color.gray);

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


        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        JButton clicked = (JButton)a.getSource();
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
        repaint();
        revalidate();
    }
}
