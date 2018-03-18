import java.util.Arrays;
import java.util.stream.Stream;

/**
 * ### 2018/03/18 Kata
 * ##　Description:
 * <p>
 * Well met with Fibonacci bigger brother, AKA Tribonacci.
 * <p>
 * As the name may already reveal, it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers of the sequence to generate the next. And, worse part of it, regrettably I won't get to hear non-native Italian speakers trying to pronounce it :(
 * <p>
 * So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), we have this sequence:
 * <p>
 * ```java
 * [1, 1 ,1, 3, 5, 9, 17, 31, ...]
 * ```
 * But what if we started with [0, 0, 1] as a signature? As starting with [0, 1] instead of [1, 1] basically shifts the common Fibonacci sequence by once place, you may be tempted to think that we would get the same sequence shifted by 2 places, but that is not the case and we would get:
 * <p>
 * ```java
 * [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
 * ```
 * Well, you may have guessed it by now, but to be clear: you need to create a fibonacci function that given a signature array/list, returns the first n elements - signature included of the so seeded sequence.
 * <p>
 * Signature will always contain 3 numbers; n will always be a non-negative number; if n == 0, then return an empty array and be ready for anything else which is not clearly specified ;)
 * <p>
 * If you enjoyed this kata more advanced and generalized version of it can be found in the Xbonacci kata
 * <p>
 * [Personal thanks to Professor Jim Fowler on Coursera for his awesome classes that I really recommend to any math enthusiast and for showing me this mathematical curiosity too with his usual contagious passion :)]
 * <p>
 */
public class Xbonacci {

    /**
     * ```java
     *
     * if (s.length < 3 || n <= 0) {
     *      return new double[]{};
     * }
     * return Stream.iterate(s, t -> new double[]{t[1], t[2], t[0] + t[1] + t[2]})
     *      .limit(n)
     *      .mapToDouble(t -> t[0])
     *      .toArray();
     *
     * ```
     * @param s
     * @param n
     * @return
     */
    public double[] tribonacci(double[] s, int n) {
        if (s.length < 3 || n <= 0) {
            return new double[]{};
        }
        return Stream.iterate(s, t -> new double[]{t[1], t[2], t[0] + t[1] + t[2]})
                .limit(n)
                .mapToDouble(t -> t[0])
                .toArray();
    }

    /**
     * ```java
     *
     * double[] tritab = Arrays.copyOf(s, n);
     * for (int i = 3; i < n; i++) {
     *      tritab[i] = tritab[i - 1] + tritab[i - 2] + tritab[i - 3];
     * }
     * return tritab;
     *
     * ```
     * @param s
     * @param n
     * @return
     */
    public double[] tribonacciBest(double[] s, int n) {
        double[] tritab = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            tritab[i] = tritab[i - 1] + tritab[i - 2] + tritab[i - 3];
        }
        return tritab;
    }
}
