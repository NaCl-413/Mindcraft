/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class Reviewer extends JPanel{

    private toMain toolbar;
    public JLabel jTitle;
    
    public Reviewer(){
        
        System.out.println("IT REACHED TO ABOUT PANEL CLASS");
        setLayout(new BorderLayout());
        jTitle = new JLabel("REVIEWER", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);
        toolbar = new toMain();
        add(toolbar, BorderLayout.SOUTH);
        
        setSize(500,600);
        
    }

}

