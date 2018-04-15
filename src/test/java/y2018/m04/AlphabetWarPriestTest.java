package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlphabetWarPriestTest {
    @Test
    public void SampleTests() {
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLoooooo("z"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLoooooo("tz"));
        assertEquals("Let's fight again!", AlphabetWarPriest.woLoLoooooo("jbdt"));
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLoooooo("jz"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLoooooo("zt"));
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLoooooo("sj"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLoooooo("azt"));
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLoooooo("tzj"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLoooooo("wololooooo"));
        assertEquals("Let's fight again!", AlphabetWarPriest.woLoLoooooo("zdqmwpbs"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLoooooo("ztztztzs"));
    }
}