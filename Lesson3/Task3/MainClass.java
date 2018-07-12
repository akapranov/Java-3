package Lesson3.Task3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainClass {
    static RandomAccessFile raf;

    public static void main(String[] args) throws IOException {
        boolean x = true;

        while (x) {
            System.out.println("\nВведите номер интересующей вас страницы или 'exit': ");
            String page = new Scanner(System.in).nextLine();

            if (page.equals("exit")) {
                x = false;
            }else{
                try {
                    Timer.start();
                    raf = new RandomAccessFile("src/Lesson3/text.txt", "r");
                    int pageNumber = Integer.parseInt(page);
                    raf.seek((pageNumber - 1) * 1800);
                    System.out.println(makePage());
                    Timer.stopAndPrint();
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка вода. Введите число или 'exit'!");
                }
            }
        }
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
