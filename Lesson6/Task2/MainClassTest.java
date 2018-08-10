package Lesson6.Task2;

import org.junit.*;

public class MainClassTest {
    private int[] numbers;

    @Test
    public void testIsOnlyOneAndFour(){
        numbers = new int[]{1, 2, 3, 4};
        Assert.assertTrue(MainClass.isOnlyOneAndFour(numbers));
    }

    @Test
    public void testIsOnlyOneAndFour2(){
        numbers = new int[]{0, 2, 3, 0};
        Assert.assertFalse(MainClass.isOnlyOneAndFour(numbers));
    }

    @Test
    public void testIsOnlyOneAndFour3(){
        numbers = new int[0];
        Assert.assertFalse(MainClass.isOnlyOneAndFour(numbers));
    }

    @Test
    public void testIsOnlyOneAndFour4(){
        numbers = new int[]{-1, 0, -4};
        Assert.assertFalse(MainClass.isOnlyOneAndFour(numbers));
    }
}