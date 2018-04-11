package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlphabetWarsTest {
    private String[]
            reinforces = {"g964xxxxxxxx",
            "myjinxin2015",
            "steffenvogel",
            "smile67xxxxx",
            "giacomosorbi",
            "freywarxxxxx",
            "bkaesxxxxxxx",
            "vadimbxxxxxx",
            "zozofouchtra",
            "colbydauphxx"},
            aristrikes = {"* *** ** ***",
                    " ** * * * **",
                    " * *** * ***",
                    " **  * * ** ",
                    "* ** *   ***",
                    "***   ",
                    "**",
                    "*",
                    "*"};

    @Test
    public void SampleTests() {
        assertEquals("Top 50 massacre failure", "codewarsxxxx", AlphabetWars.reinforcesMassacre(reinforces, aristrikes));
        assertEquals("hi___fg", AlphabetWars.reinforcesMassacre(new String[]{"abcdefg", "hijklmn"},
                new String[]{"   *   ", "*  *   "}));
        assertEquals("ccbaa", AlphabetWars.reinforcesMassacre(new String[]{"aaaaa", "bbbbb", "ccccc", "ddddd"},
                new String[]{"*", " *", "   "}));
    }

    @Test
    public void SampleTestBest() {
        assertEquals("Top 50 massacre failure", "codewarsxxxx", AlphabetWars.reinforcesMassacreBest(reinforces, aristrikes));
        assertEquals("hi___fg", AlphabetWars.reinforcesMassacreBest(new String[]{"abcdefg", "hijklmn"},
                new String[]{"   *   ", "*  *   "}));
        assertEquals("ccbaa", AlphabetWars.reinforcesMassacreBest(new String[]{"aaaaa", "bbbbb", "ccccc", "ddddd"},
                new String[]{"*", " *", "   "}));
    }

}