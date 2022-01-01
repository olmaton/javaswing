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
public class OlmTextGeneral extends JTextField implements KeyListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 30);
//    private final Color placeholderColor = Color.BLACK;
    private String placeholder = "Olm General Text";
    private boolean textValid = true;
    private boolean autoSelectOnFocus = true;
//    private boolean validateEmpty = false;
    private int minTextLength = 0;
    private int maxTextLength = 999999999;

    public OlmTextGeneral() {
        super();
        setSize(dimension);
        setText("");
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addKeyListener(OlmTextGeneral.this);
        addFocusListener(OlmTextGeneral.this);
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

//    public boolean evaluarValidez() {
//        
//    }
    public boolean isAutoSelectOnFocus() {
        return autoSelectOnFocus;
    }

    public void setAutoSelectOnFocus(boolean autoSelectOnFocus) {
        this.autoSelectOnFocus = autoSelectOnFocus;
    }

    public String getErrors() {
        setForeground(OlmColors.getTextoGeneral());
        setBorder(new LineBorder(OlmColors.getBordeTexto()));

        if (getText().trim().length() < minTextLength) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return "Ingrese por lo menos " + minTextLength + " caracteres en el campo: " + getName() + ".";
        }

        if (getText().trim().length() > maxTextLength) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return "Ingrese como máximo " + maxTextLength + " caracteres en el campo: " + getName() + ".";
        }
        
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 90));
        g.drawString((textValid) ? placeholder : "", getMargin().left, (getSize().height) / 2 + getFont().getSize() / 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        getErrors();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (autoSelectOnFocus) {
            this.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        getErrors();
    }

//    public boolean isValidateEmpty() {
//        return validateEmpty;
//    }
//
//    public void setValidateEmpty(boolean validateEmpty) {
//        this.validateEmpty = validateEmpty;
//    }
    public int getMinTextLength() {
        return minTextLength;
    }

    public void setMinTextLength(int minTextLength) {
        this.minTextLength = minTextLength;
    }

    public int getMaxTextLength() {
        return maxTextLength;
    }

    public void setMaxTextLength(int maxTextLength) {
        this.maxTextLength = maxTextLength;
    }

}
