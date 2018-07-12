package Lesson3.Task3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainClass {
    static Scanner scr;
    static RandomAccessFile raf;

    public static void main(String[] args) throws IOException {
        System.out.print("Введите номер интересующей вас страницы: ");
        scr = new Scanner(System.in);
        raf = new RandomAccessFile("src/Lesson3/text.txt", "r");

        int pageNumber = Integer.parseInt(scr.nextLine());
        raf.seek((pageNumber - 1) * 1800);
        System.out.println(makePage());
    }

    public static String makePage() throws IOException {
        int count=0;
        String res = "";
        int b = raf.read();
        while(b != -1 && count < 1800){
            res = res + (char)b;
            b = raf.read();
            count++;
        }
        raf.close();
        return res;
    }
}
