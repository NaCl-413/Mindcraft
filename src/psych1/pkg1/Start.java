/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class Start extends JFrame{

    private toMain toolbar;
    /*
    private toMain toolbar;
    
    toolbar = new toMain();
    
    add(toolbar, BorderLayout.SOUTH);
    */
    public Start(){
        super("START");
        
        setLayout(new BorderLayout());
        
        toolbar = new toMain();
    
        add(toolbar, BorderLayout.SOUTH);
        
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
}
