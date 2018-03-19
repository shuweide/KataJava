package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void dontGiveMeFive() {
        assertEquals(8, Kata.dontGiveMeFive(1,9));
        assertEquals(8, Kata.dontGiveMeFiveBest(1,9));
        assertEquals(12, Kata.dontGiveMeFive(4,17));
        assertEquals(12, Kata.dontGiveMeFiveBest(4,17));
    }
}