package psych1.pkg1;

import java.util.ArrayList;

public class Questionnaire{

    String[] questions;
    String[] correctAns;
    String[] wrongAns;
    ArrayList<Integer> usedQuestions = new ArrayList<Integer>();

    public Questionnaire(String[] questions, String[] correctAns, String[] wrongAns){
        this.questions = questions;
        this.correctAns = correctAns;
        this.wrongAns = wrongAns;
    }

    private String getQuestion(){
        int random = (int)(Math.random() * questions.length);
        String question;
        if(usedQuestions.contains(random)){
            question = getQuestion();
        }
        else{
            question = questions[random];
        }
        usedQuestions.add(random);
        return question;
    }

    private String[] getChoices(int i){
        int random = (int)(Math.random() * 2);
        String[] choices;
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
