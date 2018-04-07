package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagelSolverTest {
    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();

        assertEquals(
                bagel.getValue() == 4,
                java.lang.Boolean.TRUE
        );
    }
}