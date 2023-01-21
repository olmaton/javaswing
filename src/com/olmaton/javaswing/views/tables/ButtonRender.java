package com.olmaton.javaswing.views.tables;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ButtonRender extends JButton implements TableCellRenderer {

    public ButtonRender(ImageIcon imageIcon) {
        setIcon(imageIcon);
        setBorderPainted(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.WHITE);
        return this;
    }
}
