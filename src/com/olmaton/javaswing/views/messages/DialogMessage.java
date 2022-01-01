package com.olmaton.javaswing.views.messages;

import com.olmaton.javaswing.services.MessageLevel;
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

    public void setMessage(Component component, MessageLevel level, String message, String origin) {
        Frame parent = (JFrame) SwingUtilities.getWindowAncestor(component);
        switch (level) {
            case EXITO: {
                //Mensaje OK
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle("Mensaje", message, origin, OlmColors.getAlert0(), OlmColors.getAlert0Dark());
                jdiMessage.setVisible(true);
                break;
            }

            case MENSAJE: {
                //Mensaje informativo
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle("Mensaje", message, origin, OlmColors.getAlert1(), OlmColors.getAlert1Dark());
                jdiMessage.setVisible(true);
                break;
            }

            case ADVERTENCIA: {
                //Mensaje de alerta
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle("Alerta", message, origin, OlmColors.getAlert2(), OlmColors.getAlert2Dark());
                jdiMessage.setVisible(true);
                break;
            }

            case ERROR: {
                //Mensaje de error
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle("Error", message, origin, OlmColors.getAlert3(), OlmColors.getAlert3Dark());
                jdiMessage.setVisible(true);
                break;
            }

            default: {
                JdiMessage jdiMessage = new JdiMessage(parent);
                jdiMessage.setLabelTitle("Mensaje", message, origin, OlmColors.getAlert1(), OlmColors.getAlert1Dark());
                jdiMessage.setVisible(true);
            }
        }
    }

    public boolean isAcepted(Component component, String mensaje) {
        Frame parent = (JFrame) SwingUtilities.getWindowAncestor(component);
        JdiMessageConfirm jdiMessageConfirmar = new JdiMessageConfirm(parent);
        jdiMessageConfirmar.setLabelTitle("Confirme", mensaje, new Color(93, 164, 236));
        jdiMessageConfirmar.setVisible(true);
        return jdiMessageConfirmar.isConfirmado();
    }

}
