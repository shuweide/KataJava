package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    @Test
    public void exampleTests() {
        assertEquals("", LongestCommonSubsequence.lcs("a", "b"));
        assertEquals("abc", LongestCommonSubsequence.lcs("abcdef", "abc"));
        assertEquals("acf", LongestCommonSubsequence.lcs("abcdef", "acf"));
        assertEquals("12356", LongestCommonSubsequence.lcs("132535365", "123456789"));
    }

    @Test
    public void exampleTestBest() {
        assertEquals("", LongestCommonSubsequence.lcsBest("a", "b"));
        assertEquals("abc", LongestCommonSubsequence.lcsBest("abcdef", "abc"));
        assertEquals("acf", LongestCommonSubsequence.lcsBest("abcdef", "acf"));
        assertEquals("12356", LongestCommonSubsequence.lcsBest("132535365", "123456789"));
    }
}