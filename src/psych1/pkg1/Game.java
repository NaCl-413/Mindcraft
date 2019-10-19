package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener{
    
    private String q1File = "questionnaire1.txt";
    private String q2File = "questionnaire2.txt";
    private String q3File = "questionnaire3.txt";
    
    private String[] g1Questions;
    private String[] g1CorrectAns;
    private String[] g1WrongAns;
    
    private JPanel game1Panel = new JPanel();
    private JPanel game2Panel = new JPanel();
    private JPanel game3Panel = new JPanel();
    
    private JLabel game1Title = new JLabel("GAME 1", JLabel.CENTER);
    private JLabel game2Title = new JLabel("GAME 2", JLabel.CENTER);
    private JLabel game3Title = new JLabel("GAME 3", JLabel.CENTER);
    
    private Questionnaire g1Questionnaire;
    private Questionnaire g2Questionnaire;
    private Questionnaire g3Questionnaire;
            
    public Game(){
        try {
        //Game Panels Init
        //Game1 Panel
            game1Panel.setPreferredSize(new Dimension(1180, 360));
            game1Panel.setLayout(new BorderLayout());

            game1Panel.add(game1Title, BorderLayout.CENTER);

        //Game2 Panel
            game2Panel.setPreferredSize(new Dimension(590, 360));
            game2Panel.setLayout(new BorderLayout());

            game2Panel.add(game2Title, BorderLayout.CENTER);

        //Game3 Panel
            game3Panel.setPreferredSize(new Dimension(590, 360));
            game3Panel.setLayout(new BorderLayout());

            game3Panel.add(game3Title, BorderLayout.CENTER);
            
        //Questionnaire Init
            ArrayList<Questionnaire> masterList = new ArrayList<Questionnaire>();
        
            //for every question file per game to put into an array
            String line = null;
            String[] fileList = {q1File, q2File, q3File};
            
            ArrayList<String> questionList;
            ArrayList<String> correctAnsList;
            ArrayList<String> wrongAnsList;
            String[] split;
            
            for(String s: fileList){
                questionList = new ArrayList<String>();
                correctAnsList = new ArrayList<String>();
                wrongAnsList = new ArrayList<String>();
                split = new String[3];

                //reads file and separates per line by % and stores into arraylists
                BufferedReader reader = new BufferedReader(new FileReader(s));
                while((line = reader.readLine()) != null) {
                    split = line.split("%");
                    questionList.add(split[0]);
                    correctAnsList.add(split[1]);
                    wrongAnsList.add(split[2]);
                }
                //data structure change: ArrayList to Array
                String[] tempQArray = new String[questionList.size()];
                String[] tempCArray = new String[correctAnsList.size()];
                String[] tempWArray = new String[wrongAnsList.size()];
                tempQArray = questionList.toArray(tempQArray);
                tempCArray = correctAnsList.toArray(tempCArray);
                tempWArray = wrongAnsList.toArray(tempWArray);

                //adds Questionnaire to arraylist
                masterList.add(new Questionnaire(tempQArray,tempCArray,tempWArray));
                reader.close();
            }

            Questionnaire[] tempMArray = new Questionnaire[masterList.size()];
            tempMArray = masterList.toArray(tempMArray);
            g1Questionnaire = tempMArray[0];
            g2Questionnaire = tempMArray[1];
            g3Questionnaire = tempMArray[2];
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void resetGame(){
        g1Questionnaire.resetQuestionnaire();
        g2Questionnaire.resetQuestionnaire();
        g3Questionnaire.resetQuestionnaire();
    }
    
    @Override
    public void actionPerformed(ActionEvent a) {
    }
}
