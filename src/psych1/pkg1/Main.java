package psych1.pkg1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                //Main JFrame init
                Mindcraft g = new Mindcraft();
                
                g.setSize(1280,720);
                g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                g.setVisible(true);
            }
        });

    }
}
