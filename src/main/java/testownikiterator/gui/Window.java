package testownikiterator.gui;

import testownikiterator.data.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.stream.Collectors;

public class Window extends EmptyWindow {

    private int num;
    private final ButtonsPanel buttonsPanel;
    private final QuestionsCombo questionsCombo;
    private final AnswersPanel answersPanel;
    private final java.util.List<Question> questions;

    public Window(List<Question> questions) {
        num = 1;
        this.questions = questions;
        buttonsPanel = new ButtonsPanel(this::previousHandler, this::showHandler, this::nextHandler);
        questionsCombo = new QuestionsCombo(questions.stream().map(Question::content).collect(Collectors.toList()), this::select);
        answersPanel = new AnswersPanel();
        add(questionsCombo);
        add(answersPanel);
        add(buttonsPanel);
        showQuestion(num, false);
        setVisible(true);
    }

    private void showHandler(ActionEvent event) {
        showQuestion(num, true);
    }

    private void nextHandler(ActionEvent event) {
        questionsCombo.setSelectedIndex(++num);
        showQuestion(num, false);
    }

    private void previousHandler(ActionEvent event) {
        questionsCombo.setSelectedIndex(--num);
        showQuestion(num, false);
    }

    private void select(ItemEvent e) {
        num = questionsCombo.getSelectedIndex() + 1;
        showQuestion(num, false);
    }

    private void showQuestion(int i, boolean showAnswer) {
        answersPanel.showAnswers(questions.get(i - 1), showAnswer);
        updatePreviousButton(i);
        updateNextButton(i);
    }

    private void updateNextButton(int i) {
        buttonsPanel.enableNextButton(i != questions.size());
    }

    private void updatePreviousButton(int i) {
        buttonsPanel.enablePreviousButton(i != 1);
    }
}
