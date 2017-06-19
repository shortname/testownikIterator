
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import sun.java2d.pipe.BufferedBufImgOps;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JWMD
 */
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
