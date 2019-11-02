package psych1.pkg1;

import java.util.ArrayList;

public class Questionnaire{
    //how many will be asked
    private int numQuestions = 12;
    private String[] questions;
    private String[] correctAns;
    private String[] wrongAns;
    
    ArrayList<Integer> correctChoiceIndex = new ArrayList<Integer>();
    ArrayList<Integer> questionsSelected = new ArrayList<Integer>();
    ArrayList<String[]> questionsChoices = new ArrayList<String[]>();

    public Questionnaire(String[] questions, String[] correctAns, String[] wrongAns){
        this.questions = questions;
        this.correctAns = correctAns;
        this.wrongAns = wrongAns;
    }
    
//Framework Methods
    public String getQuestion(int i){
        return questions[i];
    }

    public String getCorrectAnswer(int i){
        return correctAns[i];
    }
    
    public String getWrongAnswer(int i){
        return wrongAns[i];
    }
    
//Methods to ease code linespace
    public int getCurQuestionIndex(){
        return questionsSelected.get(0);
    }
    
    public String[] getCurChoices(int i){
        return questionsChoices.get(i);
    }
    
    public String getCurQuestion(){
        return getQuestion(getCurQuestionIndex());
    }
    
    public String getCurCorrectAns(){
        return getCorrectAnswer(getCurQuestionIndex());
    }
    
    public String getCurWrongAnswer(){                                  //Not sure kung ito tinutukoy mo CJ na gawin kong "Answer" yung "Ans"
        return getWrongAnswer(getCurQuestionIndex());
    }
    
    public int getCurCorrectChoiceIndex(){
        return correctChoiceIndex.get(0);
    }
    
//Init and in-game Methods
    public void resetQuestionnaire(){
        questionsSelected.clear();
        for(int i = 0;i < numQuestions;i++){
            selectQuestion();
        }
    }

    public void selectChoices(int i){
        String[] choices;
        //Simplicity's sake; so that all answers are in one side for Game 1
        int random = (int)(Math.random() * 2);
        if(random == 0){
            choices = new String[]{correctAns[i], wrongAns[i]};
            correctChoiceIndex.add(1);
        }
        else{
            choices = new String[]{wrongAns[i], correctAns[i]};
            correctChoiceIndex.add(2);
        }
        questionsChoices.add(choices);
    }
    
    public int selectQuestion(){
        //randomizes what question to get
        int qNum = (int)(Math.random() * questions.length);
        
        //prevents adding a question twice/ runs algorithm again
        if(questionsSelected.contains(qNum)){
            qNum = selectQuestion();
        }else{
            //adds index number to questionSelected
            questionsSelected.add(qNum);
            //selects choices(for game 1)
            selectChoices(qNum);
        }
        return qNum;
    }
    
    public boolean nextQuestion(){
        if(!questionsSelected.isEmpty()){
            questionsSelected.remove(0);
            correctChoiceIndex.remove(0);
        }
        return !questionsSelected.isEmpty();
    }
}