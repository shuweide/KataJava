package y2018.m03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FunWithTreesTest {
    @Test
    public void emptyArray() {
        TreeNode expected = null;
        assertThat(FunWithTrees.arrayToTree(arrayFrom()), is(expected));
    }

    @Test
    public void arrayWithMultipleElements() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3),
                new TreeNode(15)), new TreeNode(-4));
        assertThat(FunWithTrees.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }
}