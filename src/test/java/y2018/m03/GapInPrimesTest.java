package y2018.m03;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GapInPrimesTest {

    @Test
    public void gap() {
        System.out.println("Fixed Tests");
        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2, 100, 110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4, 100, 110)));
        assertEquals(null, GapInPrimes.gap(6, 100, 110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8, 300, 400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10, 300, 400)));

        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gapBest(2, 100, 110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gapBest(4, 100, 110)));
        assertEquals(null, GapInPrimes.gapBest(6, 100, 110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gapBest(8, 300, 400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gapBest(10, 300, 400)));
    }

    @Test
    public void isPrime() {
        assertTrue(GapInPrimes.isPrime(3));
    }
}