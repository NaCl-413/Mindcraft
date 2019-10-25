package psych1.pkg1;

import java.util.ArrayList;

public class Questionnaire{
    //how many will be asked
    private int numQuestions = 1;
    
    private String[] questions;
    private String[] correctAns;
    private String[] wrongAns;
    
    ArrayList<Integer> correctAnsIndex = new ArrayList<Integer>();
    ArrayList<Integer> questionsSelected = new ArrayList<Integer>();

    public Questionnaire(String[] questions, String[] correctAns, String[] wrongAns){
        this.questions = questions;
        this.correctAns = correctAns;
        this.wrongAns = wrongAns;
    }
    
    public String getQuestion(int i){
        return questions[i];
    }
    
    public String getCorrectAnswer(int i){
        return correctAns[i];
    }
    
    public String getWrongAnswer(int i){
        return wrongAns[i];
    }
    
    public int getCorrectAnswerIndex(){
        return correctAnsIndex.get(0);
    }
    
    public int getCurrentQuestionIndex(){
        return questionsSelected.get(0);
    }
    
    public String[] getChoices(int i){
        String[] choices;
        //Simplicity's sake; so that all answers are in one side for Game 1
        int random = (int)(Math.random() * 2);
        if(random == 0){
            choices = new String[]{correctAns[i], wrongAns[i]};
            correctAnsIndex.add(1);
        }
        else{
            choices = new String[]{wrongAns[i], correctAns[i]};
            correctAnsIndex.add(2);
        }
        return choices;
    }
    
    public void resetQuestionnaire(){
        questionsSelected.clear();
        for(int i = 0;i < numQuestions;i++){
            selectQuestion();
        }
    }

    public String selectQuestion(){
        //randomizes what question to get
        int random = (int)(Math.random() * questions.length);
        String question;
        //prevents adding a question twice
        if(questionsSelected.contains(random)){
            question = selectQuestion();
        }
        else{
            question = questions[random];
        }
        //adds index number to questionSelected
        questionsSelected.add(random);
        return question;
    }
    
    public boolean nextQuestion(){
        if(!questionsSelected.isEmpty()){
            questionsSelected.remove(0);
            correctAnsIndex.remove(0);
        }
        return !questionsSelected.isEmpty();
    }
}
