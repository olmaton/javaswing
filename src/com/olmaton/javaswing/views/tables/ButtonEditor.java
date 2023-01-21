package com.olmaton.javaswing.views.tables;

import java.awt.*;
import javax.swing.*;

public class ButtonEditor extends DefaultCellEditor {

    public JButton button;

    public ButtonEditor(JCheckBox checkBox, ImageIcon imageIcon, ImageIcon presedIcon) {
        super(checkBox);
        button = new JButton();
        button.setIcon(imageIcon);
        button.setPressedIcon(presedIcon);
        button.setRolloverIcon(presedIcon);
        button.setContentAreaFilled(true);
//        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        button.setBackground(new Color(
                table.getSelectionBackground().getRed(),
                table.getSelectionBackground().getGreen(),
                table.getSelectionBackground().getBlue(),
                255));
        button.setName(row + "");
        button.setFocusable(false);

        return button;
    }
}
