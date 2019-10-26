package psych1.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Mindcraft extends JFrame implements ActionListener, KeyListener{
    
    private String q1File = "questionnaires\\questionnaire1.txt";
    private String q2File = "questionnaires\\questionnaire2.txt";
    private String q3File = "questionnaires\\questionnaire3.txt";
    
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
    private JPanel gameInterface = new JPanel();
    private JPanel game1Panel = new JPanel();
    private JPanel game2Panel = new JPanel();
    private JPanel game3Panel = new JPanel();
    
    private JScrollPane instructionsPane = new JScrollPane(new JLabel(instructionsImage));
    private JScrollPane reviewerPane = new JScrollPane(new JLabel(reviewerImage));
    private JScrollPane aboutPane = new JScrollPane(new JLabel(aboutImage));
    
    private JButton toMainMenu = new JButton("MAIN MENU");
    private JButton toGame = new JButton("PLAY");
    private JButton toAbout = new JButton("ABOUT");
    private JButton toInstructions = new JButton("INSTRUCTIONS");
    private JButton toReviewer = new JButton("REVIEWER");
    private JButton startGameB = new JButton("START GAME");  //Tentative start button for the game

    private JLabel mainTitle = new JLabel("MindCraft", JLabel.CENTER);
    private JLabel aboutTitle = new JLabel("ABOUT", JLabel.CENTER);
    private JLabel instructionsTitle = new JLabel("INSTRUCTIONS", JLabel.CENTER);
    private JLabel reviewerTitle = new JLabel("REVIEWER", JLabel.CENTER);
    
    private Font f = new Font("Helvetica",Font.BOLD,25);
    
    private JLabel game1Title = new JLabel("GAME 1", JLabel.CENTER);
    private JLabel game1Question = new JLabel("QUESTION: ", JLabel.CENTER);
    private JLabel game1OptionR = new JLabel("OPTION RIGHT", JLabel.CENTER);
    private JLabel game1OptionL = new JLabel("OPTION LEFT", JLabel.CENTER);
    
    private JLabel game2Title = new JLabel("GAME 2", JLabel.CENTER);
    private JLabel game2Pattern = new JLabel("WADSWSDAW", JLabel.CENTER);
    private JLabel game2UserInput = new JLabel("WADS", JLabel.CENTER);
    
    private JLabel game3Title = new JLabel("GAME 3", JLabel.CENTER);
    private JLabel game3Shape = new JLabel("SHAPE", JLabel.CENTER);
    private JLabel gameTimer = new JLabel("Time (00 : 00)", JLabel.CENTER);
        
    
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
    private int finalScore;
    
    public Mindcraft(){
        super("MINDCRAFT");
        setLayout(new BorderLayout());
        
    //Panel Initializations(Init)
    //Title Panel
        titlePanel.setPreferredSize(new Dimension(590, 720));
        titlePanel.setBackground(Color.gray);
        titlePanel.setLayout(new BorderLayout());
        mainTitle.setIcon(new ImageIcon("panelImage\\testTitlePanel.jpg"));
        titlePanel.add(mainTitle, BorderLayout.CENTER);
        
    //Main Menu Panel
        mainMenuPanel.setPreferredSize(new Dimension(590, 720));
        mainMenuPanel.setBackground(Color.gray);
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0,50)));
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
        
    //Game Interface (Timer and Main Menu)
        gameInterface.setPreferredSize(new Dimension(1250, 30));
        gameInterface.setLayout(new BorderLayout());  
        gameInterface.add(gameTimer, BorderLayout.CENTER);
        gameInterface.add(startGameB, BorderLayout.WEST);
        
    //Game1 Panel
        game1Panel.setPreferredSize(new Dimension(1250, 310));
        game1Panel.setLayout(new BorderLayout());
        game1Panel.add(game1Title, BorderLayout.CENTER);
        game1Panel.add(game1Question, BorderLayout.SOUTH);
        game1Question.setFont (f);
        game1Panel.add(game1OptionR, BorderLayout.EAST);
        game1Panel.add(game1OptionL, BorderLayout.WEST);
       /*
            DITO MO LAGAY COMPONENTS NG GAME 1       
        */
        
    //Game2 Panel
        game2Panel.setPreferredSize(new Dimension(625, 310));
        game2Panel.setLayout(new BorderLayout());
        game2Panel.add(game2Title, BorderLayout.CENTER);
        game2Panel.add(game2Pattern, BorderLayout.NORTH);
        game2Panel.add(game2UserInput, BorderLayout.SOUTH);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 2        
        */
        
    //Game3 Panel
        game3Panel.setPreferredSize(new Dimension(625, 310));
        game3Panel.setLayout(new BorderLayout());
        game3Panel.add(game3Title, BorderLayout.NORTH);
        game3Panel.add(game3Shape,BorderLayout.CENTER);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 3        
        */
        
    //Game Panel
        gamePanel.setPreferredSize(new Dimension(1280, 720));
        gamePanel.setBackground(Color.gray);
        gamePanel.add(gameInterface, BorderLayout.PAGE_START);
        gamePanel.add(game1Panel, BorderLayout.NORTH);
        gamePanel.add(game2Panel, BorderLayout.WEST);
        gamePanel.add(game3Panel, BorderLayout.EAST);
        
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
                    System.out.println(split[0] + "  " + split[1] + "  " + split[2]);
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
        updateQuestionPanel(4);
        
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
    //To indicate that the games have been finished
    private void gameEnd(int game){
        
        if(game == 1){
        game1Title.setText("GAME 1 FINISHED");
        game1Question.setText("GAME 1 FINISHED");
        game1OptionR.setText("GAME 1 FINISHED");
        game1OptionL.setText("GAME 1 FINISHED");
        }else if (game == 2){
        game2Pattern.setText("GAME 2 FINISHED");
        game2UserInput.setText("GAME 2 FINISHED");
        game2Title.setText("GAME 2 FINISHED");
        }else if (game == 3){
        game3Shape.setText("GAME 3 FINISHED");
        game3Title.setText("GAME 3 FINISHED");
        }else if (game == 4){  //Means that the whole game has ended
            wrongAnsCount = wrongAnsCount*5; //5 is our mistake-score multiplier
            finalScore = finalTime; /* Still not sure if finalTime will be minutes:seconds or just seconds. So both score and finalTime will be the same for now*/
            finalScore = finalScore - wrongAnsCount;
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"GAME FINISHED!\n\n" + "Time: " + finalTime + "\nMistake Penalty: "+ wrongAnsCount + "\nYour Score: " + finalScore, "GAME FINISHED!",1);  
        }
        
    }
    
    
    //Gets the next question and displays it
    private void updateQuestionPanel(int game){
        
        
        if(game == 1){
        game1Question.setText("<html>Question:  "+ g1Questionnaire.getCurQuestion() +"<br><br/>"+"</html>");
        game1OptionR.setText(Arrays.toString(g1Questionnaire.getCurChoices()));
        }else if (game == 2){
        game2Pattern.setText(g2Questionnaire.getCurQuestion());
        }else if (game == 3){
        game3Shape.setText(g3Questionnaire.getCurQuestion());
        }else if (game == 4){  //Means that it will need to update all 3 games
            //game 1
            game1Question.setText("<html>Question:  "+ g1Questionnaire.getCurQuestion() +"<br><br/>"+"</html>");
            game1OptionR.setText(Arrays.toString(g1Questionnaire.getCurChoices()));
            System.out.println(Arrays.toString(g1Questionnaire.getCurChoices()));
            //game 2
            game2Pattern.setText(g2Questionnaire.getCurQuestion());
            
            //game 3
            game3Shape.setText(g3Questionnaire.getCurQuestion());
        }
        
    }
    

    
    private boolean checkAnswer(int i, int a){
        
        boolean correct = false;
        if(i == 1){
            if(a == g1Questionnaire.getCurCorrectChoiceIndex()){
                correct = true;
            }
        }else if(i == 2){
            if(((a == 1)&&(g2Questionnaire.getCurCorrectAns() == "W"))
           ||((a == 2) && (g2Questionnaire.getCurCorrectAns() == "A"))
           ||((a == 3) && (g2Questionnaire.getCurCorrectAns() == "S"))
           ||((a == 4) && (g2Questionnaire.getCurCorrectAns() == "D"))){
                correct = true;
            }
            
        }else if(i == 3){
            if(((a == 1)&&(g3Questionnaire.getCurCorrectAns() == "true"))
           ||((a == 2) && (g3Questionnaire.getCurCorrectAns() == "false"))){
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
            titlePanel.setPreferredSize(new Dimension(0, 0));
            gameInterface.add(toMainMenu, BorderLayout.EAST);
            add(gamePanel);
            startGame();
        }else{
            //replaces rightPanel components to clicked button while titlePanel is the same
            if(clicked == toMainMenu){
                remove(gamePanel);
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
            game2UserInput.setText(game2UserInput.getText()+"W");
        }
        if(key == KeyEvent.VK_A){
            isKeyCorrect = true;
            keyNumber = 2;
            gameNumber = 3;
            game2UserInput.setText(game2UserInput.getText()+"A");
        }
        if(key == KeyEvent.VK_S){
            isKeyCorrect = true;
            keyNumber = 3;
            gameNumber = 3;
            game2UserInput.setText(game2UserInput.getText()+"S");
        }
        if(key == KeyEvent.VK_D){
            isKeyCorrect = true;
            keyNumber = 4;
            gameNumber = 3;
            game2UserInput.setText(game2UserInput.getText()+"D");
        }
        if(isKeyCorrect){
            boolean correct = false;
            correct = checkAnswer(gameNumber, keyNumber);
            
            if(correct){
                if(gameNumber == 1){
                    if(!g1Questionnaire.nextQuestion()){
                        isG1End = true;
                        updateQuestionPanel(1);
                    }
                }else if(gameNumber == 2){
                    if(!g2Questionnaire.nextQuestion()){
                        isG2End = true;
                        updateQuestionPanel(2);
                    }
                }else if(gameNumber == 3){
                    if(!g3Questionnaire.nextQuestion()){
                        isG3End = true;
                        updateQuestionPanel(3);
                    }
                }
                
                
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
