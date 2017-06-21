package testownikiterator;

import testownikiterator.core.FileLoader;
import testownikiterator.gui.Window;

public class TestownikIterator {

    public static void main(String[] args) {
        new Window(FileLoader.loadQuestions());
    }

}
