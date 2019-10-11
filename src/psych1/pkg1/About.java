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
import javax.swing.SwingUtilities;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class About extends JFrame{
    
    private toMain toolbar;
    
    public About(){
        super("ABOUT");
        
        setLayout(new BorderLayout());
        
        toolbar = new toMain();
    
        add(toolbar, BorderLayout.SOUTH);
        
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
}
