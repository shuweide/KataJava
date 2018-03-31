package y2018.m03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * ### 2018/03/31
 *
 * There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the original string.
 *
 * A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before the next in the given string.
 * "whi" is a triplet for the string "whatisup".
 *
 * As a simplification, you may assume that no letter occurs more than once in the secret string.
 *
 * You can assume nothing about the triplets given to you other than that they are valid triplets and that
 * they contain sufficient information to deduce the original string. In particular,
 * this means that the secret string will never contain letters that do not occur in one of the triplets given to you.
 */
public class SecretDetective {

    private Map<String, Set<String>> letters = new HashMap<>();

    public String recoverSecret(char[][] triplets) {

        //process letter follower
        for (int i = 0; i < triplets.length; i++) {
            for (int j = 0; j < triplets[i].length; j++) {
                String letter = triplets[i][j] + "";
                if (!letters.containsKey(letter)) {
                    letters.put(letter, new HashSet<>());
                }
                for (int followIndex = j + 1; followIndex < triplets[i].length; followIndex++) {
                    Set<String> letterFollows = letters.get(letter);
                    letterFollows.add(triplets[i][followIndex] + "");
                }
            }
        }

        //combine word
        String[] word = new String[letters.size()];
        letters.keySet().forEach(key -> {
            int wordIndex = word.length - 1 - getAndMakeLetterFollowSet(key).size();
            word[wordIndex] = key;
        });

        return String.join("", word);
    }

    private Set<String> getAndMakeLetterFollowSet(String letter) {
        Set<String> result = new HashSet<>();
        if (letters.containsKey(letter)) {
            Set<String> letterSet = letters.get(letter);
            result.addAll(letterSet);
            letterSet.forEach(le -> result.addAll(getAndMakeLetterFollowSet(le)));
        }
        return result;
    }

    /**************************************************************************************/

    // This is a topological sort problem.
    // This is _not_ a particularly fast algorithm, and isn't general, but it's straightforward.

    // Convert the input format to the data structure I want to use
    private static Map<Character, Set<Character>> buildEdgeMap(char[][] triplets) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] cs : triplets) {
            for (char c : cs) {
                if (!map.containsKey(c)) map.put(c, new HashSet<>());
            }
            map.get(cs[0]).add(cs[1]);
            map.get(cs[1]).add(cs[2]);
        }
        return map;
    }

    // Find a node with no outgoing edges
    private static char findLast(Map<Character, Set<Character>> map) {
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No end point");
    }

    // Remove a node from the graph
    private static void remove(Map<Character, Set<Character>> map, Character c) {
        map.remove(c);
        for (Set<Character> cs : map.values()) {
            cs.remove(c);
        }
    }

    // Reconstruct the string
    public String recoverSecretBest(char[][] triplets) {
        StringBuilder builder = new StringBuilder();
        Map<Character, Set<Character>> map = buildEdgeMap(triplets);

        while (!map.isEmpty()) {
            char last = findLast(map);
            builder.insert(0, last);
            remove(map, last);
        }

        return builder.toString();
    }
}
