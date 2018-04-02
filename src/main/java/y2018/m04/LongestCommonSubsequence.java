package y2018.m04;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static String lcs(String x, String y) {
        if (x.isEmpty() || y.isEmpty())
            return "";
        char[] xs = x.toCharArray();
        char[] ys = y.toCharArray();
        if (xs[xs.length - 1] == ys[ys.length - 1]) {
            String newX = new String(Arrays.copyOf(xs, xs.length - 1));
            String newY = new String(Arrays.copyOf(ys, ys.length - 1));
            return lcs(newX, newY) + xs[xs.length - 1];
        } else {
            String newY = new String(Arrays.copyOf(ys, ys.length - 1));
            String newX = new String(Arrays.copyOf(xs, xs.length - 1));
            return lcs(x, newY).length() > lcs(newX, y).length() ? lcs(x, newY) : lcs(newX, y);
        }
    }
}
