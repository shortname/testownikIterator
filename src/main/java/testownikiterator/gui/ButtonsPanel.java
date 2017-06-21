package testownikiterator.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {

    private final JButton previous, show, next;

    public ButtonsPanel(ActionListener previousListener, ActionListener showListener, ActionListener nextListener) {
        super(new GridLayout(1, 3));
        previous = createButton("Poprzednie", previousListener);
        show = createButton("Odpowiedzi", showListener);
        next = createButton("Następne", nextListener);
    }

    private JButton createButton(String name, ActionListener actionListener) {
        JButton button = new JButton(name);
        button.addActionListener(actionListener);
        add(button);
        return button;
    }

    public JButton getPrevious() {
        return previous;
    }

    public JButton getShow() {
        return show;
    }

    public JButton getNext() {
        return next;
    }

    public void enableNextButton(boolean enabled) {
        next.setEnabled(enabled);
    }

    public void enablePreviousButton(boolean enabled) {
        previous.setEnabled(enabled);
    }
}
