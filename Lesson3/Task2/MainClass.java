package Lesson3.Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
    public static void main(String[] args) throws Exception{
        ArrayList<FileInputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("src/Lesson3/a.txt"));
        ali.add(new FileInputStream("src/Lesson3/b.txt"));
        ali.add(new FileInputStream("src/Lesson3/c.txt"));
        ali.add(new FileInputStream("src/Lesson3/d.txt"));
        ali.add(new FileInputStream("src/Lesson3/e.txt"));
        SequenceInputStream sin = new SequenceInputStream(Collections.enumeration(ali));
        int x;
        File f = new File("src/Lesson3/new.txt");
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream("src/Lesson3/new.txt");
        while((x = sin.read()) != -1){
            fos.write(x);
        }
        sin.close();
        fos.close();
    }
}
