package com.olmaton.javaswing.views.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.FileSystems;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author olmaton
 */
public class JPanelBackgroundImage extends JPanel {

    private final Image img;

    public JPanelBackgroundImage(String path) {
//        ImageIcon imgIcon = new ImageIcon(FileSystems.getDefault().getPath(path).toAbsolutePath().toString());
        this.img = OlmImages.getImage(path);
        Dimension size = new Dimension(this.img.getWidth(null), this.img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
