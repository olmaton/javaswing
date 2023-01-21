package com.olmaton.javaswing.views.textcontrols;

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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author olmaton
 */
public class OlmTextDecimal extends JTextField implements KeyListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 30);
    private final Color placeholderColor = Color.BLACK;
    private String placeholder = "#0.00";
    private boolean textValid = true;
    private String pattern = "#0.00";
    private DecimalFormat numberFormat;
    private Locale customLocale = new Locale("en", "US");
    private boolean autoSelectOnFocus = true;
    private boolean nullValid = true;
    private int minValue = -999999999;
    private int maxValue = 999999999;

    private String alertTextWhenIsRequiredError = "%s is required.";
    private String alertTextWhenIsRequiredMinValueError = "%s is required with min value %s.";
    private String alertTextWhenIsRequiredMaxValueError = "%s is required with max value %s.";

    public OlmTextDecimal() {
        super();
        numberFormat = (DecimalFormat) NumberFormat.getNumberInstance(customLocale);
        numberFormat.applyLocalizedPattern(pattern);
        setName("OlmTextDecimal");
        setSize(dimension);
        setText("");
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addKeyListener(OlmTextDecimal.this);
        addFocusListener(OlmTextDecimal.this);
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

    public void setNumberValue(Double value) {
        if (value == null) {
            if (nullValid) {
                setText("");
            } else {
                setText(numberFormat.format(0.0));
            }
        } else {
            setText(numberFormat.format(value));
        }
    }

    public Double getNumberValue() {
        if (getText().trim().isEmpty()) {
            if (nullValid) {
                return null;
            }
            return 0.0;
        }

        return Double.valueOf(getText().trim());
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

    public String getErrors() {
        setForeground(OlmColors.getTextoGeneral());
        setBorder(new LineBorder(OlmColors.getBordeTexto()));
        Double value = getNumberValue();
        if (!nullValid && value == null) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            requestFocus();
            return String.format(alertTextWhenIsRequiredError, getName());
        }

        if (value != null && value < minValue) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return String.format(alertTextWhenIsRequiredMinValueError, getName(), minValue);
        }

        if (value != null && value > maxValue) {
            setForeground(OlmColors.getAlert3Dark(230));
            setBorder(new LineBorder(OlmColors.getAlert3Dark(230)));
            return String.format(alertTextWhenIsRequiredMaxValueError, getName(), minValue);
        }

        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(placeholderColor.getRed(), placeholderColor.getGreen(), placeholderColor.getBlue(), 90));
        g.drawString((textValid) ? placeholder : "", getMargin().left, (getSize().height) / 2 + getFont().getSize() / 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.') {
            e.consume();
        } else if (e.getKeyChar() == '.' && getText().contains(".")) {
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
        setNumberValue(getNumberValue());
        getErrors();
    }

    public boolean isAutoSelectOnFocus() {
        return autoSelectOnFocus;
    }

    public void setAutoSelectOnFocus(boolean autoSelectOnFocus) {
        this.autoSelectOnFocus = autoSelectOnFocus;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        numberFormat = (DecimalFormat) NumberFormat.getNumberInstance(customLocale);
        numberFormat.applyLocalizedPattern(pattern);
        this.pattern = pattern;
        placeholder = pattern;
    }

    public Locale getCustomLocale() {
        return customLocale;
    }

    public void setCustomLocale(Locale customLocale) {
        numberFormat = (DecimalFormat) NumberFormat.getNumberInstance(customLocale);
        numberFormat.applyLocalizedPattern(pattern);
        this.customLocale = customLocale;
    }

    public boolean isNullValid() {
        return nullValid;
    }

    public void setNullValid(boolean nullValid) {
        this.nullValid = nullValid;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public DecimalFormat getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(DecimalFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public String getAlertTextWhenIsRequiredError() {
        return alertTextWhenIsRequiredError;
    }

    public void setAlertTextWhenIsRequiredError(String alertTextWhenIsRequiredError) {
        this.alertTextWhenIsRequiredError = alertTextWhenIsRequiredError;
    }

    public String getAlertTextWhenIsRequiredMinValueError() {
        return alertTextWhenIsRequiredMinValueError;
    }

    public void setAlertTextWhenIsRequiredMinValueError(String alertTextWhenIsRequiredMinValueError) {
        this.alertTextWhenIsRequiredMinValueError = alertTextWhenIsRequiredMinValueError;
    }

    public String getAlertTextWhenIsRequiredMaxValueError() {
        return alertTextWhenIsRequiredMaxValueError;
    }

    public void setAlertTextWhenIsRequiredMaxValueError(String alertTextWhenIsRequiredMaxValueError) {
        this.alertTextWhenIsRequiredMaxValueError = alertTextWhenIsRequiredMaxValueError;
    }

}
