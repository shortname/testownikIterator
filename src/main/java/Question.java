
import java.io.File;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JWMD
 */
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
