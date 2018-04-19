package y2018.m04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        return result.stream().sorted((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        }).collect(Collectors.joining("/"));
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
}


