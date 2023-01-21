package com.olmaton.javaswing.views.utils;

import java.awt.Dimension;
import java.awt.Image;
import java.nio.file.FileSystems;
import javax.swing.ImageIcon;

public class OlmImages {

    public static Image getImage(String path) {
        ImageIcon imgIcon = new ImageIcon(FileSystems.getDefault().getPath(path).toAbsolutePath().toString());
        return imgIcon.getImage();
    }

    public static ImageIcon getImageIcon(String path) {
        String url = FileSystems.getDefault().getPath(path).toAbsolutePath().toString();
        ImageIcon imgIcon = new ImageIcon(url);
        return imgIcon;
    }

    public static ImageIcon getImageIconScale(Dimension d, String path) {
        ImageIcon icon = OlmImages.getImageIcon(path);
        Double anchoContenedor = d.getWidth(), altoContenedor = d.getHeight();
        if (icon.getIconWidth() > icon.getIconHeight()) {
            Double h = (icon.getIconHeight() * anchoContenedor / icon.getIconWidth());
            if (h <= altoContenedor) {
                return new ImageIcon(icon.getImage().getScaledInstance(anchoContenedor.intValue(), h.intValue(), Image.SCALE_AREA_AVERAGING));
            } else {
                Double w = (icon.getIconWidth() * altoContenedor / icon.getIconHeight());
                return new ImageIcon(icon.getImage().getScaledInstance(w.intValue(), altoContenedor.intValue(), Image.SCALE_AREA_AVERAGING));
            }
        } else {
            Double w = (icon.getIconWidth() * altoContenedor / icon.getIconHeight());
            if (w <= anchoContenedor) {
                return new ImageIcon(icon.getImage().getScaledInstance(w.intValue(), altoContenedor.intValue(), Image.SCALE_AREA_AVERAGING));
            } else {
                Double h = (icon.getIconHeight() * anchoContenedor / icon.getIconWidth());
                return new ImageIcon(icon.getImage().getScaledInstance(anchoContenedor.intValue(), h.intValue(), Image.SCALE_AREA_AVERAGING));
            }
        }
    }
}
