package testownikiterator.data;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImage extends JPanel{
    private BufferedImage bi;
    
    public JImage(BufferedImage bi){
        this.bi = bi;
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, null);
    }
}
