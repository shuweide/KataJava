package y2018.m04;

import java.util.*;

/**
 * ###2018/04/15###
 *
 * ###Introduction###
 *
 * There is a war and nobody knows - the alphabet war!
 * There are two groups of hostile letters. The tension between left side letters and right side letters was too high and the war began.
 * The letters have discovered a new unit - a priest with Wo lo looooooo power.
 *
 * ![WOLOLO](http://img04.bgstatic-com.de/images/documents/documents/3236/modulecontent/612x0/en_top5_quote_aoe.jpg)
 *
 * ###Task###
 *
 * Write a function that accepts fight string consists of only small letters and return who wins the fight. When the left side wins return Left side wins!, when the right side wins return Right side wins!, in other case return Let's fight again!.
 * The left side letters and their power:
 * ```java
 * w - 4
 * p - 3
 * b - 2
 * s - 1
 * t - 0 (but it's priest with Wo lo loooooooo power)
 * ```
 *
 * The right side letters and their power:
 * ```java
 * m - 4
 * q - 3
 * d - 2
 * z - 1
 * j - 0 (but it's priest with Wo lo loooooooo power)
 * ```
 *
 * The other letters don't have power and are only victims.
 * The priest units t and j change the adjacent letters from hostile letters to friendly letters with the same power.
 * ```java
 * mtq => wtp
 * wjs => mjz
 * ```
 *
 * A letter with adjacent letters j and t is not converted i.e.:
 * ```java
 * tmj => tmj
 * jzt => jzt
 * ```
 *
 * The priests (j and t) do not convert the other priests ( jt => jt).
 *
 * ###Example###
 * ```java
 * AlphabetWars.woLoLoooooo("z")         //=>  "z"  => "Right side wins!"
 * AlphabetWars.woLoLoooooo("tz")        //=>  "ts" => "Left side wins!"
 * AlphabetWars.woLoLoooooo("jz")        //=>  "jz" => "Right side wins!"
 * AlphabetWars.woLoLoooooo("zt")        //=>  "st" => "Left side wins!"
 * AlphabetWars.woLoLoooooo("azt")       //=> "ast" => "Left side wins!"
 * AlphabetWars.woLoLoooooo("tzj")       //=> "tzj" => "Right side wins!"
 * ```
 */
public class AlphabetWarPriest {

    private static final String LEFT_WIN = "Left side wins!", RIGHT_WIN = "Right side wins!", TIE = "Let's fight again!";
    private static Map<Character, Integer> scores;
    private static List<Character> leftTeam, rightTeam;

    static {
        leftTeam = new LinkedList<>(Arrays.asList('t', 's', 'b', 'p', 'w'));
        rightTeam = new LinkedList<>(Arrays.asList('j', 'z', 'd', 'q', 'm'));

        //add scores
        scores = new HashMap<>();
        leftTeam.forEach(c -> scores.put(c, -1 * leftTeam.indexOf(c)));
        rightTeam.forEach(c -> scores.put(c, rightTeam.indexOf(c)));
    }

    /**
     * ```java
     * char[] letters = new char[battlefield.length() + 2];
     * int index = 0;
     * for (char c : battlefield.toCharArray()) {
     *      letters[++index] = c;
     * }
     * if (battlefield.matches(".*[tj]+.*")) {
     *      for (int i = 1; i < letters.length - 1; i++) {
     *          if (letters[i] == 't') {
     *              priestWoLo(letters, i, 't');
     *          }
     *          if (letters[i] == 'j') {
     *              priestWoLo(letters, i, 'j');
     *          }
     *      }
     * }
     * System.out.printf("letters is %s \n", Arrays.toString(Arrays.copyOfRange(letters, 1, letters.length - 1)));
     * int score = 0;
     * for (char c : letters) {
     *      score += scores.getOrDefault(c, 0);
     * }
     * return score == 0 ? TIE : score > 0 ? RIGHT_WIN : LEFT_WIN;
     * ```
     * @param battlefield
     * @return
     */
    public static String woLoLoooooo(String battlefield) {

        //copy letters and extend 2
        char[] letters = new char[battlefield.length() + 2];
        int index = 0;
        for (char c : battlefield.toCharArray()) {
            letters[++index] = c;
        }

        //have priest
        if (battlefield.matches(".*[tj]+.*")) {
            for (int i = 1; i < letters.length - 1; i++) {
                if (letters[i] == 't') {
                    priestWoLo(letters, i, 't');
                }
                if (letters[i] == 'j') {
                    priestWoLo(letters, i, 'j');
                }
            }
        }

        //print
        System.out.printf("letters is %s \n", Arrays.toString(Arrays.copyOfRange(letters, 1, letters.length - 1)));

        int score = 0;
        for (char c : letters) {
            score += scores.getOrDefault(c, 0);
        }

        return score == 0 ? TIE : score > 0 ? RIGHT_WIN : LEFT_WIN;
    }

