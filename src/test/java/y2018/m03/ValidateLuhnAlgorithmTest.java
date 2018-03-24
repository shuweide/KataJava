package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidateLuhnAlgorithmTest {
    @Test
    public void test891() {
        assertEquals(false, ValidateLuhnAlgorithm.validate("891"));
        assertEquals(false, ValidateLuhnAlgorithm.validateBest("891"));
    }

    @Test
    public void test123() {
        assertEquals(false, ValidateLuhnAlgorithm.validate("123"));
        assertEquals(false, ValidateLuhnAlgorithm.validateBest("123"));
    }
}