package y2018.m03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ### 2018/03/22
 *
 * You have an array of numbers.
 * Your task is to sort ascending odd numbers but even numbers must be on their places.
 * Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.
 *
 * **Example**
 * ```java
 * sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
 * ```
 */
public class SortTheOdd {
    /**
     * ```java
     * int[] odds = Arrays.stream(array).filter(i -> i % 2 != 0).sorted().toArray();
     *
     * //covert to index, odd map
     * Map<Integer, Integer> oddMap = new HashMap<>();
     * for (int i = 0; i < odds.length; i++) {
     *      oddMap.put(i, odds[i]);
     * }
     *
     * int oddSortNum = 0;
     * int[] resultArray = new int[array.length];
     * for (int i = 0; i < array.length; i++) {
     *      //odd
     *      if (array[i] % 2 != 0) {
     *          resultArray[i] = oddMap.get(oddSortNum++);
     *      } else {
     *          resultArray[i] = array[i];
     *      }
     * }
     * return resultArray;
     * ```
     * @param array
     * @return
     */
    public static int[] sortArray(int[] array) {

        int[] odds = Arrays.stream(array).filter(i -> i % 2 != 0).sorted().toArray();

        //covert to index, odd map
        Map<Integer, Integer> oddMap = new HashMap<>();
        for (int i = 0; i < odds.length; i++) {
            oddMap.put(i, odds[i]);
        }

        int oddSortNum = 0;
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            //odd
            if (array[i] % 2 != 0) {
                resultArray[i] = oddMap.get(oddSortNum++);
            } else {
                resultArray[i] = array[i];
            }
        }

        return resultArray;
    }

    /**
     * ```java
     * // Sort the odd numbers only
     * final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();
     *
     * // Then merge them back into original array
     * for (int j = 0, s = 0; j < array.length; j++) {
     *      if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
     * }
     *
     * return array;
     * ```
     * @param array
     * @return
     */
    public static int[] sortArrayBest(int[] array) {
        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }

        return array;
    }
}
