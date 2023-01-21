package com.olmaton.javaswing.views.textcontrols;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.olmaton.javaswing.views.utils.OlmColors;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author olmaton
 */
public class OlmTextPassword extends JPasswordField implements KeyListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 30);
    private String placeholder = "";
    private boolean textValid = true;
    private boolean autoSelectOnFocus = true;
    private int minTextLength = 0;
    private int maxTextLength = 999999999;

    Pattern patternPassword = Pattern.compile(".");
    private String alertTextWhenPatternError = "%s not containt password format valid.";
    private String alertTextWhenMinTextLengthError = "%s is required with min text length %s.";
    private String alertTextWhenMaxTextLengthError = "%s is required with max text length %s.";

    public OlmTextPassword() {
        super();
        setName("OlmTextPassword");
        setSize(dimension);
        setText("");
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addKeyListener(OlmTextPassword.this);
        addFocusListener(OlmTextPassword.this);
        setForeground(OlmColors.getTextoGeneral());
        setBorder(new LineBorder(OlmColors.getBordeTexto()));
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textValid = false;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textValid = (getPassword().length <= 0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    public String getErrors() {
        setForeground(OlmColors.getTextoGeneral());
        setBorder(new LineBorder(OlmColors.getBordeTexto()));

        Matcher mat = patternPassword.matcher(getText());
        if (!mat.find()) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return String.format(alertTextWhenPatternError, getName());
        }

        if (getPassword().length < minTextLength) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return String.format(alertTextWhenMinTextLengthError, getName(), minTextLength);
        }

        if (getPassword().length > maxTextLength) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return String.format(alertTextWhenMaxTextLengthError, getName(), minTextLength);
        }

        return null;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(230, 230, 230, 90));
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

    public Pattern getPatternPassword() {
        return patternPassword;
    }

    public void setPatternPassword(Pattern patternPassword) {
        this.patternPassword = patternPassword;
    }

    public String getAlertTextWhenPatternError() {
        return alertTextWhenPatternError;
    }

    public void setAlertTextWhenPatternError(String alertTextWhenPatternError) {
        this.alertTextWhenPatternError = alertTextWhenPatternError;
    }

    public String getAlertTextWhenMinTextLengthError() {
        return alertTextWhenMinTextLengthError;
    }

    public void setAlertTextWhenMinTextLengthError(String alertTextWhenMinTextLengthError) {
        this.alertTextWhenMinTextLengthError = alertTextWhenMinTextLengthError;
    }

    public String getAlertTextWhenMaxTextLengthError() {
        return alertTextWhenMaxTextLengthError;
    }

    public void setAlertTextWhenMaxTextLengthError(String alertTextWhenMaxTextLengthError) {
        this.alertTextWhenMaxTextLengthError = alertTextWhenMaxTextLengthError;
    }

}
