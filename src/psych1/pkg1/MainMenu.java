/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class MainMenu extends JFrame{
    
    TextPanel1 textPanel;
    JPanelRight jPanel;
    /*
    private toMain toolbar;
    
    toolbar = new toMain();
    
    add(toolbar, BorderLayout.SOUTH);
    */
    public MainMenu(){
        super("MINDCRAFT"); 
        
        
        setLayout(new BorderLayout());

        textPanel = new TextPanel1();
        jPanel = new JPanelRight();
        
        add(textPanel, BorderLayout.CENTER);
        textPanel.setPreferredSize(new Dimension(300, 300));
        add(jPanel, BorderLayout.EAST);
        jPanel.setPreferredSize(new Dimension(300, 300));
        
        
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }   
    
}

class TextPanel1 extends JPanel {
    
    private JTextArea textArea;
    
    public TextPanel1(){
        textArea = new JTextArea();
        
        setLayout(new BorderLayout());
        
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    
    public void appendText (String text){
        textArea.append(text);
    }
}

class JPanelRight extends JPanel implements ActionListener{

    private JButton start;
    private JButton about;
    private JButton instructions;
    private JButton reviewer;
    
    JPanelRight() {
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
        
        if(clicked == start){
            
            SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Start();    
            }
            });
            
        }else if(clicked == about){
            
            SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new About();
                
            }
            });
            
        }else if(clicked == instructions){
                
            SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Instructions();
                
            }
            });
            
        }else if(clicked == reviewer){
            
            SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Reviewer();
                
            }
            });
            
        }else {
            
        }
        
        
    }
    
}