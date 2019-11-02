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
    
    private String q1File = "questionnaires/questionnaire1.txt";
    private String q2File = "questionnaires/questionnaire2.txt";
    private String q3File = "questionnaires/questionnaire3.txt";
    
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
    private JPanel game1PanelL = new JPanel();
    private JPanel game1PanelR = new JPanel();
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
    
    private Font questionFont = new Font("Helvetica",Font.BOLD,25);
    private Font optionFont = new Font("Helvetica",Font.BOLD,20);
    
    private JLabel game1Title = new JLabel("GAME 1", JLabel.CENTER);
    private JLabel game1Question = new JLabel("QUESTION: ", JLabel.CENTER);
    private JLabel game1OptionR = new JLabel("OPTION RIGHT", JLabel.CENTER);
    private JLabel game1OptionL = new JLabel("OPTION LEFT", JLabel.CENTER);
    
    private JLabel game2Title = new JLabel("GAME 2", JLabel.CENTER);
    private JLabel game2Pattern = new JLabel("WADSWSDAW", JLabel.CENTER);
    private JLabel game2UserInput = new JLabel("", JLabel.CENTER);
    
    private JLabel game3Title = new JLabel("GAME 3", JLabel.CENTER);
    private JLabel game3Shape = new JLabel("SHAPE", JLabel.CENTER);
    private JLabel game3Text = new JLabel("DESCRIPTION", JLabel.CENTER);
    private JLabel gameWrongAns = new JLabel("", JLabel.CENTER);
        
    
    private Questionnaire g1Questionnaire;
    private Questionnaire g2Questionnaire;
    private Questionnaire g3Questionnaire;
    
    private boolean isEnd = false;
    private boolean isG1End = false;
    private boolean isG2End = false;
    private boolean isG3End = false;
    private int g1Answered = 0;
    private int g2Answered = 0;
    private int g3Answered = 0;
    private int g1ChoiceCounter = 0;
    private int g2ChoiceCounter = 0;
    private int g3ChoiceCounter = 0;
    private int wrongAnsCount = 0;
    private int startTime;
    private int currentTime;
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
        gameInterface.add(gameWrongAns, BorderLayout.CENTER);
        gameInterface.add(startGameB, BorderLayout.WEST);
        
    //Game1 Panel
        game1Panel.setPreferredSize(new Dimension(1250, 310));
        game1Panel.setLayout(new BorderLayout());
        game1PanelL.setPreferredSize(new Dimension(625, 155));
        game1PanelL.setLayout(new BorderLayout());
        game1PanelL.add(game1OptionL, BorderLayout.CENTER);
        game1PanelR.setPreferredSize(new Dimension(625, 155));
        game1PanelR.setLayout(new BorderLayout());
        game1PanelR.add(game1OptionR, BorderLayout.CENTER);
        game1Panel.add(game1PanelR, BorderLayout.EAST);
        game1Panel.add(game1PanelL, BorderLayout.WEST);
        game1Panel.add(game1Title, BorderLayout.NORTH);
        game1Panel.add(game1Question, BorderLayout.SOUTH);
        game1Question.setFont (questionFont);
        game1OptionR.setFont (optionFont);
        game1OptionL.setFont (optionFont);
       /*
            DITO MO LAGAY COMPONENTS NG GAME 1       
        */
        
    //Game2 Panel
        game2Panel.setPreferredSize(new Dimension(625, 310));
        game2Panel.setLayout(new BorderLayout());
        game2Panel.add(game2Title, BorderLayout.CENTER);
        game2Panel.add(game2Pattern, BorderLayout.NORTH);
        game2Pattern.setFont (questionFont);
        game2Panel.add(game2UserInput, BorderLayout.SOUTH);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 2        
        */
        
    //Game3 Panel
        game3Panel.setPreferredSize(new Dimension(625, 310));
        game3Panel.setLayout(new BorderLayout());
        game3Panel.add(game3Title, BorderLayout.NORTH);
        game3Panel.add(game3Shape,BorderLayout.CENTER);
        game3Panel.add(game3Text, BorderLayout.SOUTH);
        game3Text.setFont (optionFont);
        /*
            DITO MO LAGAY COMPONENTS NG GAME 3        
        */
        
    //Game Panel
        gamePanel.setPreferredSize(new Dimension(1280, 720));
        gamePanel.setBackground(Color.gray);
        gamePanel.addKeyListener(this);
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
                    //System.out.println(split[0] + "  " + split[1] + "  " + split[2]);
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
        startTime = (int)System.currentTimeMillis()/1000;
        //int prevTime = startTime;
        //int currentTime;
        updateQuestionPanel();
        
        /*
        while(!isEnd){
            currentTime = (int)System.currentTimeMillis()/1000;
            //1 frame per sec
            if(currentTime == prevTime){
                
                    DITO MO LAGAY PAGPALIT NG TIMER SA PANEL        
                
                revalidate();
                repaint();
            }
            //To indicate that the games have been finished
            if((isG1End == true)&&(isG2End == true)&&(isG3End == true))
                isEnd = true;
        }
        */
    }
    
    private void resetGame(){
        g1Questionnaire.resetQuestionnaire();
        g2Questionnaire.resetQuestionnaire();
        g3Questionnaire.resetQuestionnaire();
        
        g1Answered = 0;
        g2Answered = 0;
        g3Answered = 0;
        
        g1ChoiceCounter = 0;
        g2ChoiceCounter = 0;
        g3ChoiceCounter = 0;
        
        isG1End = false;
        isG2End = false;
        isG3End = false;
        
    }
    
    private void processKeys(int gameNumber, int keyNumber){
        boolean correct = checkAnswer(gameNumber, keyNumber);

        if(correct){
            if(gameNumber == 1){
                if(!g1Questionnaire.nextQuestion()){
                    isG1End = true;
                    game1Question.setText("");
                    game1OptionR.setText("");
                    game1OptionL.setText("");
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
        }

        updateQuestionPanel();
    }
    
    //Gets the next question and displays it
    private void updateQuestionPanel(){
            //game 1
            gameWrongAns.setText("Wrong Answers: " + wrongAnsCount);
            if(isG1End == false){
            String[] temp1Array = g1Questionnaire.getCurChoices(g1ChoiceCounter);
            System.out.println(g1ChoiceCounter);
            System.out.println(Arrays.toString(temp1Array));
            game1Question.setText("<html>Question:  "+ g1Questionnaire.getCurQuestion() +"<br><br/>"+"</html>");
            game1OptionR.setText(temp1Array[1]);
            game1OptionL.setText(temp1Array[0]);
            game1Title.setText("GAME 1: " + g1Answered + "/10");
            } else if (isG1End == true){
                game1Title.setText("GAME 1 FINISHED");
                game1Question.setText("<html>"+ "GAME 1 FINISHED" +"<br><br/>"+"</html>");
                game1OptionR.setText("GAME 1 FINISHED");
                game1OptionL.setText("GAME 1 FINISHED");
            }
            //game 2
            if(isG2End == false){
            game2Pattern.setText("<html><br><br/>" + g2Questionnaire.getCurQuestion() + "</html>");
            game2Title.setText("GAME 2: " + g2Answered + "/10");
            } else if (isG2End == true){
                game2Pattern.setText("<html>"+ "GAME 2 FINISHED" +"<br><br/>"+"</html>");
                game2Title.setText("GAME 2 FINISHED");
            }
            //game 3
            if(isG3End == false){
            String []temp3Array = g3Questionnaire.getCurChoices(g3ChoiceCounter);
            game3Title.setText("GAME 3: " + g3Answered + "/10");
            game3Shape.setText(Arrays.toString(g3Questionnaire.getCurChoices(g3ChoiceCounter)));
            } else if (isG3End == true){
                game3Title.setText("GAME 3 FINISHED");
                game3Shape.setText("<html>"+ "GAME 3 FINISHED" +"<br><br/>"+"</html>");
                game3Text.setText("GAME 3 FINISHED");
            }
            
            if(isG1End == true&&isG2End == true&&isG3End == true){
                JFrame f = new JFrame();
                currentTime = (int)System.currentTimeMillis()/1000;
                int initialTime = currentTime - startTime;
                int minutes = initialTime/60;
                int seconds = initialTime%60;
                int mistakes = wrongAnsCount*2;
                finalScore = initialTime + mistakes;
                
                String score = "Your score: "+finalScore;
                String time = "Your time: "+String.valueOf(minutes) + " minutes and " + String.valueOf(seconds) + "seconds";
                JOptionPane.showMessageDialog(f,time+"\n"+score,"GAME ENDED!",JOptionPane.WARNING_MESSAGE);     
            }
    }
     
    private boolean checkAnswer(int i, int a){
        boolean correct = false;
        if(i == 1){
            if(a == g1Questionnaire.getCurCorrectChoiceIndex())
                correct = true;    
            if(g1Answered < 9&&correct == true){
                g1Answered++;
                g1ChoiceCounter++;
                }else if (g1Answered == 9){
                isG1End = true;
                }else if (correct == false){
                    wrongAnsCount++;
                }
        }else if(i == 2){
            if(((a == 1)&&("W".equalsIgnoreCase(g2Questionnaire.getCurCorrectAns())))
           ||((a == 2) && ("A".equalsIgnoreCase(g2Questionnaire.getCurCorrectAns())))
           ||((a == 3) && ("S".equalsIgnoreCase(g2Questionnaire.getCurCorrectAns())))
           ||((a == 4) && ("D".equalsIgnoreCase(g2Questionnaire.getCurCorrectAns())))){
                correct = true;
                if(g2Answered < 9&&correct == true){
                g2Answered++;
                }else if (g2Answered == 9){
                isG2End = true;
                }
                }else if (correct == false){
                wrongAnsCount++;
                }
            
        }else if(i == 3){
            if(((a == 1)&&("true".equals(g3Questionnaire.getCurCorrectAns())))
           ||((a == 2) && ("false".equals(g3Questionnaire.getCurCorrectAns())))){
                correct = true;
                if(g3Answered < 9&&correct == true){
                g3Answered++;
                g3ChoiceCounter++;
                }else if (g3Answered == 9){
                isG3End = true;
                }
            }else if (correct == false){
                wrongAnsCount++;
                }
        }
        return correct;
    }
    
    @Override
    public void actionPerformed(ActionEvent a) {
        JButton clicked = (JButton)a.getSource();
        remove(rightPanel);

        if(clicked == toGame){
            titlePanel.setPreferredSize(new Dimension(0, 0));
            gameInterface.add(toMainMenu, BorderLayout.EAST);
            add(gamePanel);
            startGame();
        }else{
            //replaces rightPanel components to clicked button while titlePanel is the same
            remove(gamePanel);
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
            else if(clicked == toMainMenu){
                titlePanel.setPreferredSize(new Dimension(590, 300));
                rightPanel = mainMenuPanel;
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
            gameNumber = 3;
        }
        if(key == KeyEvent.VK_DOWN){
            isKeyCorrect = true;
            keyNumber = 2;
            gameNumber = 3;
        }
        if(key == KeyEvent.VK_W){
            isKeyCorrect = true;
            keyNumber = 1;
            gameNumber = 2;
        }
        if(key == KeyEvent.VK_A){
            isKeyCorrect = true;
            keyNumber = 2;
            gameNumber = 2;
        }
        if(key == KeyEvent.VK_S){
            isKeyCorrect = true;
            keyNumber = 3;
            gameNumber = 2;
        }
        if(key == KeyEvent.VK_D){
            isKeyCorrect = true;
            keyNumber = 4;
            gameNumber = 2;
        }
        
        if(key == KeyEvent.VK_U){
            updateQuestionPanel();
        }
            
        if(isKeyCorrect){
            if(((gameNumber == 1)&&(isG1End == false))||
               ((gameNumber == 2)&&(isG2End == false))||
               ((gameNumber == 3)&&(isG3End == false))){
                processKeys(gameNumber, keyNumber);
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