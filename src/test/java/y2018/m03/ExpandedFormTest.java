package y2018.m03;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpandedFormTest {
    @Test
    public void expandedForm() {
        assertEquals("10 + 2", ExpandedForm.expandedForm(12));
        assertEquals("40 + 2", ExpandedForm.expandedForm(42));
        assertEquals("70000 + 300 + 4", ExpandedForm.expandedForm(70304));

        assertEquals("10 + 2", ExpandedForm.expandedFormBest(12));
        assertEquals("40 + 2", ExpandedForm.expandedFormBest(42));
        assertEquals("70000 + 300 + 4", ExpandedForm.expandedFormBest(70304));
    }

}