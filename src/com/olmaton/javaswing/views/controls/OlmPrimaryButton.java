package com.olmaton.javaswing.views.controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JButton;

public class OlmPrimaryButton extends JButton implements MouseListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 34);
    private Color olmBackgroundColor = new Color(65, 126, 187);
    private Color olmBackgroundEnteredColor = new Color(93, 164, 236);
    private Color olmForegroundColor = Color.WHITE;
    private Color olmForegroundEnteredColor = Color.WHITE;

    public OlmPrimaryButton() {
        super();
        super.setBackground(olmBackgroundColor);
        setForeground(olmForegroundColor);        
        setFocusPainted(false);
        setBorderPainted(false);
        setText("Olm Primary Button");
        setSize(dimension);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addMouseListener(OlmPrimaryButton.this);
        addFocusListener(OlmPrimaryButton.this);
    }

    public Color getOlmBackgroundColor() {
        return olmBackgroundColor;
    }

    public void setOlmBackgroundColor(Color olmBackgroundColor) {
        this.olmBackgroundColor = olmBackgroundColor;
    }

    public Color getOlmBackgroundEnteredColor() {
        return olmBackgroundEnteredColor;
    }

    public void setOlmBackgroundEnteredColor(Color olmBackgroundEnteredColor) {
        this.olmBackgroundEnteredColor = olmBackgroundEnteredColor;
    }

    public Color getOlmForegroundColor() {
        return olmForegroundColor;
    }

    public void setOlmForegroundColor(Color olmForegroundColor) {
        this.olmForegroundColor = olmForegroundColor;
    }

    public Color getOlmForegroundEnteredColor() {
        return olmForegroundEnteredColor;
    }

    public void setOlmForegroundEnteredColor(Color olmForegroundEnteredColor) {
        this.olmForegroundEnteredColor = olmForegroundEnteredColor;
    }

    @Override
    public void setBackground(Color background) {
        super.setBackground(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(olmBackgroundEnteredColor);
        setForeground(olmForegroundEnteredColor);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(olmBackgroundColor);
        setForeground(olmForegroundColor);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void focusGained(FocusEvent e) {
        Font font = getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        setFont(font.deriveFont(attributes));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Font font = getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, null);
        setFont(font.deriveFont(attributes));
    }
}
