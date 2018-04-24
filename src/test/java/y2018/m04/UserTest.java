package y2018.m04;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void smapleTest() {
        User user = new User();
        Assert.assertEquals(-8, user.rank);
        Assert.assertEquals(0, user.progress);
        user.incProgress(-7);
        Assert.assertEquals(10, user.progress);
        user.incProgress(-5);
        Assert.assertEquals(0, user.progress);
        Assert.assertEquals(-7, user.rank);
    }

    @Test
    public void smapleAnother() {
        User user = new User();
        Assert.assertEquals(-8, user.rank);
        Assert.assertEquals(0, user.progress);
        user.incProgress(1);
        //8*8*10= 640, -2, 40
        Assert.assertEquals(-2, user.rank);
        Assert.assertEquals(40, user.progress);
        //6*6*10 = 360+40(origin),   -2 -> -1 -> 1 -> 2 -> 3, 0
        user.incProgress(5);
        Assert.assertEquals(3, user.rank);
        Assert.assertEquals(0, user.progress);
    }

}