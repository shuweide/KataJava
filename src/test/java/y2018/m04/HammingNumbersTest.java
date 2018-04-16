package y2018.m04;

import org.junit.Assert;
import org.junit.Test;

public class HammingNumbersTest {

    @Test
    public void Test1Best() {
        Assert.assertEquals("hamming(1) should be 1", 1, HammingNumbers.hammingBest(1));
        Assert.assertEquals("hamming(2) should be 2", 2, HammingNumbers.hammingBest(2));
        Assert.assertEquals("hamming(3) should be 3", 3, HammingNumbers.hammingBest(3));
        Assert.assertEquals("hamming(4) should be 4", 4, HammingNumbers.hammingBest(4));
        Assert.assertEquals("hamming(5) should be 5", 5, HammingNumbers.hammingBest(5));
        Assert.assertEquals("hamming(6) should be 6", 6, HammingNumbers.hammingBest(6));
        Assert.assertEquals("hamming(7) should be 8", 8, HammingNumbers.hammingBest(7));
        Assert.assertEquals("hamming(8) should be 9", 9, HammingNumbers.hammingBest(8));
        Assert.assertEquals("hamming(9) should be 10", 10, HammingNumbers.hammingBest(9));
        Assert.assertEquals("hamming(10) should be 12", 12, HammingNumbers.hammingBest(10));
        Assert.assertEquals("hamming(11) should be 15", 15, HammingNumbers.hammingBest(11));
        Assert.assertEquals("hamming(12) should be 16", 16, HammingNumbers.hammingBest(12));
        Assert.assertEquals("hamming(13) should be 18", 18, HammingNumbers.hammingBest(13));
        Assert.assertEquals("hamming(14) should be 20", 20, HammingNumbers.hammingBest(14));
        Assert.assertEquals("hamming(15) should be 24", 24, HammingNumbers.hammingBest(15));
        Assert.assertEquals("hamming(16) should be 25", 25, HammingNumbers.hammingBest(16));
        Assert.assertEquals("hamming(17) should be 27", 27, HammingNumbers.hammingBest(17));
        Assert.assertEquals("hamming(18) should be 30", 30, HammingNumbers.hammingBest(18));
        Assert.assertEquals("hamming(19) should be 32", 32, HammingNumbers.hammingBest(19));
        Assert.assertEquals("hamming(5000) should be 50837316566580", 50837316566580L, HammingNumbers.hammingBest(5000));
    }

    @Test
    public void Test1() {
        Assert.assertEquals("hamming(1) should be 1", 1, HammingNumbers.hamming(1));
        Assert.assertEquals("hamming(2) should be 2", 2, HammingNumbers.hamming(2));
        Assert.assertEquals("hamming(3) should be 3", 3, HammingNumbers.hamming(3));
        Assert.assertEquals("hamming(4) should be 4", 4, HammingNumbers.hamming(4));
        Assert.assertEquals("hamming(5) should be 5", 5, HammingNumbers.hamming(5));
        Assert.assertEquals("hamming(6) should be 6", 6, HammingNumbers.hamming(6));
        Assert.assertEquals("hamming(7) should be 8", 8, HammingNumbers.hamming(7));
        Assert.assertEquals("hamming(8) should be 9", 9, HammingNumbers.hamming(8));
        Assert.assertEquals("hamming(9) should be 10", 10, HammingNumbers.hamming(9));
        Assert.assertEquals("hamming(10) should be 12", 12, HammingNumbers.hamming(10));
        Assert.assertEquals("hamming(11) should be 15", 15, HammingNumbers.hamming(11));
        Assert.assertEquals("hamming(12) should be 16", 16, HammingNumbers.hamming(12));
        Assert.assertEquals("hamming(13) should be 18", 18, HammingNumbers.hamming(13));
        Assert.assertEquals("hamming(14) should be 20", 20, HammingNumbers.hamming(14));
        Assert.assertEquals("hamming(15) should be 24", 24, HammingNumbers.hamming(15));
        Assert.assertEquals("hamming(16) should be 25", 25, HammingNumbers.hamming(16));
        Assert.assertEquals("hamming(17) should be 27", 27, HammingNumbers.hamming(17));
        Assert.assertEquals("hamming(18) should be 30", 30, HammingNumbers.hamming(18));
        Assert.assertEquals("hamming(19) should be 32", 32, HammingNumbers.hamming(19));
        Assert.assertEquals("hamming(5000) should be 50837316566580", 50837316566580L, HammingNumbers.hamming(5000));
    }
}