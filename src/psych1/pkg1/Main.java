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
                Mindcraft game = new Mindcraft();

                game.setSize(600,600);
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setVisible(true);
            }
        });

    }
}
