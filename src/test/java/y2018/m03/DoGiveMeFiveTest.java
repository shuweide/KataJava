package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoGiveMeFiveTest {

    @Test
    public void dontGiveMeFive() {
        assertEquals(8, DoGiveMeFive.dontGiveMeFive(1, 9));
        assertEquals(8, DoGiveMeFive.dontGiveMeFiveBest(1, 9));
        assertEquals(12, DoGiveMeFive.dontGiveMeFive(4, 17));
        assertEquals(12, DoGiveMeFive.dontGiveMeFiveBest(4, 17));
    }
}