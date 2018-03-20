package y2018.m03;

import java.util.stream.IntStream;

/**
 * ### 2018/03/20
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 *
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 */
public class MultiplesOf3Or5 {
    /**
     * ```java
     *      return IntStream.range(1, number).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
     * ```
     * @param number
     * @return
     */
    public static int solution(int number) {
        return IntStream.range(1, number).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
    }
}
