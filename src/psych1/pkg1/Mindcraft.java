package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mindcraft extends JFrame implements ActionListener{

    private JPanel titlePanel;
    private JPanel mainMenu;
    private JPanel game;
    private JPanel about;
    private JPanel instruction;
    private JPanel reviewer;
    private JPanel rightPanel;

    private JButton toMainMenu = new JButton("MAIN MENU");
    private JButton toGame = new JButton("START");
    private JButton toAbout = new JButton("ABOUT");
    private JButton toInstruction = new JButton("INSTRUCTION");
    private JButton toReviewer = new JButton("REVIEWER");

    public Mindcraft(){
        super("MINDCRAFT");
        setLayout(new BorderLayout());

        //Panel init
        titlePanel.setPreferredSize(new Dimension(300, 300));
        titlePanel.setBackground(Color.cyan);
        mainMenu.setPreferredSize(new Dimension(300, 300));
        mainMenu.setBackground(Color.gray);
        game.setPreferredSize(new Dimension(300, 300));
        game.setBackground(Color.gray);
        about.setPreferredSize(new Dimension(300, 300));
        about.setBackground(Color.gray);
        instruction.setPreferredSize(new Dimension(300, 300));
        instruction.setBackground(Color.gray);
        reviewer.setPreferredSize(new Dimension(300, 300));
        reviewer.setBackground(Color.gray);

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
            add(mainMenu, BorderLayout.CENTER);
        }else if(clicked == toGame){

        }
        repaint();
        revalidate();
    }
}
