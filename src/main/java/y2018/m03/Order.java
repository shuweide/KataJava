package y2018.m03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ### 2018/03/17
 * ## Description:
 * <p>
 * Your task is to sort a given string. Each word in the String will contain a single number.
 * This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.
 * <p>
 * For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"
 * <p>
 * your_order("is2 Thi1s T4est 3a")
 * [1] "Thi1s is2 3a T4est"
 *
 */
public class Order {

    /**
     * ```java
     *
     * if (words == null || words.length() == 0 || words.trim().equals("")) {
     *      return "";
     * }
     *
     * String[] wordArray = words.split(" ");
     * List<String> wordList = Arrays.asList(wordArray);
     *
     * Comparator<String> containNumberComparator = new Comparator<String>() {
     *      public int compare(String o1, String o2) {
     *          int i1 = Integer.valueOf(o1.replaceAll("[^\\d.]", ""));
     *          int i2 = Integer.valueOf(o2.replaceAll("[^\\d.]", ""));
     *          return i1 - i2;
     *      }
     * };
     *
     * return wordList.stream().sorted(containNumberComparator).collect(Collectors.joining(" "));
     *
     * ```
     * @param words
     * @return
     */
    public static String order(String words) {
        if (words == null || words.length() == 0 || words.trim().equals("")) {
            return "";
        }

        String[] wordArray = words.split(" ");
        List<String> wordList = Arrays.asList(wordArray);

        Comparator<String> containNumberComparator = new Comparator<String>() {
            public int compare(String o1, String o2) {
                int i1 = Integer.valueOf(o1.replaceAll("[^\\d.]", ""));
                int i2 = Integer.valueOf(o2.replaceAll("[^\\d.]", ""));
                return i1 - i2;
            }
        };

        return wordList.stream().sorted(containNumberComparator).collect(Collectors.joining(" "));
    }

    /**
     * ```java
     *
     * return Arrays.stream(words.split(" "))
     *      .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
     *      .collect(Collectors.joining(" "));
     *
     * ```
     * @param words
     * @return
     */
    public static String orderBest(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .collect(Collectors.joining(" "));
    }
}
