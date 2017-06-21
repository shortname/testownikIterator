package testownikiterator.data;

import testownikiterator.core.FileLoader;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Item {
    public String string;
    public BufferedImage image;
    
    private Item(String string){
        this.string = string;
        image = null;
    }
    
    private Item(BufferedImage image){
        this.image = image;
        string = null;
    }

    public static Item fromLine(String line) throws IOException {
        Item q;
        if(line.startsWith("[img]") && line.endsWith("[/img]")){
            line = line.replace("[img]", "");
            line = line.replace("[/img]", "");
            System.err.println(line);
            q = new Item(FileLoader.loadImage(line));
        }else{
            q = new Item(line);
        }
        return q;
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
    
    public JLabel toLabel(){
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
