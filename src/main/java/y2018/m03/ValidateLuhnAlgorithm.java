package y2018.m03;

import java.util.Arrays;

/**
 * ### 2018/03/24
 *
 * In this Kata, you will implement the Luhn Algorithm, which is used to help validate credit card numbers.
 *
 * Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.
 *
 * Here is the algorithm:
 *
 * Double every other digit, scanning from right to left, starting from the second digit (from the right).
 *
 * Another way to think about it is: if there are an even number of digits, double every other digit starting with the first;
 * if there are an odd number of digits, double every other digit starting with the second:
 * ```java
 * 1714 ==> [1*, 7, 1*, 4] ==> [2, 7, 2, 4]
 * 12345 ==> [1, 2*, 3, 4*, 5] ==> [1, 4, 3, 8, 5]
 * 891 ==> [8, 9*, 1] ==> [8, 18, 1]
 * ```
 *
 * If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as subtracting 9 from it):
 * ```java
 * [8, 18*, 1] ==> [8, (1+8), 1] ==> [8, 9, 1]
 * or:
 * [8, 18*, 1] ==> [8, (18-9), 1] ==> [8, 9, 1]
 * ```
 *
 * Sum all of the final digits:
 * ```java
 * [8, 9, 1] ==> 8 + 9 + 1 = 18
 * ```
 *
 * Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.
 * ```java
 * 18 (modulus) 10 ==> 8 , which is not equal to 0, so this is not a valid credit card number
 * ```
 */
public class ValidateLuhnAlgorithm {
    /**
     * int[] cardNumbers = Arrays.stream(originNumberString.split(""))
     *      .mapToInt(Integer::valueOf).toArray();
     *
     * int sum = 0;
     * for (int i = cardNumbers.length - 1, count = 1; i >= 0; i--, count++) {
     *      if (count % 2 == 0) {
     *          int number = cardNumbers[i] * 2;
     *          cardNumbers[i] = number > 9 ? number - 9 : number;
     *      }
     *      sum += cardNumbers[i];
     * }
     *
     * return sum % 10 == 0;
     * @param originNumberString
     * @return
     */
    public static boolean validate(String originNumberString) {
        int[] cardNumbers = Arrays.stream(originNumberString.split(""))
                .mapToInt(Integer::valueOf).toArray();

        int sum = 0;
        for (int i = cardNumbers.length - 1, count = 1; i >= 0; i--, count++) {
            if (count % 2 == 0) {
                int number = cardNumbers[i] * 2;
                cardNumbers[i] = number > 9 ? number - 9 : number;
            }
            sum += cardNumbers[i];
        }

        return sum % 10 == 0;
    }

    /**
     * ```java
     * boolean otherDigit = false;
     * int sum = 0;
     *
     * for (int i = line.length() - 1; i >= 0; --i) {
     *      // convert char to number
     *      int digit = line.charAt(i) - '0';
     *
     *      // double the value of every second digit
     *      if (otherDigit) {
     *          digit *= 2;
     *      }
     *      otherDigit ^= true;
     *
     *      if (digit > 9) {
     *          digit = digit / 10 + digit;
     *      }
     *
     *      sum += digit;
     * }
     * return sum % 10 == 0;
     * @param line
     * @return
     */
    public static boolean validateBest(String line) {
        boolean otherDigit = false;
        int sum = 0;

        for (int i = line.length() - 1; i >= 0; --i) {
            // convert char to number
            int digit = line.charAt(i) - '0';

            // double the value of every second digit
            if (otherDigit) {
                digit *= 2;
            }
            otherDigit ^= true;

            if (digit > 9) {
                digit = digit / 10 + digit;
            }

            sum += digit;
        }
        return sum % 10 == 0;
    }
}
