package y2018.m04;

import org.junit.Test;

import static java.util.Arrays.deepEquals;
import static org.junit.Assert.assertTrue;

public class MakeSpiralTest {
    @Test
    public void test1() {
        assertTrue(deepEquals(
                MakeSpiral.spiralize(1),
                new int[][]{{1}}));
    }

    @Test
    public void test2() {
        assertTrue(deepEquals(
                MakeSpiral.spiralize(2),
                new int[][]{
                        {1, 1},
                        {0, 1}
                }));
    }

    @Test
    public void test3() {
        assertTrue(deepEquals(
                MakeSpiral.spiralize(3),
                new int[][]{
                        {1, 1, 1},
                        {0, 0, 1},
                        {1, 1, 1}
                }));
    }

    @Test
    public void test4() {
        assertTrue(deepEquals(
                MakeSpiral.spiralize(4),
                new int[][]{
                        {1, 1, 1, 1},
                        {0, 0, 0, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1}
                }));
    }

    @Test
    public void test5() {
        assertTrue(deepEquals(
                MakeSpiral.spiralize(5),
                new int[][]{
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}
                }));
    }

    @Test
    public void test8() {
        assertTrue(deepEquals(
                MakeSpiral.spiralize(8),
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1},
                }));
    }
}