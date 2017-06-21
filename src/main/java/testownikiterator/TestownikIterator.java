package testownikiterator;

import testownikiterator.gui.GUI;

public class TestownikIterator {

    public static void main(String[] args) {
        int num = 1;
        GUI gui = new GUI(num);
        gui.load();
        gui.show(num);
    }

}
