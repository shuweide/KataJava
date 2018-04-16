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

    @Test
    public void SampleTestsBest() {
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLooooooBest("z"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLooooooBest("tz"));
        assertEquals("Let's fight again!", AlphabetWarPriest.woLoLooooooBest("jbdt"));
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLooooooBest("jz"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLooooooBest("zt"));
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLooooooBest("sj"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLooooooBest("azt"));
        assertEquals("Right side wins!", AlphabetWarPriest.woLoLooooooBest("tzj"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLooooooBest("wololooooo"));
        assertEquals("Let's fight again!", AlphabetWarPriest.woLoLooooooBest("zdqmwpbs"));
        assertEquals("Left side wins!", AlphabetWarPriest.woLoLooooooBest("ztztztzs"));
    }
}