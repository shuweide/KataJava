package y2018.m04;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void smapleTest() {
        User user = new User();
        Assert.assertEquals(-8, user.rank());
        Assert.assertEquals(0, user.progress());
        user.incProgress(-7);
        Assert.assertEquals(10, user.progress());
        user.incProgress(-5);
        Assert.assertEquals(0, user.progress());
        Assert.assertEquals(-7, user.rank());
    }

}