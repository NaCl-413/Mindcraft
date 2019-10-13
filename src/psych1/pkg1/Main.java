package psych1.pkg1;

import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Mindcraft();

            }
            //Testing

        });



    }

}
