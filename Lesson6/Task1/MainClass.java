package Lesson6.Task1;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {    }

    public static int[] allFromLastFour(int[] numbers){
        int count = 0;                                        // переменная для подсчета 4-ок.
        ArrayList<Integer> arrNum = new ArrayList<Integer>();       // временный массив
        int[] newNumber;                                      // возвращаемый массив

        for (int i = 0; i < numbers.length; i++) {
            arrNum.add(numbers[i]);
        }
        for (int i = 0; i < arrNum.size(); i++) {
            if(arrNum.get(i) == 4){
                for (int j = i; j >= 0; j--) {
                    arrNum.remove(j);
                    arrNum.trimToSize();
                    count++;
                }
                i --;
            }
        }
        if (count == 0){
            throw new RuntimeException("В массиве нет ни одной 4-ки!");
        }
        newNumber = new int[arrNum.size()];
        for (int i = 0; i < arrNum.size(); i++) {
            newNumber[i] = arrNum.get(i);
        }
        return newNumber;
    }
}
