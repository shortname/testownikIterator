package testownikiterator.gui;

import testownikiterator.data.Item;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.List;

public class QuestionsCombo extends JComboBox {

    public QuestionsCombo(List<Item> items, ItemListener itemListener) {
        items.stream().map(Item::toLabel).forEach(this::addItem);
        addItemListener(itemListener);
        setRenderer((list, value, index, isSelected, cellHasFocus) -> (JLabel) value);
    }
}
