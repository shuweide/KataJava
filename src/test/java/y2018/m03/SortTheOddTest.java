package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTheOddTest {
    @Test
    public void exampleTest1() {
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, SortTheOdd.sortArray(new int[]{5, 3, 2, 8, 1, 4}));
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, SortTheOdd.sortArrayBest(new int[]{5, 3, 2, 8, 1, 4}));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{1, 3, 5, 8, 0}, SortTheOdd.sortArray(new int[]{5, 3, 1, 8, 0}));
        assertArrayEquals(new int[]{1, 3, 5, 8, 0}, SortTheOdd.sortArrayBest(new int[]{5, 3, 1, 8, 0}));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, SortTheOdd.sortArray(new int[]{}));
        assertArrayEquals(new int[]{}, SortTheOdd.sortArrayBest(new int[]{}));
    }
}