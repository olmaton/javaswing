package com.olmaton.javaswing.views;

import com.olmaton.javaswing.views.messages.DialogMessage;
import com.olmaton.javaswing.views.messages.MessageLevel;
import com.olmaton.javaswing.views.tables.OlmCustomJTable;
import com.olmaton.javaswing.views.tables.OlmDefaultTableCellRenderer;
import com.olmaton.javaswing.views.tables.OlmJTableHead;
import com.olmaton.javaswing.views.tables.OlmObject;
import com.olmaton.javaswing.views.utils.OlmImages;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author olmaton
 */
public class FrmExamples extends javax.swing.JFrame {

    private List<OlmObject> elements;

    public FrmExamples() {
        initComponents();
        this.setLocationRelativeTo(this);
        initials();
    }

    private void initials() {
        olmTextGeneral2.setMinTextLength(3);
        olmTextGeneral2.setMaxTextLength(10);
        olmTextDecimal1.setMinValue(1000);
        olmTextDecimal1.setNullValid(false);
        loadDataTable();
    }

    private void generateElements() {

        elements = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Formatter fmt = new Formatter();
            elements.add(new OlmObject(fmt.format("%05d", i).toString(), String.format("Element #%s", i))
            );
        }
    }

    private OlmCustomJTable getCustomJTable() {
        final OlmJTableHead head = new OlmJTableHead();

        head.addColumn("#", 60, SwingConstants.CENTER, Color.LIGHT_GRAY, Color.BLACK);
        head.addColumn("CODE", 300, SwingConstants.CENTER);
        head.addColumn("DESCRIPTION", 800);
        head.addColumn("-", 70);
        head.addColumn("-", 70);

        OlmDefaultTableCellRenderer render = new OlmDefaultTableCellRenderer(head);
        render.setAlternate(true);

        final OlmCustomJTable olmTable = new OlmCustomJTable(jTable1, head, render);

        final JButton btnEdit = olmTable.addButton(head.getSize() - 2, OlmImages.getImageIcon("src/com/olmaton/javaswing/images/edit_small_table.png"));
        btnEdit.addActionListener((ActionEvent e) -> {
            OlmObject object = elements.get(Integer.valueOf(btnEdit.getName()));
            DialogMessage.getInstance().setMessage(this, MessageLevel.INFO, object.getDescription(), btnEdit.getName());
        });

        final JButton btnDelete = olmTable.addButton(head.getSize() - 1, OlmImages.getImageIcon("src/com/olmaton/javaswing/images/delete_small_table.png"));
        btnDelete.addActionListener((ActionEvent e) -> {
            int idx = Integer.valueOf(btnDelete.getName());
            boolean delete = DialogMessage.getInstance().isAcepted(this, String.format("Delete %s?", elements.get(idx).getDescription()));
            if (delete) {
                elements.remove(idx);
                showDataIntable();
            }
        });
        return olmTable;
    }

    private void loadDataTable() {
        generateElements();
        showDataIntable();
    }

    private void showDataIntable() {
        OlmCustomJTable table = getCustomJTable();
        for (OlmObject element : elements) {
            table.addRow(
                    table.getDefaultTableModel().getRowCount(),
                    element.getCode(),
                    element.getDescription());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        olmPrimaryButton1 = new com.olmaton.javaswing.views.buttons.OlmPrimaryButton();
        olmCloseButton1 = new com.olmaton.javaswing.views.buttons.OlmCloseButton();
        jLabel1 = new javax.swing.JLabel();
        olmSecondaryButton2 = new com.olmaton.javaswing.views.buttons.OlmSecondaryButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        olmTextGeneral1 = new com.olmaton.javaswing.views.textcontrols.OlmTextGeneral();
        olmTextGeneral2 = new com.olmaton.javaswing.views.textcontrols.OlmTextGeneral();
        olmTextEmail1 = new com.olmaton.javaswing.views.textcontrols.OlmTextEmail();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        olmTextDecimal1 = new com.olmaton.javaswing.views.textcontrols.OlmTextDecimal();
        jLabel6 = new javax.swing.JLabel();
        olmTextInteger1 = new com.olmaton.javaswing.views.textcontrols.OlmTextInteger();
        jLabel7 = new javax.swing.JLabel();
        olmTextPassword1 = new com.olmaton.javaswing.views.textcontrols.OlmTextPassword();
        olmPrimaryButton2 = new com.olmaton.javaswing.views.buttons.OlmPrimaryButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        olmSecondaryButton1 = new com.olmaton.javaswing.views.buttons.OlmSecondaryButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buttons"));

        jLabel1.setText("Closse button");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(olmPrimaryButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(olmCloseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(olmSecondaryButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(olmPrimaryButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(olmSecondaryButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(olmCloseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Text controls"));

        jLabel2.setText("General text");

        jLabel3.setText("General text with min max length validation");

        olmTextGeneral1.setText("olmTextGeneral1");

        olmTextGeneral2.setText("olmTextGeneral2");

        olmTextEmail1.setText("info@olmaton.com");

        jLabel4.setText("Email");

        jLabel5.setText("Decimal value");

        olmTextDecimal1.setText("301.00");

        jLabel6.setText("Integer value");

        olmTextInteger1.setText("1000");

        jLabel7.setText("Password value");

        olmTextPassword1.setText("olmTextPassword1");

        olmPrimaryButton2.setText("Show errors");
        olmPrimaryButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                olmPrimaryButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(olmTextGeneral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(olmTextGeneral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(olmTextEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(olmTextDecimal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(olmTextInteger1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(olmTextPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(olmPrimaryButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(olmTextGeneral1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(olmTextGeneral2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(olmTextEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(olmTextDecimal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(olmTextInteger1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(olmTextPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(olmPrimaryButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tables"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        olmSecondaryButton1.setText("Reload");
        olmSecondaryButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                olmSecondaryButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(olmSecondaryButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(olmSecondaryButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void olmPrimaryButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olmPrimaryButton2ActionPerformed
        if (olmTextGeneral2.getErrors() != null) {
            DialogMessage.getInstance().setMessage(this, MessageLevel.WARNING, olmTextGeneral2.getErrors(), olmTextGeneral2.getName());
        }

        if (olmTextDecimal1.getErrors() != null) {
            DialogMessage.getInstance().setMessage(this, MessageLevel.WARNING, olmTextDecimal1.getErrors(), olmTextGeneral2.getName());
        }
    }//GEN-LAST:event_olmPrimaryButton2ActionPerformed

    private void olmSecondaryButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olmSecondaryButton1ActionPerformed
        loadDataTable();
    }//GEN-LAST:event_olmSecondaryButton1ActionPerformed

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmExamples().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.olmaton.javaswing.views.buttons.OlmCloseButton olmCloseButton1;
    private com.olmaton.javaswing.views.buttons.OlmPrimaryButton olmPrimaryButton1;
    private com.olmaton.javaswing.views.buttons.OlmPrimaryButton olmPrimaryButton2;
    private com.olmaton.javaswing.views.buttons.OlmSecondaryButton olmSecondaryButton1;
    private com.olmaton.javaswing.views.buttons.OlmSecondaryButton olmSecondaryButton2;
    private com.olmaton.javaswing.views.textcontrols.OlmTextDecimal olmTextDecimal1;
    private com.olmaton.javaswing.views.textcontrols.OlmTextEmail olmTextEmail1;
    private com.olmaton.javaswing.views.textcontrols.OlmTextGeneral olmTextGeneral1;
    private com.olmaton.javaswing.views.textcontrols.OlmTextGeneral olmTextGeneral2;
    private com.olmaton.javaswing.views.textcontrols.OlmTextInteger olmTextInteger1;
    private com.olmaton.javaswing.views.textcontrols.OlmTextPassword olmTextPassword1;
    // End of variables declaration//GEN-END:variables
}
