package y2018.m04;

import java.util.PriorityQueue;

/**
 * ###2018/04/16###
 *
 * ###Description:###
 * A [Hamming number](https://en.wikipedia.org/wiki/Regular_number) is a positive integer of the form 2^i 3^j 5^k, for some non-negative integers i, j, and k.
 *
 * Write a function that computes the nth smallest Hamming number.
 *
 * Specifically:
 *
 * - The first smallest Hamming number is 1 = 2^0 3^0 5^0
 * - The second smallest Hamming number is 2 = 2^1 3^0 5^0
 * - The third smallest Hamming number is 3 = 2^0 3^1 5^0
 * - The fourth smallest Hamming number is 4 = 2^2 3^0 5^0
 * - The fifth smallest Hamming number is 5 = 2^0 3^0 5^1
 *
 * The 20 smallest Hamming numbers are given in example test fixture.
 *
 * Your code should be able to compute all of the smallest 5,000 (Clojure: 2000) Hamming numbers without timing out.
 */
public class HammingNumbers {

    //reference : https://rosettacode.org/wiki/Hamming_numbers
    public static long hamming(int n) {
        PriorityQueue<Long> hammingNumbers = new PriorityQueue<>();
        updateQueue(1L, hammingNumbers);
        long lowest = 1L;
        for (int i = 1; i < n; i++) {
            lowest = hammingNumbers.poll();
            while (hammingNumbers.peek() == lowest) {
                hammingNumbers.poll();
            }
            updateQueue(lowest, hammingNumbers);
        }
        return lowest;
    }

    private static void updateQueue(long l,
                                    PriorityQueue<Long> pq) {
        pq.offer(l << 1);
        pq.offer(l * 3);
        pq.offer(l * 5);
    }

    /**
     * ```java
     *         long[] h = new long[n];
     *         h[0] = 1;
     *         long x2 = 2, x3 = 3, x5 = 5;
     *         int i = 0, j = 0, k = 0;
     *
     *         for (int index = 1; index < n; index++) {
     *             h[index] = Math.min(x2, Math.min(x3, x5));
     *             if (h[index] == x2) x2 = 2 * h[++i];
     *             if (h[index] == x3) x3 = 3 * h[++j];
     *             if (h[index] == x5) x5 = 5 * h[++k];
     *         }
     *         return h[n - 1];
     * ```
     * @param n
     * @return
     */
    public static long hammingBest(int n) {
        long[] h = new long[n];
        h[0] = 1;
        long x2 = 2, x3 = 3, x5 = 5;
        int i = 0, j = 0, k = 0;

        for (int index = 1; index < n; index++) {
            h[index] = Math.min(x2, Math.min(x3, x5));
            if (h[index] == x2) x2 = 2 * h[++i];
            if (h[index] == x3) x3 = 3 * h[++j];
            if (h[index] == x5) x5 = 5 * h[++k];
        }

        return h[n - 1];
    }
}
