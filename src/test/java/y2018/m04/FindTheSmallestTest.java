package y2018.m04;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindTheSmallestTest {

    private static void testing(long n, String res) {
        assertEquals(res,
                Arrays.toString(FindTheSmallest.smallest(n)));
    }

    @Test
    public void test() {
        System.out.println("Basic Tests smallest");
        testing(261235, "[126235, 2, 0]");
        testing(209917, "[29917, 0, 1]");
        testing(285365, "[238565, 3, 1]");
        testing(269045, "[26945, 3, 0]");
        testing(296837, "[239687, 4, 1]");
    }

    @Test
    public void test1() {
        testing(199819884756L, "[119989884756, 4, 0]");
    }

    @Test
    public void test2() {
        testing(935855753, "[358557539, 0, 8]");
    }

    @Test
    public void test3() {
        testing(713392275077788800L, "[71339227507778880, 16, 0]");
    }

    @Test
    public void test4() {
        testing(201231811863494016L, "[12231811863494016, 0, 2]");
    }

    @Test
    public void test5() {
        testing(151834822389979872L, "[115834822389979872, 1, 2]");
    }

    @Test
    public void test6() {
        testing(702047370647898624L, "[20473706477898624, 0, 10]");
    }

}