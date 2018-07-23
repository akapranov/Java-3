package Lesson6.Task2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainClassTestMass {
    @Parameterized.Parameters
    public static Collection<int[]> data(){
        return Arrays.asList(new int[][]{
                {1, 2, 3, 4},
                {0, 2, 3, 0},
                {},
                {-1, 0, -4}
        });
    }
    private int[] numbers;

    public MainClassTestMass(int[] numbers) {
        this.numbers = numbers;
    }

    @Test
    public void testIsOnlyOneAndFour(){
        Assert.assertTrue(MainClass.isOnlyOneAndFour(numbers));
    }
}