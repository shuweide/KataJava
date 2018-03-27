package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinalNameConvertTest {

    @Test
    public void convert() {
        assertEquals("THIEF_BOOK_A2", FinalNameConvert.convert("ThiefBookA2"));
    }
}