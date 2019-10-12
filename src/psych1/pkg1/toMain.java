/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class toMain extends JPanel implements ActionListener{
    
    private JButton toMenuButton;
    //private jPanelRight jPanelR;
    
    public toMain(){
        toMenuButton = new JButton("MAIN MENU");       
        toMenuButton.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        add(toMenuButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        
        if(clicked == toMenuButton){            

              System.out.println("IT REACHED TO MAIN MENU BUTTON");
              removeAll();
              
            
        }
    
    }

}
