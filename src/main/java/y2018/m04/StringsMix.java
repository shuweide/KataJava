package y2018.m04;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ###2018/04/20###
 *
 * Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z).
 * First let us count the frequency of each lowercase letters in s1 and s2.
 *
 * ```java
 * s1 = "A aaaa bb c"
 *
 * s2 = "& aaa bbb c d"
 *
 * s1 has 4 'a', 2 'b', 1 'c'
 *
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * ```
 *
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2.
 * In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.
 *
 * We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4.
 * In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.
 *
 * The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1;
 * these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.
 *
 * In the result, substrings (a substring is for example 2:nnnnn or 1:hhh;
 * it contains the prefix) will be in decreasing order of their length and when they have the same
 * length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint);
 * the different groups will be separated by '/'. See examples and "Example Tests".
 *
 * Hopefully other examples can make this clearer.
 *
 * ```java
 * s1 = "my&friend&Paul has heavy hats! &"
 * s2 = "my friend John has many many friends &"
 * mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 *
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 *
 * s1="Are the kids at home? aaaaa fffff"
 * s2="Yes they are here! aaaaa fffff"
 * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
 * ```
 */
public class StringsMix {
    public static String mix(String s1, String s2) {

        Map<String, Long> letterMap1 = parseStringToLetterCountingMapIgnoreOne(s1);
        Map<String, Long> letterMap2 = parseStringToLetterCountingMapIgnoreOne(s2);

        List<String> result = new ArrayList<>();
        //make letter str to list
        letterMap1.forEach((k, v) -> {
            String preFix = "1:";
            if (letterMap2.containsKey(k)) {
                long l2 = letterMap2.get(k);
                letterMap2.remove(k);
                preFix = v == l2 ? "=:" : v > l2 ? "1:" : "2:";
                result.add(preFix + repeat(k, v >= l2 ? v : l2));
            } else {
                result.add(preFix + repeat(k, v));
            }
        });
        letterMap2.forEach((k, v) -> result.add("2:" + repeat(k, v)));

        //sort and concat
        return result.stream()
                .sorted(Comparator.comparing(String::length)
                        .reversed()
                        .thenComparing(String::compareTo))
                .collect(Collectors.joining("/"));
    }

    private static Map<String, Long> parseStringToLetterCountingMapIgnoreOne(String s) {
        Map<String, Long> map = Arrays.stream(s.replaceAll("[^a-z]", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.values().removeIf(l -> l == 1);
        return map;
    }

    private static String repeat(String str, long times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    /**
     * ```java
     * List<String> finalStr = new ArrayList();
     *
     * for (char c = 'a'; c <= 'z'; c++) {
     *      String s1_char = s1.replaceAll("[^"+c+"]+","");
     *      String s2_char = s2.replaceAll("[^"+c+"]+","");
     *
     *      int s1_length = s1_char.length();
     *      int s2_length = s2_char.length();
     *
     *      if(s1_length>1 || s2_length>1){
     *          if(s1_length == s2_length){
     *              finalStr.add("=:"+s1_char);
     *          }
     *          if(s1_length>s2_length){
     *              finalStr.add("1:"+s1_char);
     *          }
     *          if(s1_length<s2_length){
     *              finalStr.add("2:"+s2_char);
     *          }
     *       }
     * }
     * Comparator<String> length = (x, y) -> y.length()-x.length();
     * Comparator<String> type_value = Comparator.comparingInt(x -> x.charAt(0));
     *
     * return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
     * ```
     * @param s1
     * @param s2
     * @return
     */
    public static String mixBest(String s1, String s2) {

        List<String> finalStr = new ArrayList();

        for (char c = 'a'; c <= 'z'; c++) {
            String s1_char = s1.replaceAll("[^" + c + "]+", "");
            String s2_char = s2.replaceAll("[^" + c + "]+", "");

            int s1_length = s1_char.length();
            int s2_length = s2_char.length();

            if (s1_length > 1 || s2_length > 1) {
                if (s1_length == s2_length) {
                    finalStr.add("=:" + s1_char);
                }
                if (s1_length > s2_length) {
                    finalStr.add("1:" + s1_char);
                }
                if (s1_length < s2_length) {
                    finalStr.add("2:" + s2_char);
                }
            }
        }
        Comparator<String> length = (x, y) -> y.length() - x.length();
        Comparator<String> type_value = Comparator.comparingInt(x -> x.charAt(0));

        return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
    }
}


