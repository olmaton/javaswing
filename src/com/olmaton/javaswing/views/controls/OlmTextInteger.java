package com.olmaton.javaswing.views.controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.olmaton.javaswing.views.utils.OlmColors;

/**
 *
 * @author olmaton
 */
public class OlmTextInteger extends JTextField implements KeyListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 30);
    private final Color placeholderColor = Color.BLACK;
    private String placeholder = "";
    private boolean textValid = true;
//    Pattern patDecimal = Pattern.compile("\\d*\\.?\\d+");
    private boolean autoSelectOnFocus = true;

    public OlmTextInteger() {
        super();
        setSize(dimension);
        setText("");
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addKeyListener(OlmTextInteger.this);
        addFocusListener(OlmTextInteger.this);
        setForeground(OlmColors.getTextoGeneral());
        setBorder(new LineBorder(OlmColors.getBordeTexto()));
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textValid = false;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textValid = (getText().length() <= 0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setInvalid() {
        setForeground(OlmColors.getAlert3Dark(230));
        setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
        selectAll();
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(placeholderColor.getRed(), placeholderColor.getGreen(), placeholderColor.getBlue(), 90));
        g.drawString((textValid) ? placeholder : "", getMargin().left, (getSize().height) / 2 + getFont().getSize() / 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (autoSelectOnFocus) {
            this.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    public boolean isAutoSelectOnFocus() {
        return autoSelectOnFocus;
    }

    public void setAutoSelectOnFocus(boolean autoSelectOnFocus) {
        this.autoSelectOnFocus = autoSelectOnFocus;
    }

}
