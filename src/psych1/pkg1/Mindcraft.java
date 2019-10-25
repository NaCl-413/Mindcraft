package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Mindcraft extends JFrame implements ActionListener, KeyListener{
    
    private String q1File = "questionnaire1.txt";
    private String q2File = "questionnaire2.txt";
    private String q3File = "questionnaire3.txt";
    
    private ImageIcon aboutImage = new ImageIcon("C:\\Users\\Gavin Nigel Chuacuco\\Desktop\\Desktop\\Screenshots\\longverticalpicforjava.jpg");
    private ImageIcon instructionsImage = new ImageIcon("C:\\Users\\Gavin Nigel Chuacuco\\Desktop\\Desktop\\Screenshots\\longverticalpicforjava.jpg");
    private ImageIcon reviewerImage = new ImageIcon("C:\\Users\\Gavin Nigel Chuacuco\\Desktop\\Desktop\\Screenshots\\longverticalpicforjava.jpg");
    
    private JPanel titlePanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel mainMenuPanel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel aboutPanel = new JPanel();
    private JPanel instructionsPanel = new JPanel();
    private JPanel reviewerPanel = new JPanel();
    private JPanel game1Panel = new JPanel();
    private JPanel game2Panel = new JPanel();
    private JPanel game3Panel = new JPanel();
    
    private JScrollPane instructionsPane = new JScrollPane(new JLabel(instructionsImage));
    private JScrollPane reviewerPane = new JScrollPane(new JLabel(reviewerImage));
    private JScrollPane aboutPane = new JScrollPane(new JLabel(aboutImage));
    
    private JButton toMainMenu = new JButton("MAIN MENU");
    private JButton toGame = new JButton("START");
    private JButton toAbout = new JButton("ABOUT");
    private JButton toInstructions = new JButton("INSTRUCTIONS");
    private JButton toReviewer = new JButton("REVIEWER");

    private JLabel mainTitle = new JLabel("MindCraft", JLabel.CENTER);
    private JLabel aboutTitle = new JLabel("ABOUT", JLabel.CENTER);
    private JLabel instructionsTitle = new JLabel("INSTRUCTIONS", JLabel.CENTER);
    private JLabel reviewerTitle = new JLabel("REVIEWER", JLabel.CENTER);
    private JLabel game1Title = new JLabel("GAME 1", JLabel.CENTER);
    private JLabel game2Title = new JLabel("GAME 2", JLabel.CENTER);
    private JLabel game3Title = new JLabel("GAME 3", JLabel.CENTER);
    
    private Questionnaire g1Questionnaire;
    private Questionnaire g2Questionnaire;
    private Questionnaire g3Questionnaire;
    
    private boolean isInGame = false;
    private boolean isEnd = false;
    private boolean isG1End = false;
    private boolean isG2End = false;
    private boolean isG3End = false;
    private int wrongAnsCount;
    private int finalTime;
    
    public Mindcraft(){
        super("MINDCRAFT");
        setLayout(new BorderLayout());

    //Panel Initializations(Init)
    //Title Panel
        titlePanel.setPreferredSize(new Dimension(590, 720));
        titlePanel.setBackground(Color.cyan);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(mainTitle, BorderLayout.CENTER);

    //Main Menu Panel
        mainMenuPanel.setPreferredSize(new Dimension(590, 720));
        mainMenuPanel.setBackground(Color.gray);
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0,65)));
        mainMenuPanel.add(toGame);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0,130)));
        mainMenuPanel.add(toAbout);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0,130)));
        mainMenuPanel.add(toInstructions);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0,130)));
        mainMenuPanel.add(toReviewer);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0,65)));

        toGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        toAbout.setAlignmentX(Component.CENTER_ALIGNMENT);
        toInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        toReviewer.setAlignmentX(Component.CENTER_ALIGNMENT);
        toGame.add(Box.createRigidArea(new Dimension(100,30)));
        toAbout.add(Box.createRigidArea(new Dimension(100,30)));
        toInstructions.add(Box.createRigidArea(new Dimension(100,30)));
        toReviewer.add(Box.createRigidArea(new Dimension(100,30)));

    //About Panel
        aboutPanel.setPreferredSize(new Dimension(780, 720));
        aboutPanel.setBackground(Color.gray);
        aboutPanel.setLayout(new BorderLayout());
        aboutPanel.add(aboutTitle, BorderLayout.NORTH);
        aboutPanel.add(aboutPane,BorderLayout.CENTER);
        
    //Instructions Panel
        instructionsPanel.setPreferredSize(new Dimension(780, 720));
        instructionsPanel.setBackground(Color.gray);
        instructionsPanel.setLayout(new BorderLayout());
        instructionsPanel.add(instructionsTitle, BorderLayout.NORTH);
        instructionsPanel.add(instructionsPane,BorderLayout.CENTER);

    //Reviewer Panel
        reviewerPanel.setPreferredSize(new Dimension(780, 720));
        reviewerPanel.setBackground(Color.gray);
        reviewerPanel.setLayout(new BorderLayout());
        reviewerPanel.add(reviewerTitle, BorderLayout.NORTH);
        reviewerPanel.add(reviewerPane,BorderLayout.CENTER);

    //Game Panel
        gamePanel.setPreferredSize(new Dimension(1180, 720));
        gamePanel.setBackground(Color.gray);
        gamePanel.setFocusable(true);
    //Game1 Panel
        game1Panel.setPreferredSize(new Dimension(1180, 360));
        game1Panel.setLayout(new BorderLayout());
        game1Panel.add(game1Title, BorderLayout.CENTER);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 1        
        */
        
    //Game2 Panel
        game2Panel.setPreferredSize(new Dimension(590, 360));
        game2Panel.setLayout(new BorderLayout());
        game2Panel.add(game2Title, BorderLayout.CENTER);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 2        
        */
        
    //Game3 Panel
        game3Panel.setPreferredSize(new Dimension(590, 360));
        game3Panel.setLayout(new BorderLayout());
        game3Panel.add(game3Title, BorderLayout.CENTER);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 3        
        */
        gamePanel.add(game1Panel);
        gamePanel.add(game2Panel);
        gamePanel.add(game3Panel);
        gamePanel.addKeyListener(this);
        
    //Buttons Init
        toMainMenu.addActionListener(this);
        toGame.addActionListener(this);
        toAbout.addActionListener(this);
        toInstructions.addActionListener(this);
        toReviewer.addActionListener(this);    

    //Questionnaire Init
        Questionnaire[] tempArray = questionnaireInit();
        g1Questionnaire = tempArray[0];
        g2Questionnaire = tempArray[1];
        g3Questionnaire = tempArray[2];

    //Addition of Components
        //separates titlePanel(Left) and main content called rightPanel(Right)
        rightPanel = mainMenuPanel;
        add(titlePanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
        
    }
    
    private Questionnaire[] questionnaireInit(){
        ArrayList<Questionnaire> masterList = new ArrayList<Questionnaire>();

        //for every question file per game to put into an array
        String line = null;
        String[] fileList = {q1File, q2File, q3File};

        ArrayList<String> questionList;
        ArrayList<String> correctAnsList;
        ArrayList<String> wrongAnsList;
        String[] split;
            
        try {
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
        }catch(Exception e){
            System.out.println(e);
        }

        Questionnaire[] tempMArray = new Questionnaire[masterList.size()];
        tempMArray = masterList.toArray(tempMArray);
        
        return tempMArray;
    }
    
    private void startGame(){
        gamePanel.requestFocusInWindow();
        resetGame();
        int startTime = (int)System.currentTimeMillis()/1000;
        int prevTime = startTime;
        int currentTime;
        /*
        while(!isEnd){
            currentTime = (int)System.currentTimeMillis()/1000;
            //1 frame per sec
            if(currentTime == prevTime){
                
                    DITO MO LAGAY PAGPALIT NG TIMER SA PANEL        
                
                revalidate();
                repaint();
            }
            //*if game1, game2 and game3 is finished then isEnd = true
        }
        */
    }
    
    private void resetGame(){
        g1Questionnaire.resetQuestionnaire();
        g2Questionnaire.resetQuestionnaire();
        g3Questionnaire.resetQuestionnaire();
    }
    
    private void updateQuestionPanel(){
        /*
            DITO MO LAGAY PAGPALIT NG QUESTION                                          
        */
    }
    
    private boolean checkAnswer(int i, int a){
        boolean correct = false;
        if(i == 1){
            if(a == g1Questionnaire.getCorrectAnswerIndex()){
                correct = true;
            }
        }else if(i == 2){
            int cQuestion = g2Questionnaire.getCurrentQuestionIndex();
            if(((a == 1)&&(g2Questionnaire.getCorrectAnswer(cQuestion) == "W"))
           ||((a == 2) && (g2Questionnaire.getCorrectAnswer(cQuestion) == "A"))
           ||((a == 3) && (g2Questionnaire.getCorrectAnswer(cQuestion) == "S"))
           ||((a == 4) && (g2Questionnaire.getCorrectAnswer(cQuestion) == "D"))){
                correct = true;
            }
            
        }else if(i == 3){
            int cQuestion = g3Questionnaire.getCurrentQuestionIndex();
            if(((a == 1)&&(g3Questionnaire.getCorrectAnswer(cQuestion) == "true"))
           ||((a == 2) && (g3Questionnaire.getCorrectAnswer(cQuestion) == "false"))){
                correct = true;
            }
        }
        return correct;
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        System.out.println("reached actionPerformed");
        JButton clicked = (JButton)a.getSource();
        remove(rightPanel);
        
        if(clicked == toGame){
            isInGame = true;
            
            remove(titlePanel);
            add(gamePanel);
            
            startGame();
        }else{
            //replaces rightPanel components to clicked button while titlePanel is the same
            if(clicked == toMainMenu){
                titlePanel.setPreferredSize(new Dimension(590, 300));
                rightPanel = mainMenuPanel;
            }else{
                titlePanel.setPreferredSize(new Dimension(400, 300));
                if(clicked == toAbout){
                    rightPanel = aboutPanel;
                    aboutPanel.add(toMainMenu, BorderLayout.PAGE_END);
                }else if(clicked == toInstructions){
                    rightPanel = instructionsPanel;
                    instructionsPanel.add(toMainMenu, BorderLayout.PAGE_END);
                }else if(clicked == toReviewer){
                    rightPanel = reviewerPanel;
                    reviewerPanel.add(toMainMenu, BorderLayout.PAGE_END);
                }
            }
            add(rightPanel);
        }
        
        repaint();
        revalidate();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        boolean isKeyCorrect = false;
        int gameNumber = 0;
        int keyNumber = 0;
        int key = e.getKeyCode();
                                              
        if(key == KeyEvent.VK_LEFT){
            isKeyCorrect = true;
            keyNumber = 1;
            gameNumber = 1;
        }
        if(key == KeyEvent.VK_RIGHT){
            isKeyCorrect = true;
            keyNumber = 2;
            gameNumber = 1;     
        }
        if(key == KeyEvent.VK_UP){
            isKeyCorrect = true;
            keyNumber = 1;
            gameNumber = 2;
        }
        if(key == KeyEvent.VK_DOWN){
            isKeyCorrect = true;
            keyNumber = 2;
            gameNumber = 2;
        }
        if(key == KeyEvent.VK_W){
            isKeyCorrect = true;
            keyNumber = 1;
            gameNumber = 3;
        }
        if(key == KeyEvent.VK_A){
            isKeyCorrect = true;
            keyNumber = 2;
            gameNumber = 3;
        }
        if(key == KeyEvent.VK_S){
            isKeyCorrect = true;
            keyNumber = 3;
            gameNumber = 3;
        }
        if(key == KeyEvent.VK_D){
            isKeyCorrect = true;
            keyNumber = 4;
            gameNumber = 3;
        }
        if(isKeyCorrect){
            boolean correct = false;
            correct = checkAnswer(gameNumber, keyNumber);
            
            if(correct){
                if(gameNumber == 1){
                    if(!g1Questionnaire.nextQuestion()){
                        isG1End = true;
                    }
                }else if(gameNumber == 2){
                    if(!g2Questionnaire.nextQuestion()){
                        isG2End = true;
                    }
                }else if(gameNumber == 3){
                    if(!g3Questionnaire.nextQuestion()){
                        isG3End = true;
                    }
                }
                
                updateQuestionPanel();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try{}catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{}catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
