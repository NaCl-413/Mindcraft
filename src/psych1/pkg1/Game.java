package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{
    
    private JPanel game1 = new JPanel();
    private JPanel game2 = new JPanel();
    private JPanel game3 = new JPanel();
    
    public JLabel jTitle = new JLabel();
    
    public long runningTime;
    public long hours;
    public long minutes;
    public long seconds;
    public long millis;
    public long mistakes = 0;
    
    public Game(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent a) {
    }
}
