package psych1.pkg1;

import java.util.ArrayList;

public class Questionnaire{

    private String[] questions;
    private String[] correctAns;
    private String[] wrongAns;

    //prevents asking questions twice
    ArrayList<Integer> usedQuestions = new ArrayList<Integer>();

    public Questionnaire(String[] questions, String[] correctAns, String[] wrongAns){
        this.questions = questions;
        this.correctAns = correctAns;
        this.wrongAns = wrongAns;
    }

    public String getQuestion(){
        //randomizes what question to get
        int random = (int)(Math.random() * questions.length);
        String question;
        if(usedQuestions.contains(random)){
            question = getQuestion();
        }
        else{
            question = questions[random];
        }
        //adds index number to store numbers used
        usedQuestions.add(random);
        return question;
    }

    public String[] getChoices(int i){
        String[] choices;
        //Simplicity's sake; so that all answers are in one side for Game 1
        int random = (int)(Math.random() * 2);
        if(random == 0){
            choices = new String[]{correctAns[i], wrongAns[i]};
        }
        else{
            choices = new String[]{wrongAns[i], correctAns[i]};
        }
        return choices;
    }

    public String getAnswer(int i){
        return correctAns[i];
    }
    
    public void resetQuestionnaire(){
        usedQuestions.clear();
    }
}
