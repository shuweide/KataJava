package y2018.m03;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ### 2018/03/19
 * ## Description:
 *
 * Don't give me five!
 * In this kata you get the start number and the end number of a region and should return the count of all numbers except numbers with a 5 in it. The start and the end number are both inclusive!
 *
 * Examples:
 * ```java
 * 1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
 * 4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
 * ```
 * The result may contain fives. ;-)
 * The start number will always be smaller than the end number. Both numbers can be also negative!
 *
 * I'm very curious for your solutions and the way you solve it. Maybe someone of you will find an easy pure mathematics solution.
 *
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 *
 * I have also created other katas. Take a look if you enjoyed this kata!
 *
 */
public class DoGiveMeFive {

    /**
     * ```java
     * int numbers = end - start + 1;
     * return (int) Stream.iterate(start, i -> i + 1)
     *      .limit(numbers).map(String::valueOf).filter(s -> !s.contains("5")).count();
     * ```
     * @param start
     * @param end
     * @return
     */
    public static int dontGiveMeFive(int start, int end) {
        int numbers = end - start + 1;
        return (int) Stream.iterate(start, i -> i + 1)
                .limit(numbers).map(String::valueOf).filter(s -> !s.contains("5")).count();
    }

    /**
     * ```java
     * return IntStream.rangeClosed(start, end).filter(x -> !String.valueOf(x).matches(".*5.*")).count();
     * ```
     * @param start
     * @param end
     * @return
     */
    public static long dontGiveMeFiveBest(int start, int end) {
        return IntStream.rangeClosed(start, end).filter(x -> !String.valueOf(x).matches(".*5.*")).count();
    }
}
