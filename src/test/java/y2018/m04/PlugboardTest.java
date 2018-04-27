package y2018.m04;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlugboardTest {
    @Test
    public void testValidPlugboard() throws Plugboard.InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("AB");
        assertEquals("B", plugboard.process("A"));
        assertEquals("A", plugboard.process("B"));
        assertEquals("C", plugboard.process("C"));
        assertEquals(".", plugboard.process("."));
    }

    @Test(expected = Plugboard.InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard1() throws Plugboard.InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("ABC");
    }

    @Test(expected = Plugboard.InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard2() throws Plugboard.InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("ABAD");
    }

    @Test(expected = Plugboard.InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard3() throws Plugboard.InvalidPlugboardWiresException {
        Plugboard plugboard = new Plugboard("ABCDEFGHIJKLMNOPQRSTUV");
    }
}