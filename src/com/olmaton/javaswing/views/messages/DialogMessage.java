package com.olmaton.javaswing.views.messages;

import java.awt.Frame;
import com.olmaton.javaswing.views.utils.OlmColors;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DialogMessage {

    private static DialogMessage instance = null;

    public static DialogMessage getInstance() {
        if (instance == null) {
            instance = new DialogMessage();
        }
        return instance;
    }

    private DialogMessage() {

    }

    public void setMessage(Component component, MessageLevel level, String message, String subMessage) {
        Frame parent = (JFrame) SwingUtilities.getWindowAncestor(component);
        if (component instanceof Frame) {
            parent = (Frame) component;
        }
        switch (level) {
            case MESSAGE: {
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle(level.toString(), message, subMessage, OlmColors.getAlert0(), OlmColors.getAlert0Dark());
                jdiMessage.setLocationRelativeTo(component);
                jdiMessage.setVisible(true);
                break;
            }

            case INFO: {
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle(level.toString(), message, subMessage, OlmColors.getAlert1(), OlmColors.getAlert1Dark());
                jdiMessage.setLocationRelativeTo(component);
                jdiMessage.setVisible(true);
                break;
            }

            case WARNING: {
                //Mensaje de alerta
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle(level.toString(), message, subMessage, OlmColors.getAlert2(), OlmColors.getAlert2Dark());
                jdiMessage.setLocationRelativeTo(component);
                jdiMessage.setVisible(true);
                break;
            }

            case ERROR: {
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle(level.toString(), message, subMessage, OlmColors.getAlert3(), OlmColors.getAlert3Dark());
                jdiMessage.setLocationRelativeTo(component);
                jdiMessage.setVisible(true);
                break;
            }

            default: {
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle(level.toString(), message, subMessage, OlmColors.getAlert1(), OlmColors.getAlert1Dark());
                jdiMessage.setLocationRelativeTo(component);
                jdiMessage.setVisible(true);
            }
        }
    }

    public boolean isAcepted(Component component, String mensaje) {
        Frame parent = (JFrame) SwingUtilities.getWindowAncestor(component);
        if (component instanceof Frame) {
            parent = (Frame) component;
        }
        JdiMessageConfirm jdiMessageConfirmar = new JdiMessageConfirm(parent);
        jdiMessageConfirmar.setLabelTitle("Confirm", mensaje, new Color(93, 164, 236));
        jdiMessageConfirmar.setLocationRelativeTo(component);
        jdiMessageConfirmar.setVisible(true);
        return jdiMessageConfirmar.isConfirmado();
    }

}
