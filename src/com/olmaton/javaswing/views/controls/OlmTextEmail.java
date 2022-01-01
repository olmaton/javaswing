package com.olmaton.javaswing.views.controls;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.olmaton.javaswing.views.utils.OlmColors;
import java.awt.Color;

/**
 *
 * @author olmaton
 */
public class OlmTextEmail extends JTextField implements KeyListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 30);
    private String placeholder = "";
    private boolean textValid = true;
    Pattern patEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private boolean autoSelectOnFocus = true;

    public OlmTextEmail() {
        super();
        setSize(dimension);
        setText("");
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addKeyListener(OlmTextEmail.this);
        addFocusListener(OlmTextEmail.this);
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

    public String getErrors() {
        setForeground(OlmColors.getTextoGeneral());
        setBorder(new LineBorder(OlmColors.getBordeTexto()));
        Matcher mat = patEmail.matcher(getText());
        if (!mat.find()) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return "Ingrese dirección de correo electrónico válido en el campo " + getName() + ".";
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

    public boolean isAutoSelectOnFocus() {
        return autoSelectOnFocus;
    }

    public void setAutoSelectOnFocus(boolean autoSelectOnFocus) {
        this.autoSelectOnFocus = autoSelectOnFocus;
    }

}
