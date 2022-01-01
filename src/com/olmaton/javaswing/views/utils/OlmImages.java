package com.olmaton.javaswing.views.utils;

import java.awt.Image;
import java.nio.file.FileSystems;
import javax.swing.ImageIcon;

public class OlmImages {

    public static Image getImage(String path) {
        ImageIcon imgIcon = new ImageIcon(FileSystems.getDefault().getPath(path).toAbsolutePath().toString());
        return imgIcon.getImage();
    }

    public static ImageIcon getImageIcon(String path) {
        ImageIcon imgIcon = new ImageIcon(FileSystems.getDefault().getPath(path).toAbsolutePath().toString());
        return imgIcon;
    }
}
