package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfProperFractionsTest {
    @Test
    public void Smaller_Numbers() {
        System.out.println();
        assertEquals(0, NumberOfProperFractions.properFractions(1));
        System.out.println();
        assertEquals(1, NumberOfProperFractions.properFractions(2));
        System.out.println();
        assertEquals(4, NumberOfProperFractions.properFractions(5));
        System.out.println();
        assertEquals(10, NumberOfProperFractions.properFractions(11));
        System.out.println();
        assertEquals(8, NumberOfProperFractions.properFractions(15));
        System.out.println();
        assertEquals(20, NumberOfProperFractions.properFractions(25));
    }
}