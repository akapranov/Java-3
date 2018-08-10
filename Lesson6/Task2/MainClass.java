package Lesson6.Task2;

public class MainClass {
    public static void main(String[] args) { }
    
    public static boolean isOnlyOneAndFour(int[] numbers){
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4){
                count++;
            }
        }
        return(count > 0)? true : false;
    }
}
