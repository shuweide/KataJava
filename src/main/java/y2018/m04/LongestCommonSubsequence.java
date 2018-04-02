package y2018.m04;

import java.util.Arrays;

/**
 * ### 2018/04/02
 *
 * Write a function called LCS that accepts two sequences and returns the longest subsequence common to the passed in sequences.
 *
 * ###Subsequence###
 *
 * A subsequence is different from a substring. The terms of a subsequence need not be consecutive terms of the original sequence.
 * ###Example subsequence###
 *
 * Subsequences of "abc" = "a", "b", "c", "ab", "ac", "bc" and "abc".
 *
 * ###LCS examples###
 * ```java
 * Solution.lcs("abcdef", "abc") => returns "abc"
 * Solution.lcs("abcdef", "acf") => returns "acf"
 * Solution.lcs("132535365", "123456789") => returns "12356"
 * ```
 * ###Notes###
 * - Both arguments will be strings
 * - Return value must be a string
 * - Return an empty string if there exists no common subsequence
 * - Both arguments will have one or more characters (in JavaScript)
 * - All tests will only have a single longest common subsequence. Don't worry about cases such as LCS( "1234", "3412" ),
 * which would have two possible longest common subsequences: "12" and "34".
 *
 * Note that the Haskell variant will use randomized testing, but any longest common subsequence will be valid.
 * Note that the OCaml variant is using generic lists instead of strings,
 * and will also have randomized tests (any longest common subsequence will be valid).
 */
public class LongestCommonSubsequence {

    /**
     * ```java
     * if (x.isEmpty() || y.isEmpty())
     *      return "";
     * char[] xs = x.toCharArray();
     * char[] ys = y.toCharArray();
     * if (xs[xs.length - 1] == ys[ys.length - 1]) {
     *      String newX = new String(Arrays.copyOf(xs, xs.length - 1));
     *      String newY = new String(Arrays.copyOf(ys, ys.length - 1));
     *      return lcs(newX, newY) + xs[xs.length - 1];
     * } else {
     *      String newY = new String(Arrays.copyOf(ys, ys.length - 1));
     *      String newX = new String(Arrays.copyOf(xs, xs.length - 1));
     *      return lcs(x, newY).length() > lcs(newX, y).length() ? lcs(x, newY) : lcs(newX, y);
     * }
     * ```
     * @param x
     * @param y
     * @return
     */
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

    /**
     * ```java
     * int m = x.length(), n = y.length();
     * int[][] nums = new int[m + 1][n + 1];
     * for (int i = 1; i <= m; i++) {
     *      for (int j = 1; j <= n; j++) {
     *          nums[i][j] = nums[i - 1][j - 1] + (x.charAt(i - 1) == y.charAt(j - 1) ? 1 : 0);
     *          nums[i][j] = Math.max(nums[i][j], nums[i - 1][j]);
     *          nums[i][j] = Math.max(nums[i][j], nums[i][j - 1]);
     *      }
     * }
     * StringBuilder sb = new StringBuilder();
     * for(int i = 1; i <= n; i++) {
     *      if (nums[m][i] - nums[m][i - 1] == 1) {
     *          sb.append(y.charAt(i - 1));
     *      }
     * }
     * return sb.toString();
     * ```
     * @param x
     * @param y
     * @return
     */
    public static String lcsBest(String x, String y) {
        int m = x.length(), n = y.length();
        int[][] nums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = nums[i - 1][j - 1] + (x.charAt(i - 1) == y.charAt(j - 1) ? 1 : 0);
                nums[i][j] = Math.max(nums[i][j], nums[i - 1][j]);
                nums[i][j] = Math.max(nums[i][j], nums[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if (nums[m][i] - nums[m][i - 1] == 1) {
                sb.append(y.charAt(i - 1));
            }
        }
        return sb.toString();
    }
}
