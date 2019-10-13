/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class Start extends JPanel{

    private jPanelGame1 jPanelG1;
    private jPanelGame2 jPanelG2;
    private jPanelGame3 jPanelG3;
    public JLabel jTitle;
    
    public Start(){
        setLayout(new BorderLayout());
        jPanelG1 = new jPanelGame1();
        add(jPanelG1,BorderLayout.NORTH);
        jPanelG1.setPreferredSize(new Dimension(1180,360));
        jPanelG1.setBackground(Color.gray);
        
        jPanelG2 = new jPanelGame2();
        add(jPanelG2,BorderLayout.WEST);
        jPanelG2.setPreferredSize(new Dimension(590,360));
        jPanelG2.setBackground(Color.LIGHT_GRAY);
        
        jPanelG3 = new jPanelGame3();
        add(jPanelG3,BorderLayout.EAST);
        jPanelG3.setPreferredSize(new Dimension(590,360));
        jPanelG3.setBackground(Color.WHITE);

    }



    class jPanelGame1 extends JPanel{

        
        
        jPanelGame1 (){
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 1", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);
    }
    
    }
    
    class jPanelGame2 extends JPanel{

        public jPanelGame2() {
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 2", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);    
            
        }
    }

    class jPanelGame3 extends JPanel{

        public jPanelGame3() {
        setLayout(new BorderLayout());
        jTitle = new JLabel("GAME 3", JLabel.CENTER);
        add(jTitle, BorderLayout.CENTER);    
        }
    }
    
}
