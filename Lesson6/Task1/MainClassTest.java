package Lesson6.Task1;

import org.junit.*;


public class MainClassTest {
    private int[] numbers;
    private int[] newNumbers;

    @Test
    public void testAllFromLastFour(){
        numbers = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        newNumbers = new int[]{1,7};
        Assert.assertArrayEquals(newNumbers, MainClass.allFromLastFour(numbers));
    }

    @Test
    public void testAllFromLastFour2(){
        numbers = new int[]{4,4,4,4};
        newNumbers = new int[0];
        Assert.assertArrayEquals(newNumbers, MainClass.allFromLastFour(numbers));
    }

    @Test(expected = RuntimeException.class)
    public void testAllFromLastFour3(){
        numbers = new int[]{1, 2, 2, 3, 1, 7};
        newNumbers = new int[]{1, 2, 2, 3, 1, 7};
        Assert.assertArrayEquals(newNumbers, MainClass.allFromLastFour(numbers));
    }

    @Test(expected = RuntimeException.class)
    public void testAllFromLastFour4(){
        numbers = new int[0];
        newNumbers = new int[0];
        Assert.assertArrayEquals(newNumbers, MainClass.allFromLastFour(numbers));
    }

}