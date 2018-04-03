package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfProperFractionsTest {
    @Test
    public void smaller_Numbers() {
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

    @Test
    public void large_numbers() {
        System.out.println();
        assertEquals(143359227648L, NumberOfProperFractions.properFractions(215787637389L));
        assertEquals(143359227648L, NumberOfProperFractions.properFractions2(215787637389L));
    }
}