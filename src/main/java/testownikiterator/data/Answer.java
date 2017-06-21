package testownikiterator.data;

import javax.swing.*;

public class Answer {
    private Item content;
    private boolean correct;
    
    public Answer(Item content, boolean correct){
        this.content = content;
        this.correct = correct;
    }
    
    public boolean correct(){
        return correct;
    }
    
    public Item content(){
        return content;
    }
    
    public JComponent show(){
        return content.show();
    }
}
