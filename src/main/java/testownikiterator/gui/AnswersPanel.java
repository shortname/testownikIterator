package testownikiterator.gui;

import testownikiterator.data.Answer;
import testownikiterator.data.Question;

import javax.swing.*;
import java.awt.*;

public class AnswersPanel extends JPanel {

    private static int counter;

    public AnswersPanel() {
        super(new CardLayout());
        counter = 0;
    }

    public void showAnswers(Question question, boolean check){
        GridLayout gridLayout = new GridLayout(question.answers().size(), 1);
        JPanel answersPanel = new JPanel(gridLayout);
        for (Answer answer : question.answers()) {
            if (answer.correct() && check) {
                JPanel jp = (JPanel) answer.show();
                jp.setBackground(Color.GREEN);
                answersPanel.add(jp);
            } else
                answersPanel.add(answer.show());
        }
        add(answersPanel, "" + counter++);
        CardLayout cl = (CardLayout) getLayout();
        cl.last(this);
    }
}
