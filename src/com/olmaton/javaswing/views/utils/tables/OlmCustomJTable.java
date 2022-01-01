package com.olmaton.javaswing.views.utils.tables;

import com.olmaton.javaswing.views.utils.OlmImages;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OlmCustomJTable {

    private static final int ROW_HEIGHT = 30;
    private static final int ROW_BUTTON_SIZE = 20;

    private final JTable table;
    private final DefaultTableModel dtm = new DefaultTableModel();

    public OlmCustomJTable(JTable table, OlmJTableHead modelo) {
        this.table = table;
        this.table.setRowHeight(ROW_HEIGHT);
        dtm.setColumnIdentifiers(modelo.getHead());
        this.table.setModel(dtm);
        this.init(modelo.getSizeWith());
    }

    public OlmCustomJTable(JTable table, OlmJTableHead modelo, OlmDefaultTableCellRenderer render) {
        this.table = table;
        this.table.setRowHeight(ROW_HEIGHT);
        dtm.setColumnIdentifiers(modelo.getHead());
        this.table.setModel(dtm);
        this.init(modelo.getSizeWith());
        this.table.setDefaultRenderer(Object.class, render);
    }

    private void init(int sizeWith[]) {
        for (int i = 0; i < sizeWith.length; i++) {
            if (sizeWith[i] != -1) {
                this.table.getColumnModel().getColumn(i).setPreferredWidth(sizeWith[i]);
                this.table.getColumnModel().getColumn(i).setMaxWidth(sizeWith[i]);
                this.table.getColumnModel().getColumn(i).setWidth(sizeWith[i]);
            }
        }
    }

    public void hideColumn(int i) {
        this.table.getColumnModel().getColumn(i).setPreferredWidth(0);
        this.table.getColumnModel().getColumn(i).setMaxWidth(0);
        this.table.getColumnModel().getColumn(i).setMinWidth(0);
        this.table.getColumnModel().getColumn(i).setWidth(0);
    }

    public JButton addButton(int idx, String icon) {
        return addButton(idx, icon, icon);
    }

    public JButton addButton(int idx, String icon, String presedIcon) {
        ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox(), OlmImages.getImageIcon(icon), OlmImages.getImageIcon(presedIcon));
        table.getColumnModel().getColumn(idx).setCellEditor(buttonEditor);
        table.getColumnModel().getColumn(idx).setCellRenderer(new ButtonRender(OlmImages.getImageIcon(icon)));
        return buttonEditor.button;
    }

    public JCheckBox addCheckBox(int column) {
        CheckBoxEditor buttonEditor = new CheckBoxEditor(new JCheckBox());

        table.getColumnModel().getColumn(column).setCellEditor(buttonEditor);
        table.getColumnModel().getColumn(column).setCellRenderer(new CheckBoxRender());
        return buttonEditor.checkBox;
    }

    public DefaultTableModel getDefaultTableModel() {
        return dtm;
    }

    public void addRow(Object... row) {
        dtm.addRow(row);
    }

}
