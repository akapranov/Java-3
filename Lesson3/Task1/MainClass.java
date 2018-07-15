package Lesson3.Task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("src/Lesson3/1.txt");
        byte[] bytes = new byte[in.available()];
        StringBuilder sb = new StringBuilder("");
        in.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            sb.append((char)bytes[i]);
        }
        //System.out.println(new String(bytes));
        printArrey(bytes);
        in.close();
    }


    public static void printArrey(byte[] o){
        ArrayList<Character> ch = new ArrayList<>();
        for (int i = 0; i < o.length; i++) {
            ch.add((char)o[i]);
        }
        System.out.println(ch);
    }
}
