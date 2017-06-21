package testownikiterator.data;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Item {
    public String string;
    public BufferedImage image;
    
    public Item(String string){
        this.string = string;
        image = null;
    }
    
    public Item(BufferedImage image){
        this.image = image;
        string = null;
    }
    
    public JPanel show(){
        if(string != null){
            JPanel jp = new JPanel();
            jp.add(new JLabel(string));
            return jp;
        }else if(image != null)
            return new JImage(image);
        return null;
    }
    
    public JLabel list(){
        JLabel ret;
        if(string != null){
            ret = new JLabel(string);
            ret.setIcon(null);
            return ret;
        }else{
            ret = new JLabel("");
            ret.setIcon(new ImageIcon(image));
            return ret;
        }
    }
}
