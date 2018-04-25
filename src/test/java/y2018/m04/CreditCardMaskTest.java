package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardMaskTest {
    @Test
    public void testSolution() {
        assertEquals(CreditCardMask.maskify("4556364607935616"), "############5616");
        assertEquals(CreditCardMask.maskify("64607935616"), "#######5616");
        assertEquals(CreditCardMask.maskify("1"), "1");
        assertEquals(CreditCardMask.maskify(""), "");

        // "What was the name of your first pet?"
        assertEquals(CreditCardMask.maskify("Skippy"), "##ippy");
        assertEquals(CreditCardMask.maskify("Nananananananananananananananana Batman!"),
                "####################################man!");
    }
}