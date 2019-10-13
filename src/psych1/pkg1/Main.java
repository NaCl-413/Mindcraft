/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psych1.pkg1;

import javax.swing.SwingUtilities;

/**
 *
 * @author Gavin Nigel Chuacuco
 */
public class Psych11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainMenu();
                
            }
            //Testing
            
        });
        
        
        
    }
    
}
