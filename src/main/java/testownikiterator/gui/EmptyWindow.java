package testownikiterator.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmptyWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 800, WINDOW_WIDTH = 600;
    public static final String TITLE = "Testownik Iterator 2 by JD";

    private ActionListener actionListener;

    public EmptyWindow() {
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(TITLE);
    }

}
