package psych1.pkg1;

import java.util.ArrayList;

public class Questionnaire{

    String[] questions;
    String[] correctAns;
    String[] wrongAns;

    //prevents asking questions twice
    ArrayList<Integer> usedQuestions = new ArrayList<Integer>();

    //for Game 1
    public Questionnaire(String[] questions, String[] correctAns, String[] wrongAns){
        this.questions = questions;
        this.correctAns = correctAns;
        this.wrongAns = wrongAns;
    }

    //for Game 2 and 3
    public Questionnaire(String[] questions, String[] correctAns){
        this.questions = questions;
        this.correctAns = correctAns;
    }

    private String getQuestion(){
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

    private String[] getChoices(int i){
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

    private String getAnswer(int i){
        return correctAns[i];
    }
}
