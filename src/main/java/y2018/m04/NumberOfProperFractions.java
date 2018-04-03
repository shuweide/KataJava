package y2018.m04;

/**
 *
 */
public class NumberOfProperFractions {

    public static long properFractions(long n) {
        return n < 2 ? 0 : phi(n);
    }

    /**
     * Euclidean algorithm = 輾轉相除法
     * @param number1
     * @param number2
     * @return
     */
    private static long euclideanGCD(long number1, long number2) {
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
    private static long steinsGCD(long number1, long number2) {
        if (number1 == 0) return number2;
        if (number2 == 0) return number1;
        if (number1 % 2 == 0 && number2 % 2 == 0) return 2 * steinsGCD(number1 >> 1, number2 >> 1);
        else if (number1 % 2 == 0) return steinsGCD(number1 >> 1, number2);
        else if (number2 % 2 == 0) return steinsGCD(number1, number2 >> 1);
        else return steinsGCD(Math.abs(number1 - number2), Math.min(number1, number2));
    }

    /**
     * Euler's totient
     * https://www.geeksforgeeks.org/eulers-totient-function/
     * @param n
     * @return
     */
    private static long phi(long n) {
        // Initialize result as n
        double result = n;

        // Consider all prime factors of n and for
        // every prime factor p, multiply result
        // with (1 - 1/p)
        for (long p = 2; p * p <= n; ++p) {
            // Check if p is a prime factor.
            if (n % p == 0) {
                // If yes, then update n and result
                while (n % p == 0)
                    n /= p;
                result *= (1.0 - (1.0 / (double) p));
            }
        }

        // If n has a prime factor greater than sqrt(n)
        // (There can be at-most one such prime factor)
        if (n > 1)
            result *= (1.0 - (1.0 / (double) n));

        return (long) result;
    }
}
