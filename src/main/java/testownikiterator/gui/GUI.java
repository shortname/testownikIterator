package testownikiterator.gui;

import testownikiterator.data.Answer;
import testownikiterator.data.Item;
import testownikiterator.data.Question;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI extends JFrame{
    private GridLayout gl;
    private ArrayList<JButton> buttons;
    private JButton back, show, next;
    private JComboBox jclist;
    private JPanel allAll;
    private boolean showAns;
    private ActionListener al;
    private ItemListener il;
    private JLabel label;
    private ArrayList<Question> qs;
    private ArrayList<Object> ops;
    private int x = 800, y = 600, num;    
    
    public GUI(int numo){
        setSize(x, y);
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Testownik Iterator 2 by JD");
        qs = new ArrayList<>();
        showAns = false;
        this.num = numo;
        al = new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == back){
                    num--;
                    showAns = false;
                    jclist.setSelectedIndex(num-1);
                    show(num);
                }
                if(e.getSource() == next){
                    num++;
                    showAns = false;
                    jclist.setSelectedIndex(num-1);
                    show(num);
                }
                if(e.getSource() == show){
                    showAns = showAns ? false : true;
                    show(num);
                }
            }
            
        };
        il = new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                    num = jclist.getSelectedIndex()+1;
                    showAns = false;
                    show(num);
            }
            
        };
        
        ops = new ArrayList<>();
    }
    
    private Item itemize(String line) throws IOException{
        Item q;
        if(line.startsWith("[img]") && line.endsWith("[/img]")){
            line = line.replace("[img]", "");
            line = line.replace("[/img]", "");
            System.err.println(line);
            q = new Item(ImageIO.read(new File("baza\\" + line)));
        }else{
            q = new Item(line);
        }
        return q;
    }
    
    public void load(){
        jclist = new JComboBox();
        try{
            int i = 1;
            File[] list = new File("baza\\").listFiles();
            for(File file : list){
                if(!file.getName().endsWith("txt"))
                    continue;
                Scanner scanner = new Scanner(file, "Windows-1250");
                String correctness = scanner.nextLine();
                String line = scanner.nextLine();
                Item q;
                try{
                    q = itemize(line);
                }catch(IOException exc){
                    continue;
                }
                jclist.add(q.list());
                ArrayList<Answer> as = new ArrayList<>();
                while(scanner.hasNextLine()){
                    line = scanner.nextLine();
                    if(as.size()+1 == correctness.length())
                        break;
                    Item a;
                    try{
                        a = itemize(line);
                    }catch(IOException exc){
                        continue;
                    }
                    as.add(new Answer(a, (correctness.charAt(as.size()+1) == '1' ? true : false)));
                }
                qs.add(new Question(q, as));
                i++;
                scanner.close();
            }
        }catch(FileNotFoundException exc){
            System.err.println(exc);
        }
        jclist.addItemListener(il);
        add(jclist);
        allAll = new JPanel(new CardLayout());
        add(allAll);
        back = new JButton("Poprzednie");
        back.addActionListener(al);
        show = new JButton("Odpowiedź");
        show.addActionListener(al);
        next = new JButton("Następne");
        next.addActionListener(al);
        JPanel butts = new JPanel();
        butts.setLayout(new GridLayout(1, 3));
        butts.add(back);
        butts.add(show);
        butts.add(next);
        add(butts);
    }
    
    public void show(int i){
        System.err.println(qs.size());
        Question quest = qs.get(i-1);
        gl = new GridLayout(quest.answers().size(), 1);
        JPanel all = new JPanel();
        all.setLayout(gl);
        for(Answer ans : quest.answers()){
            if(ans.correct() && showAns){
                JPanel jp = (JPanel) ans.show();
                jp.setBackground(Color.GREEN);
                all.add(jp);
            }else   
                all.add(ans.show());
        }
        if(i == 1)
            back.setEnabled(false);
        else
            back.setEnabled(true);
        
        if(i == qs.size())
            next.setEnabled(false);
        else
            next.setEnabled(true);
        allAll.add(all, "Menu" + i);
        CardLayout cl = (CardLayout) allAll.getLayout();
        cl.last(allAll);
    }

}
