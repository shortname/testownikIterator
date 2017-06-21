package testownikiterator.data;

import java.util.ArrayList;


public class Question {
    private Item content;
    private ArrayList<Answer> answers;
    
    public Question(Item content, ArrayList<Answer> answers){
        this.content = content;
        this.answers = answers;
    }
    
    public Item content(){
        return content;
    }
    
    public ArrayList<Answer> answers(){
        return answers;
    }
    
}
