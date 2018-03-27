package y2018.m03;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FinalNameConvert {
    public static String convert(String source) {
        //\p{Lu}找出大寫字母 \p{Ll}找出小寫字母
        String[] sources = source.split("(?=\\p{Lu})");
        return Arrays.stream(sources).map(String::toUpperCase).collect(Collectors.joining("_"));
    }
}
