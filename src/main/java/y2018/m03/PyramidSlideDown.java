package y2018.m03;

/**
 * ### 2018/03/27
 *
 * Lyrics... Pyramids are amazing! Both in architectural and mathematical sense. If you have a computer,
 * you can mess with pyramids even if you are not in Egypt at the time. For example, let's consider the following problem.
 * Imagine that you have a plane pyramid built of numbers, like this one here:
 * ```java
 *     /3/
 *    \7\ 4
 *   2 \4\ 6
 *  8 5 \9\ 3
 * ```
 * Here comes the task...
 * Let's say that the 'slide down' is a sum of consecutive numbers from the top to the bottom of the pyramid. As you can see,
 * the longest 'slide down' is 3 + 7 + 4 + 9 = 23
 *
 * Your task is to write a function longestSlideDown (in ruby: longest_slide_down)
 * that takes a pyramid representation as argument and returns its' longest 'slide down'. For example,
 * ```java
 * longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]
 * // => 23
 * ```
 * By the way... My tests include some extraordinarily high pyramides so as you can guess, brute-force method is a bad idea
 * unless you have a few centuries to waste. You must come up with something more clever than that.
 */
public class PyramidSlideDown {

    /**
     * ```java
     * for (int floor = pyramid.length - 2; floor >= 0; floor--) {
     *      for (int num = 0; num < pyramid[floor].length; num++) {
     *          pyramid[floor][num] += getNextFloorMaxNumber(num, pyramid[floor + 1]);
     *      }
     * }
     * return pyramid[0][0];
     * ```
     * @param pyramid
     * @return
     */
    public static int longestSlideDown(int[][] pyramid) {

        for (int floor = pyramid.length - 2; floor >= 0; floor--) {
            for (int num = 0; num < pyramid[floor].length; num++) {
                pyramid[floor][num] += getNextFloorMaxNumber(num, pyramid[floor + 1]);
            }
        }
        return pyramid[0][0];
    }

    private static int getNextFloorMaxNumber(int thisFloorMaxNumberIndex, int[] nextFloor) {
        return Integer.max(nextFloor[thisFloorMaxNumberIndex], nextFloor[thisFloorMaxNumberIndex + 1]);
    }
}
