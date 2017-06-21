package testownikiterator.core;

import testownikiterator.data.Answer;
import testownikiterator.data.Item;
import testownikiterator.data.Question;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {

    public static final Path BAZA = Paths.get(System.getProperty("user.dir")).resolve("baza");

    public static List<Question> loadQuestions(){
        List<Question> questions = new ArrayList<>();
        try{
            File[] list = BAZA.toFile().listFiles();
            for(File file : list){
                if(!file.getName().endsWith("txt"))
                    continue;
                Scanner scanner = new Scanner(file, "Windows-1250");
                String correctness = scanner.nextLine();
                String line = scanner.nextLine();
                Item q;
                try{
                    q = Item.fromLine(line);
                }catch(IOException exc){
                    continue;
                }
                ArrayList<Answer> as = new ArrayList<>();
                while(scanner.hasNextLine()){
                    line = scanner.nextLine();
                    if(as.size()+1 == correctness.length())
                        break;
                    Item a;
                    try{
                        a = Item.fromLine(line);
                    }catch(IOException exc){
                        continue;
                    }
                    as.add(new Answer(a, (correctness.charAt(as.size()+1) == '1' ? true : false)));
                }
                questions.add(new Question(q, as));
                scanner.close();
            }
        }catch(FileNotFoundException exc){
            System.err.println(exc);
        }
        return questions;
    }

    public static BufferedImage loadImage(String line) throws IOException {
        return ImageIO.read(BAZA.resolve(line).toFile());
    }

}
