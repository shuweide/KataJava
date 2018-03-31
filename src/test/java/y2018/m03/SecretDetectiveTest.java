package y2018.m03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecretDetectiveTest {

    private SecretDetective detective;

    @Before
    public void setup() {
        detective = new SecretDetective();
    }

    @Test
    public void secret() {
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
    }

    @Test
    public void secretBest() {
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };
        assertEquals("whatisup", detective.recoverSecretBest(triplets));
    }
}