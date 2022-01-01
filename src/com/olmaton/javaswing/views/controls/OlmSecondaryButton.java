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

/**
 *
 * @author olmaton
 */
public class OlmSecondaryButton extends JButton implements MouseListener, FocusListener {

    private final Dimension dimension = new Dimension(150, 34);
    private final Color olmBackgroundColor = new Color(230, 230, 230);
    private final Color olmBackgroundEnteredColor = new Color(210, 210, 210);
    private final Color olmForegroundColor = Color.DARK_GRAY;
    private final Color olmForegroundEnteredColor = Color.BLACK;

    public OlmSecondaryButton() {
        super();
        setForeground(olmForegroundColor);
        setBackground(olmBackgroundColor);
        setFocusPainted(false);
        setBorderPainted(false);
        setSize(dimension);
        setText("Olm Secondary Button");
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setVisible(true);
        addMouseListener(OlmSecondaryButton.this);
        addFocusListener(OlmSecondaryButton.this);
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