    private static void priestWoLo(char[] letters, int letterIndex, char ourPriest) {
        char enemyPriest = ourPriest == 't' ? 'j' : 't';
        char prevLetter = letters[letterIndex - 1];
        char nextLetter = letters[letterIndex + 1];
        List<Character> selfTeam = ourPriest == 't' ? leftTeam : rightTeam;
        List<Character> enemyTeam = ourPriest == 't' ? rightTeam : leftTeam;
        if (prevLetter != enemyPriest && enemyTeam.contains(prevLetter)) {
            letters[letterIndex - 1] = selfTeam.get(enemyTeam.indexOf(prevLetter));
        }
        if (nextLetter != enemyPriest && enemyTeam.contains(nextLetter)) {
            letters[letterIndex + 1] = selfTeam.get(enemyTeam.indexOf(nextLetter));
        }
    }

    /**
     * ```java
     *         Map<Character, Integer> m = new HashMap<>();
     *         m.put('w', -4);
     *         m.put('p', -3);
     *         m.put('b', -2);
     *         m.put('s', -1);
     *         m.put('m', 4);
     *         m.put('q', 3);
     *         m.put('d', 2);
     *         m.put('z', 1);
     *
     *         int score = 0;
     *
     *         for (int i = 0; i < battlefield.length(); i++) {
     *             int p = m.getOrDefault(battlefield.charAt(i), 0);
     *             if ((p > 0 && isConverted(i, battlefield, 't', 'j')) || (p < 0 && isConverted(i, battlefield, 'j', 't'))) {
     *                 p = 0 - p;
     *             }
     *             score += p;
     *         }
     *         if (score > 0) {
     *             return "Right side wins!";
     *         } else if (score < 0) {
     *             return "Left side wins!";
     *         }
     *         return "Let's fight again!";
     * ```
     * @param battlefield
     * @return
     */
    public static String woLoLooooooBest(String battlefield) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('w', -4);
        m.put('p', -3);
        m.put('b', -2);
        m.put('s', -1);
        m.put('m', 4);
        m.put('q', 3);
        m.put('d', 2);
        m.put('z', 1);

        int score = 0;

        for (int i = 0; i < battlefield.length(); i++) {
            int p = m.getOrDefault(battlefield.charAt(i), 0);
            if ((p > 0 && isConverted(i, battlefield, 't', 'j')) || (p < 0 && isConverted(i, battlefield, 'j', 't'))) {
                p = 0 - p;
            }
            score += p;
        }
        if (score > 0) {
            return "Right side wins!";
        } else if (score < 0) {
            return "Left side wins!";
        }
        return "Let's fight again!";
    }

    private static boolean isConverted(int i, String battlefield, char enemyC, char ourC) {
        boolean prevConverts = (i > 0 && battlefield.charAt(i - 1) == enemyC)
                && (i == battlefield.length() - 1 || battlefield.charAt(i + 1) != ourC);
        boolean nextConverts = (i < battlefield.length() - 1 && battlefield.charAt(i + 1) == enemyC)
                && (i == 0 || battlefield.charAt(i - 1) != ourC);
        return prevConverts || nextConverts;
    }
}
