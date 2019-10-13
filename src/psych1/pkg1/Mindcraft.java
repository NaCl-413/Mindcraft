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

    private JButton toMainMenu = new JButton("MAIN MENU");
    private JButton toGame = new JButton("START");
    private JButton toAbout = new JButton("ABOUT");
    private JButton toInstruction = new JButton("INSTRUCTION");
    private JButton toReviewer = new JButton("REVIEWER");

    public Mindcraft(){
        super("MINDCRAFT");
        setLayout(new BorderLayout());

        titlePanel.setPreferredSize(new Dimension(300, 300));
        titlePanel.setBackground(Color.cyan);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
    }
}