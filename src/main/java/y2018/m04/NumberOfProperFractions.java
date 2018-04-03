package y2018.m04;

/**
 * ### 2018/04/03
 *
 * If n is the numerator and d the denominator of a fraction, that fraction is defined a (reduced) proper fraction
 * if and only if GCD(n,d)==1.
 *
 * For example 5/16 is a proper fraction, while 6/16 is not, as both 6 and 16 are divisible by 2,
 * thus the fraction can be reduced to 3/8.
 *
 * Now, if you consider a given number d, how many proper fractions can be built using d as a denominator?
 *
 * For example, let's assume that d is 15: you can build a total of 8 different proper fractions
 * between 0 and 1 with it: 1/15, 2/15, 4/15, 7/15, 8/15, 11/15, 13/15 and 14/15.
 *
 * You are to build a function that computes how many proper fractions you can build with a given denominator:
 * ```java
 * proper_fractions(1)==0
 * proper_fractions(2)==1
 * proper_fractions(5)==4
 * proper_fractions(15)==8
 * proper_fractions(25)==20
 * ```
 * Be ready to handle big numbers.
 */
public class NumberOfProperFractions {

    /**
     * ```java
     * return n < 2 ? 0 : phi(n);
     * ```
     * @param n
     * @return
     */
    public static long properFractions(long n) {
        return n < 2 ? 0 : phi(n);
    }

    public static long properFractions2(long n) {
        return n < 2 ? 0 : phi2(n);
    }

    /**
     * Euclidean algorithm = 輾轉相除法
     * @param number1
     * @param number2
     * @return
     */
    public static long euclideanGCD(long number1, long number2) {
        if (number1 == 0) return number2;
        if (number2 == 0) return number1;

        long gcd = number1;
        while (number2 != 0) {
            long mod = gcd % number2;
            gcd = number2;
            number2 = mod;
        }
        return gcd;
    }

    /**
     * Binary GCD algorithm = Stein's algorithm
     * @param number1
     * @param number2
     * @return
     */
    public static long steinsGCD(long number1, long number2) {
        if (number1 == 0) return number2;
        if (number2 == 0) return number1;
        if (number1 % 2 == 0 && number2 % 2 == 0) return 2 * steinsGCD(number1 >> 1, number2 >> 1);
        else if (number1 % 2 == 0) return steinsGCD(number1 >> 1, number2);
        else if (number2 % 2 == 0) return steinsGCD(number1, number2 >> 1);
        else return steinsGCD(Math.abs(number1 - number2), Math.min(number1, number2));
    }

    /**
     * [**Euler's totient**](https://zh.wikipedia.org/wiki/%E6%AC%A7%E6%8B%89%E5%87%BD%E6%95%B0)
     *
     * [code example](https://www.geeksforgeeks.org/eulers-totient-function/)
     *
     * ```java
     *      // Initialize result as n
     *      double result = n;
     *      // Consider all prime factors of n and for
     *      // every prime factor p, multiply result
     *      // with (1 - 1/p)
     *      for (long p = 2; p * p <= n; ++p) {
     *          // Check if p is a prime factor.
     *          if (n % p == 0) {
     *                  // If yes, then update n and result
     *                  while (n % p == 0)
     *                      n /= p;
     *                  result *= (1.0 - (1.0 / (double) p));
     *          }
     *      }
     *      // If n has a prime factor greater than sqrt(n)
     *      // (There can be at-most one such prime factor)
     *      if (n > 1)
     *          result *= (1.0 - (1.0 / (double) n));
     *      return (long) result;
     * ```
     * @param n
     * @return
     */
    public static long phi(long n) {
        // Initialize result as n
        double result = n;

        // Consider all prime factors of n and for
        // every prime factor p, multiply result
        // with (1 - 1/p)
        for (long p = 2; p * p <= n; ++p) {
            // Check if p is a prime factor.
            if (n % p == 0) {
                // If yes, then update n and result
                while (n % p == 0) {
                    System.out.printf("p is %d\n", p);
                    n /= p;
                }
                result *= (1.0 - (1.0 / (double) p));
            }
        }

        // If n has a prime factor greater than sqrt(n)
        // (There can be at-most one such prime factor)
        if (n > 1) {
            System.out.printf("last p is %d\n", n);
            result *= (1.0 - (1.0 / (double) n));
        }

        return (long) result;
    }

    /**
     * ###phi avoid floating point.###
     * ```java
     * long result = n;
     * for (long p = 2; p * p <= n; ++p) {
     *      if (n % p == 0) {
     *          while (n % p == 0) {
     *              n /= p;
     *          }
     *          result -= result / p;
     *      }
     * }
     * if (n > 1) {
     *      result -= result / n;
     * }
     * return result;
     * ```
     * @param n
     * @return
     */
    public static long phi2(long n) {
        long result = n;
        for (long p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }

        return result;
    }
}
