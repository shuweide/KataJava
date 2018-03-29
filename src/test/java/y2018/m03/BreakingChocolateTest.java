package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreakingChocolateTest {
    @Test
    public void myTests() {
        assertEquals(24, BreakingChocolate.breakChocolate(5, 5));
        assertEquals(24, BreakingChocolate.breakChocolateBest(5, 5));
        assertEquals(0, BreakingChocolate.breakChocolate(1, 1));
        assertEquals(0, BreakingChocolate.breakChocolateBest(1, 1));
    }
}