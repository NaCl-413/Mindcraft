/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class MainMenu extends JFrame implements ActionListener{
    
    private jPanelLeft jPanelL;
    private jPanelRight jPanelR;
    private Start jPanelStart;
    private About jPanelAbout;
    private Instructions jPanelInstructions;
    private Reviewer jPanelReviewer;
    private JButton mainMenu;
    private JButton start;
    private JButton about;
    private JButton instructions;
    private JButton reviewer;
    
    
    public MainMenu(){
        super("MINDCRAFT"); 
        setLayout(new BorderLayout());
        
        jPanelL = new jPanelLeft();
        jPanelR = new jPanelRight();
       
        add(jPanelL, BorderLayout.WEST);
        jPanelL.setPreferredSize(new Dimension(300, 300));
        jPanelL.setBackground(Color.cyan);
        
        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(this);
        jPanelL.add(mainMenu, BorderLayout.SOUTH);
        mainMenu.setVisible(false);
        
        add(jPanelR, BorderLayout.CENTER);
        jPanelR.setPreferredSize(new Dimension(300, 300));
        jPanelR.setBackground(Color.GRAY); 
        
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        JButton clicked = (JButton)ae.getSource();
        if(clicked == mainMenu){
        
        System.out.println("IT REACHED MAIN MENU BUTTON");
        remove(jPanelR);
        jPanelL.setPreferredSize(new Dimension(300, 300));
        jPanelR = new jPanelRight();
        add(jPanelR, BorderLayout.CENTER);
        jPanelR.setPreferredSize(new Dimension(300, 300));
        jPanelR.setBackground(Color.GRAY);
        mainMenu.setVisible(false);
        repaint();
        revalidate();
        }else {}
            
    }
    
class jPanelLeft extends JPanel{
    
    public JLabel jTitle;
    
    
    jPanelLeft (){
        
        setLayout(new BorderLayout());
        jTitle = new JLabel("MindCraft", JLabel.CENTER);
        
        add(jTitle, BorderLayout.CENTER);

    }
    
}

public class jPanelRight extends JPanel implements ActionListener{


    
    jPanelRight() {
        
        start = new JButton("START");
        about = new JButton("ABOUT");
        instructions = new JButton("INSTRUCTIONS");
        reviewer = new JButton("REVIEWER");
        
        start.addActionListener(this);
        about.addActionListener(this);
        instructions.addActionListener(this);
        reviewer.addActionListener(this);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));        
        
        add(start);
        add(about);
        add(instructions);
        add(reviewer);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton clicked = (JButton)e.getSource();
        mainMenu.setVisible(true);
        if(clicked == start){
            
            jPanelStart = new Start();
            jPanelL.setPreferredSize(new Dimension(100, 300));
            jPanelR.removeAll();
            add(jPanelStart, BorderLayout.CENTER);
            repaint();
            revalidate();
            
        }else if(clicked == about){
            
            jPanelAbout = new About();
            jPanelL.setPreferredSize(new Dimension(100, 300));
            jPanelR.removeAll();
            add(jPanelAbout, BorderLayout.CENTER);
            repaint();
            revalidate();
            
            
        }else if(clicked == instructions){
            
            jPanelInstructions = new Instructions();
            jPanelL.setPreferredSize(new Dimension(100, 300));
            jPanelR.removeAll();
            jPanelR.removeAll();
            add(jPanelInstructions, BorderLayout.CENTER);
            repaint();
            revalidate();
            
        }else if(clicked == reviewer){
            
            jPanelReviewer = new Reviewer();
            jPanelL.setPreferredSize(new Dimension(100, 300));
            jPanelR.removeAll();
            add(jPanelReviewer, BorderLayout.CENTER);
            repaint();
            revalidate();
            
        }else {
            
        }
        
        
    }
    
}
}