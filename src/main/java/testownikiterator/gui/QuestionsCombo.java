package testownikiterator.gui;

import testownikiterator.data.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.util.List;

public class QuestionsCombo extends JComboBox {

    public QuestionsCombo(List<Item> items, ItemListener itemListener) {
        items.stream().map(Item::toLabel).forEach(this::addItem);
        addItemListener(itemListener);
        setRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                return (JLabel) value;
            }
        });
    }
}
