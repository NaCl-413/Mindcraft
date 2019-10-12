/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class Start extends JPanel{

    private toMain toolbar;
    private jPanelGame1 jPanelG1;
    public JLabel jTitle;
    
    public Start(){
        
        jPanelG1 = new jPanelGame1();
        add(jPanelG1,BorderLayout.CENTER);
        jPanelG1.setBackground(Color.cyan);
        setLayout(new BorderLayout());
        toolbar = new toMain();

        jTitle = new JLabel("GAME 1", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);
        add(toolbar, BorderLayout.SOUTH);
        
        setSize(500,600);
        
        
    }

    class jPanelGame1 extends JPanel{

        public JLabel jTitle;
        
        
        jPanelGame1 (){
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 1", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);
    }
    
    }
    
    
    
}
