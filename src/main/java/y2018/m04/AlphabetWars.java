package y2018.m04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ###2018/04/12###
 *
 * ###Introduction###
 *
 * There is a war and nobody knows - the alphabet war!
 * The letters called airstrikes to help them in war - dashes and dots are spread everywhere on the battlefield.
 *
 * ###Task###
 *
 * Write a function that accepts reinforces array of strings and airstrikes array of strings.
 * The reinforces strings consist of only small letters. The size of each string in reinforces array is the same.
 * The airstrikes strings consists of * and white spaces. The size of each airstrike may vary. There may be also no airstrikes at all.
 * The first row in reinforces array is the current battlefield. Whenever some letter is killed by bomb, it's replaced by a letter from next string in reinforces array on the same position.
 * The airstrike always starts from the beginning of the battlefield.
 * The * means a bomb drop place. The each * bomb kills letter only on the battelfield. The bomb kills letter on the same index on battlefield plus the adjacent letters.
 * The letters on the battlefield are replaced after airstrike is finished.
 * Return string of letters left on the battlefield after the last airstrike. In case there is no any letter left in reinforces on specific position, return _.
 *
 * ```java
 * reinforces = [ "abcdefg",
 *                "hijklmn"];
 * airstrikes = [ "   *   ",
 *                "*  *   "];
 * The battlefield  is     : "abcedfg".
 * The first airstrike    : "   *   "
 * After first airstrike  : "ab___fg"
 * Reinforces are comming : "abjklfg"
 * The second airstrike   : "*  *   "
 * After second airstrike : "_____fg"
 * Reinforces are coming  : "hi___fg"
 * No more airstrikes => return "hi___fg"
 * ```
 *
 * ###Other example###
 *
 * ```java
 * reinforces =
 * ["g964xxxxxxxx",
 * "myjinxin2015",
 * "steffenvogel",
 * "smile67xxxxx",
 * "giacomosorbi",
 * "freywarxxxxx",
 * "bkaesxxxxxxx",
 * "vadimbxxxxxx",
 * "zozofouchtra",
 * "colbydauphxx" ];
 * airstrikes =
 * ["* *** ** ***",
 * " ** * * * **",
 * " * *** * ***",
 * " **  * * ** ",
 * "* ** *   ***",
 * "***   ",
 * "**",
 * "*",
 * "*" ]
 * ```
 *
 * That should lead to:
 *
 * ```java
 * AlphabetWars.reinforcesMassacre(reinforces, airstrikes); // => codewarsxxxx
 * ```
 */
public class AlphabetWars {
    public static String reinforcesMassacre(String[] reinforces, String[] airstrikes) {

        int reinforcesIndex = 0;
        char[] currentBattleField = reinforces[reinforcesIndex].toCharArray();
        for (int strikeRound = 0; strikeRound < airstrikes.length; strikeRound++) {
            char[] bombs = airstrikes[strikeRound].toCharArray();

            System.out.printf("current battle field %s \n", Arrays.toString(currentBattleField));

            //air strike
            for (int i = 0; i < bombs.length; i++) {
                if (bombs[i] == '*') {
                    //bomb kill letter and near letter
                    currentBattleField[i] = '_';
                    if (i != 0) currentBattleField[i - 1] = '_';
                    if (i != currentBattleField.length - 1) currentBattleField[i + 1] = '_';
                }
            }

            System.out.printf("air strike %d : %s\n", strikeRound, Arrays.toString(currentBattleField));

            //add letter to battle field
            if (allKill(currentBattleField) && reinforcesIndex < reinforces.length) {
                currentBattleField = reinforces[++reinforcesIndex].toCharArray();
            } else {
                supplyBattleField(reinforces, reinforcesIndex, currentBattleField);
            }
        }

        return new String(currentBattleField);
    }

    private static void supplyBattleField(String[] reinforces, int reinforcesIndex, char[] currentBattleField) {
        for (int letterIndex = 0; letterIndex < currentBattleField.length; letterIndex++) {
            int nextIndex = reinforcesIndex + 1;
            while (currentBattleField[letterIndex] == '_' && nextIndex < reinforces.length) {
                char next = reinforces[nextIndex].toCharArray()[letterIndex];
                if (next != '_') {
                    currentBattleField[letterIndex] = next;
                    char[] word = reinforces[nextIndex].toCharArray();
                    word[letterIndex] = '_';
                    reinforces[nextIndex] = new String(word);
                }
                nextIndex++;
            }
        }
    }

    private static boolean allKill(char[] currentBattleField) {
        return new String(currentBattleField).matches("_{" + currentBattleField.length + "}");
    }

    /**
     * ```java
     * int[] rIdx = new int[reinforces[0].length() + 2];
     * for (String a : airstrikes) {
     *     Set<Integer> massacre = new HashSet<>();
     *     int i = 0;
     *     for (char c : a.toCharArray()) {
     *         i++;
     *         if (c == '*') massacre.addAll(Arrays.asList(i - 1, i, i + 1));
     *     }
     *     for (int idx : massacre) rIdx[idx] += 1;
     * }
     * return IntStream.range(1, rIdx.length - 1)
     *         .mapToObj(c -> rIdx[c] >= reinforces.length ? "_" : reinforces[rIdx[c]].substring(c - 1, c))
     *         .collect(Collectors.joining());
     * ```
     * @param reinforces
     * @param airstrikes
     * @return
     */
    public static String reinforcesMassacreBest(String[] reinforces, String[] airstrikes) {
        int[] rIdx = new int[reinforces[0].length() + 2];
        for (String a : airstrikes) {
            Set<Integer> massacre = new HashSet<>();
            int i = 0;
            for (char c : a.toCharArray()) {
                i++;
                if (c == '*') massacre.addAll(Arrays.asList(i - 1, i, i + 1));
            }
            for (int idx : massacre) rIdx[idx] += 1;
        }
        return IntStream.range(1, rIdx.length - 1)
                .mapToObj(c -> rIdx[c] >= reinforces.length ? "_" : reinforces[rIdx[c]].substring(c - 1, c))
                .collect(Collectors.joining());

    }
}
